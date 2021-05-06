package cseiu.abet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.services.CourseAssessmentService;

@SpringBootApplication
public class CourseAssessmentServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);
        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId("IT079");
        for (CourseAssessment c: courseAssessmentList){
            System.out.println(c.getCourseAssessmentPK().getAssessmentId());
        }
    }
}
