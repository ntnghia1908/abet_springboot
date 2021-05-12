package cseiu.abet;
import cseiu.abet.model.AssessmentTool;
import cseiu.abet.services.AssessmentToolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.*;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.model.CloSlo;
import cseiu.abet.services.CourseAssessmentService;
import cseiu.abet.model.Result;
import cseiu.abet.services.UtilityService;
import cseiu.abet.services.GradingService;
import cseiu.abet.services.AbetService;
@SpringBootApplication
public class GradingServiceTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(GradingServiceTest.class, args);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);
        UtilityService utilityService = applicationContext.getBean(UtilityService.class);
        GradingService gradingService = applicationContext.getBean(GradingService.class);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);
        AbetService  abetService = applicationContext.getBean(AbetService.class);

       // String excelFilePath = "F:/Documents/SCSE/TA/C Programming/testData.xlsx";
        String excelFilePath = "/Users/minhthu/Documents/IU/Project/IT079.xlsx";
        List<Result> studentResult = utilityService.readStudentScoreFromExcelFile(excelFilePath);

        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId("IT079");

        List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse("IT079");

        List<CloSlo> abetMapping = abetService.getAbetMappingTable("IT079");

        for (Result student: studentResult){
            System.out.println(gradingService.calculateGPA(student,courseAssessmentList).getGpa());
        }

    //    List<Result> gpaResult = gradingService.calculateGPA(studentResult, courseAssessmentList);

//        for (Result r: gpaResult){
//            System.out.println(r.getStudent().getId());
//        }
//
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
//     //   System.out.println(gradingService.transferAndConvertAbetMapping(abetMapping));
//        String excelOutputPath = "/Users/minhthu/Documents/IU/Project/IT079_result.xlsx";
//        utilityService.writeResultToExcelFile(gpaResult,excelOutputPath);
    }
}
