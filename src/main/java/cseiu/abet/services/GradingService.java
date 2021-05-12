package cseiu.abet.services;
import cseiu.abet.model.Result;
import cseiu.abet.model.AssessmentTool;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.model.CloSlo;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Service
public class GradingService {

    // CALCULATE THE GPA OF LIST OF STUDENTS//
    public Result calculateGPA (Result student, List<CourseAssessment> courseAssessmentList) {
        int assignment_weight =0, midterm_weight=0, final_weight=0;
        for(CourseAssessment ca: courseAssessmentList){
            switch (ca.getCourseAssessmentPK().getAssessmentId()){
                case 10:
                    assignment_weight = ca.getPercentage();
                    break;
                case 4:
                    midterm_weight = ca.getPercentage();
                    break;
                case 6:
                    final_weight = ca.getPercentage();
                    break;
            }
        }

        float gpa = (float) ((assignment_weight * student.getInClassScore()
                                            + midterm_weight *student.getMidScore()
                                            + final_weight * student.getFinalScore()) * 0.01);

        student.setGpa(Math.round(gpa));

        return student;
    }

    // CACLUATE THE ABET SCORE OF STUDENT//
        //1. Calculate the Course Learning Outcome Score of each student
            //1.1. Convert the assessment tools table into 3 types of assessment
    public static Hashtable<Integer,Float> calculatePercentageOfEachAssignmentType(List<CourseAssessment> courseAssessmentList){
        Hashtable<Integer,Float> convert_ass = new Hashtable<>();
        int assignment_weight =0;
        for (CourseAssessment ca: courseAssessmentList) {
            if (ca.getCourseAssessmentPK().getAssessmentId()==10) {
                assignment_weight = ca.getPercentage();
            }
        }
        for (CourseAssessment ca: courseAssessmentList) {
            switch (ca.getCourseAssessmentPK().getAssessmentId()) {
                case 4:
                    break;
                case 6:
                    break;
                case 10:
                    break;
                default:
                    convert_ass.put(ca.getCourseAssessmentPK().getAssessmentId(),(float)ca.getPercentage()/assignment_weight);
                    break;
            }
        }
        return convert_ass;
    }

    public static Hashtable <Integer, Hashtable> convertAssessmentToolTable
            (List<AssessmentTool> assessmentToolList,List<CourseAssessment> courseAssessmentList){
        Hashtable<Integer, Float> new_ass_weights = calculatePercentageOfEachAssignmentType( courseAssessmentList);
        Hashtable<Integer, Hashtable> convert_assignment_at = new Hashtable<>();
        for (AssessmentTool cat: assessmentToolList) {
            float new_weight = 0;
            Hashtable <Integer,Float> item = new Hashtable<>();
            for (AssessmentTool at: assessmentToolList) {
                if (cat.getLearningOutcome().getId()==at.getLearningOutcome().getId()) {
                    if (at.getAssessment().getId()!=4 && at.getAssessment().getId()!=6) {
                        new_weight+= new_ass_weights.get(at.getAssessment().getId()) * at.getPercentage();
                    }else {
                        item.put(at.getAssessment().getId(),at.getPercentage());
                    }
                }
            }
            item.put(10,new_weight);
            convert_assignment_at.put(cat.getLearningOutcome().getId(),item);
        }
        return convert_assignment_at;
    }

            //1.2 Calculate the course learning outcome of each student
    public static float getNumberFromHashtable (Hashtable hasta, int index) {
        float result =0;
        if (hasta.get(index)!= null) {
            result = (float) hasta.get(index);
        }
        return result;
    }

    public  Hashtable <Integer, Float> calculateLearningOutcomeScore
            (List<AssessmentTool> assessment_tools,List<CourseAssessment> course_assessment, Result studentResult){
        Hashtable <Integer, Float> list_LO_scores = new Hashtable<>();
        Hashtable<Integer, Hashtable> convert_assignment_at =  convertAssessmentToolTable(assessment_tools,course_assessment);
        Set<Integer> list_loId = convert_assignment_at.keySet();
        for(int learningOutcomeID: list_loId) {
            //int learningOutcomeID = list_loId.nextElement();
            try {
                Hashtable<Integer, Float> weights = convert_assignment_at.get(learningOutcomeID);
                float total_weight =  getNumberFromHashtable(weights, 10)
                        + getNumberFromHashtable(weights, 4)
                        + getNumberFromHashtable(weights, 6);
                float score =  (getNumberFromHashtable(weights, 10) * studentResult.getInClassScore()
                        + getNumberFromHashtable(weights, 4)  * studentResult.getMidScore()
                        + getNumberFromHashtable(weights, 6) * studentResult.getFinalScore())/total_weight;
                list_LO_scores.put(learningOutcomeID,score);
            } catch (Exception e) {
            }
        }
        return list_LO_scores;
    }

        //2. Calculate the ABET score of Student
            //2.1. Convert ABET mapping table into Hashtable
    public  Hashtable <Integer, Hashtable> transferAndConvertAbetMapping (List<CloSlo> abetMapping){
        Hashtable<Integer, Float> sumPercentageOfEachCriteria = new Hashtable<>();
        Hashtable<Integer,Hashtable> abetMappingAfterConvert = new Hashtable<>();

        for (CloSlo cloSlo: abetMapping){
            float total_weight =0;
            for (CloSlo item:abetMapping){
                if (cloSlo.getCloSloPK().getSloId() == item.getCloSloPK().getSloId()){
                    total_weight+= item.getPercentage();
                }
            }
            sumPercentageOfEachCriteria.put(cloSlo.getCloSloPK().getSloId(), total_weight);
        }
        for (CloSlo cloSlo: abetMapping){
            Hashtable<Integer,Float> newAbetMapping = new Hashtable<>();
            for (CloSlo item: abetMapping){
                if (item.getCloSloPK().getSloId() == cloSlo.getCloSloPK().getSloId()){
                    newAbetMapping.put(item.getLearningOutcome().getId(), (float) item.getPercentage()/sumPercentageOfEachCriteria.get(cloSlo.getCloSloPK().getSloId()));
                }
            }
            abetMappingAfterConvert.put(cloSlo.getCloSloPK().getSloId(),newAbetMapping);
        }
        return abetMappingAfterConvert;
    }

            //2.2 Calculate ABET score

    public Result storeStudentAbetResult (Result student, Hashtable <Integer, Float> abetScore){
        Set<Integer> listAbetCriteria = abetScore.keySet();
        for (int criteria:listAbetCriteria){
            switch (criteria){
                case 1:
                    student.setAbet1(Math.round((abetScore.get(criteria))));
                    break;
                case 2:
                    student.setAbet2(Math.round((abetScore.get(criteria))));
                    break;
                case 3:
                    student.setAbet3(Math.round((abetScore.get(criteria))));
                    break;
                case 4:
                    student.setAbet4(Math.round((abetScore.get(criteria))));
                    break;
                case 5:
                    student.setAbet5(Math.round((abetScore.get(criteria))));
                    break;
                case 6:
                    student.setAbet6(Math.round((abetScore.get(criteria))));
                    break;
            }
        }
        return student;
    }

    public Result calculateAbetScoreOfStudent
            (List<AssessmentTool> assessmentToolList, List<CourseAssessment> courseAssessmentList,
             List<CloSlo> cloSlo, Result student) {
        Hashtable<Integer,Float> learningOutcomeScore = calculateLearningOutcomeScore(assessmentToolList,courseAssessmentList,student);
        Hashtable<Integer,Hashtable> newAbetMapping = transferAndConvertAbetMapping(cloSlo);

        Hashtable<Integer,Float> abetScore = new Hashtable<>();
        Set<Integer> abetCriterias = newAbetMapping.keySet();
        float total_score = 0;
        for (int criteria: abetCriterias) {
            try {
                float score =0;
                Hashtable<Integer, Float> abetPercentage = newAbetMapping.get(criteria);
                Set<Integer> learningOutcomeId = abetPercentage.keySet();
                for (int lo_id:learningOutcomeId){
                    score+= abetPercentage.get(lo_id) * learningOutcomeScore.get(lo_id);
                }
                abetScore.put(criteria,score);
                total_score+=score;
            } catch (Exception e) {

            }

        }
        storeStudentAbetResult(student, abetScore);
        student.setAbetScore(Math.round( total_score/abetCriterias.size()));
        return student;
    }
}

