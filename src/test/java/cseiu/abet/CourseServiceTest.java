package cseiu.abet;

import cseiu.abet.model.Course;
import cseiu.abet.model.CourseLevel;
import cseiu.abet.services.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CourseServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        CourseService courseService = applicationContext.getBean(CourseService.class);
        // TEST INSERT COURSE
//        Course newCourse = new Course("IT002", "Mon test", "Test Course");
//        newCourse.setCourseLevel(new CourseLevel(1));
//        courseService.addCourse(newCourse);

        // TEST UPDATE COURSE
//        Course course = courseService.findCourseById("IT002");
//        course.setName("Test course");
//        courseService.updateCourses(course);

        //DELETE COURSE
//        courseService.deleteCourse("IT002");

        //FIND ALL COURSE
//        for (Course c: courseService.getAllCourse()){
//            System.out.println(c.getName());
//        }

    }
}
