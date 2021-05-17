package cseiu.abet;
import cseiu.abet.model.Course;
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

//        System.out.println("Find all classes in given semester of the year");
//        for (ClassSession classSession: classSessionService.getClassSessionBySemesterAndYear(2,"2020-2021")){
//            System.out.println(classSession.getId());
//        }
//
//        System.out.println("Find all classes taught by instructor");
//        for (ClassSession classSession: classSessionService.findClassGivenInstructor(1)){
//            System.out.println(classSession.getId());
//        }
//
//        System.out.println("Find all classes taught by instructor in specific academic year");
//        for (ClassSession classSession: classSessionService.getClassSessionByInstructorAndYear(1, "2020-2021")){
//            System.out.println(classSession.getId());
//        }

//        System.out.println("Find all classes taught by instructor in specific semester and academic year");
//        for (ClassSession classSession:classSessionService.getClassSession(1,1,"2020-2021")){
//            System.out.println(classSession.getId());
//        }
//        System.out.println("Find all classes of the given course");
//        for (ClassSession classSession: classSessionService.getClassSessionByCourse("IT079")){
//            System.out.println(classSession.getId());
//        }
//
//        System.out.println("Find all classes of the given course in that academic year");
//        for (ClassSession classSession: classSessionService.getClassSessionByCourseAndYear("IT079", "2020-2021")){
//            System.out.println(classSession.getId());
//        }
//
//        System.out.println("Find all classes of the given course in that semester and academic year");
//        for (ClassSession classSession: classSessionService.getClassSessionByCourseAndSemAndYear("IT079", 2, "2017-2018")){
//            System.out.println(classSession.getId());
//        }

        //INSERT NEW CLASS
//        ClassSession classSession = new ClassSession();
//        classSession.setCourse(new Course("IT116"));
//        classSession.setId(16);
//        classSession.setInstructorId(new Instructor(1));
//        classSession.setAcademicYear("2020-2021");
//        classSession.setGroupTheory(1);
//        classSession.setGroupLab(1);
//        classSession.setSemester(3);
//        classSessionService.addClassSession(classSession);

        //UPADET CLASS
//        ClassSession classSession = classSessionService.getClassById(16);
//        classSession.setInstructorId(new Instructor(4));
//        classSessionService.updateClassSession(classSession);

        //DELETE CLASS
//        ClassSession classSession = classSessionService.getClassById(16);
//        classSessionService.deleteClass(classSession);


    }
}
