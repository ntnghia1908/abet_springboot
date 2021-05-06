package cseiu.abet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.*;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.services.CourseAssessmentService;
import cseiu.abet.model.Result;
import cseiu.abet.services.UtilityService;
import cseiu.abet.services.GradingService;

@SpringBootApplication
public class GradingServiceTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(GradingServiceTest.class, args);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);
        UtilityService utilityService = applicationContext.getBean(UtilityService.class);
        GradingService gradingService = applicationContext.getBean(GradingService.class);

        String excelFilePath = "F:/Documents/SCSE/TA/C Programming/testData.xlsx";
        List<Result> studentResult = utilityService.readStudentScoreFromExcelFile(excelFilePath);

        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId("IT079");

        List<Result> gpaResult = gradingService.calculateGPA(studentResult, courseAssessmentList);

        for (Result r: gpaResult){
            System.out.println(r.getGpa());
        }
    }
}
