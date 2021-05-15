package cseiu.abet;

import cseiu.abet.model.Course;
import cseiu.abet.services.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CourseServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        CourseService courseService = applicationContext.getBean(CourseService.class);
//        Course c = courseService.findCourseById("IT079");
        courseService.deleteCourse("IT002");
//        System.out.println(c.getId());
    }
}
