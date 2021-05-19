package cseiu.abet;
import cseiu.abet.model.CourseAssessmentPK;
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

        // FIND COURSE ASSESSMENT OF GIVEN COURSE
        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId("IT079");
        for (CourseAssessment c: courseAssessmentList){
        }

//        // ADD COURSE ASSESSMENT FOR GIVEN COURSE
//        CourseAssessment courseAssessment = new CourseAssessment();
//        courseAssessment.setCourseAssessmentPK(new CourseAssessmentPK(3,"IT002"));
//        courseAssessment.setPercentage(30);
//        courseAssessmentService.addCourseAssessment(courseAssessment);

//        //UPDATE COURSE ASSESSMENT FOR GIVEN COURSE
//        CourseAssessment ca = courseAssessmentService.getByCourseAndAssessment("IT002",3);
//        ca.setPercentage(40);
//        courseAssessmentService.updateCourseAssessment(ca);

        //DELETE COURSE ASSESSMENT
//        courseAssessmentService.deleteCourseAssessment("IT002",3);


    }
}
