package cseiu.abet;
import cseiu.abet.model.*;
import cseiu.abet.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class GradingServiceTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(GradingServiceTest.class, args);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);
        UtilityService utilityService = applicationContext.getBean(UtilityService.class);
        GradingService gradingService = applicationContext.getBean(GradingService.class);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);
        AbetService  abetService = applicationContext.getBean(AbetService.class);
        ResultService resultService =applicationContext.getBean(ResultService.class);


       // String excelFilePath = "F:/Documents/SCSE/TA/C Programming/testData.xlsx";
//        String excelFilePath = "/Users/minhthu/Documents/IU/Project/IT079.xlsx";
//        List<Result> studentResult = utilityService.readStudentScoreFromExcelFile(excelFilePath);
//
//        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId("IT079");
//
//        List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse("IT079");
//
//        List<CloSlo> abetMapping = abetService.getAbetMappingTable("IT079");
//
//        for (Result student: studentResult){
//         //   System.out.println(gradingService.calculateGPA(student,courseAssessmentList).getGpa());
//        }


//        List<Result> finalResult = new ArrayList<>();
//        for (Result result: studentResult){
//            gradingService.calculateGPA(result, courseAssessmentList);
//            gradingService.calculateAbetScoreOfStudent(assessmentToolList,courseAssessmentList,abetMapping,result);
//            result.setResultPK(new ResultPK(result.getStudent().getId(), 10));
//            resultService.addStudentToClass(result);
//            finalResult.add(gradingService.calculateAbetScoreOfStudent(assessmentToolList,courseAssessmentList,abetMapping,result));
//
//        }

//        for (Result r: studentResult){
//            System.out.println(gradingService.calculateLearningOutcomeScore(assessmentToolList,courseAssessmentList,r));
//        }
//
//        for (CloSlo cloSlo: abetMapping){
//            System.out.println(cloSlo.getLearningOutcome().getId());
//        }
//
//        for (Result r: studentResult){
//            System.out.println(gradingService.calculateAbetScoreOfStudent(assessmentToolList,courseAssessmentList,abetMapping,r).getAbet4());
//        }
     //   System.out.println(gradingService.transferAndConvertAbetMapping(abetMapping));
//        String excelOutputPath = "/Users/minhthu/Documents/IU/Project/IT079_result.xlsx";
//        utilityService.writeResultToExcelFile(finalResult,excelOutputPath);
    }
}
