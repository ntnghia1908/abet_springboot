package cseiu.abet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.model.AssessmentTool;
import cseiu.abet.services.AssessmentToolService;

@SpringBootApplication
public class AssessmentServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);

        System.out.println(assessmentToolService.getAssessmentTootTableByCourse("IT079").toString());
    }
}
