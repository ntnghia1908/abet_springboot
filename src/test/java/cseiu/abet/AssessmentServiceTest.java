package cseiu.abet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.model.AssessmentTool;
import cseiu.abet.services.AssessmentToolService;

import java.util.List;

@SpringBootApplication
public class AssessmentServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);
        List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse("IT079");
        for (AssessmentTool as: assessmentToolList){
            System.out.println(as.getAssessment().getId());
        }
    }
}
