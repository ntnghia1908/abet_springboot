package cseiu.abet;
import cseiu.abet.model.Instructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cseiu.abet.model.ClassSession;
import cseiu.abet.services.ClassSessionService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClassSessionServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        ClassSessionService classSessionService = applicationContext.getBean(ClassSessionService.class);

        for (Instructor instructor: classSessionService.getTeachingInstructor()){
            System.out.println(instructor.getId());
        }
    }
}
