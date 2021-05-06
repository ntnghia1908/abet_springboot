package cseiu.abet.services;
import cseiu.abet.model.Result;
import cseiu.abet.model.CourseAssessment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradingService {

    public List<Result> calculateGPA (List<Result> studentResultList, List<CourseAssessment> courseAssessmentList) {
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
        for (Result student: studentResultList){
            float gpa = (float) ((assignment_weight * student.getInClassScore()
                                            + midterm_weight *student.getMidScore()
                                            + final_weight * student.getFinalScore()) * 0.01);

            student.setGpa(Math.round(gpa));
        }
        return studentResultList;
    }
}
