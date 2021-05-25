package cseiu.abet;

import cseiu.abet.model.*;
import cseiu.abet.services.*;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

@SpringBootApplication
public class CourseServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);
        CourseService courseServiceTest = applicationContext.getBean(CourseService.class);
        LearningOutcomeService learningOutcomeService = applicationContext.getBean(LearningOutcomeService.class);
        AbetService abetService = applicationContext.getBean(AbetService.class);

        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseWithoutComboAss("IT079");
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse("IT079");

        Hashtable<Integer, Hashtable> newAssessmentTool = new Hashtable<>();
        for (LearningOutcome lo: learningOutcomeList){
            Hashtable<Integer, Float> item = new Hashtable<>();
            for (CourseAssessment ca: courseAssessmentList){
                if (assessmentToolService.getByCourseAssessmentAndLO("IT079",ca.getCourseAssessmentPK().getAssessmentId(),lo.getId()) !=null){
                    item.put(ca.getCourseAssessmentPK().getAssessmentId(),assessmentToolService.getByCourseAssessmentAndLO("IT079", ca.getCourseAssessmentPK().getAssessmentId(), lo.getId()).getPercentage());
                }else{
                    item.put(ca.getCourseAssessmentPK().getAssessmentId(),0F);
                }
            }
            newAssessmentTool.put(lo.getId(),item);
         }
        System.out.println(newAssessmentTool);

        System.out.println(abetService.getAbetMappingForCloSlo(99,1));

        Hashtable<Integer, Hashtable> abetMapping = new Hashtable<>();
        for (LearningOutcome lo: learningOutcomeList){
            Hashtable<Integer,Float> item = new Hashtable<>();
            for (int slo=1;slo<7; slo++){
                if (abetService.getAbetMappingForCloSlo(lo.getId(),slo)!=null){
                    item.put(slo, abetService.getAbetMappingForCloSlo(lo.getId(),slo).getPercentage());
                }else{
                    item.put(slo,0F);
                }
            }
            abetMapping.put(lo.getId(),item);
        }
        System.out.println(abetMapping);
//        CourseService courseService = applicationContext.getBean(CourseService.class);
        // TEST INSERT COURSE
//        Course newCourse = new Course("IT002", "Mon test", "Test Course");
//        newCourse.setCourseLevel(new CourseLevel(1));
//        courseService.addCourse(newCourse);

        // TEST UPDATE COURSE
//        Course course = courseService.findCourseById("IT002");
//        course.setName("Test course");
//        courseService.updateCourses(course);

//        DELETE COURSE
//        courseService.deleteCourse("CH012");

        //FIND ALL COURSE
//        for (Course c: courseService.getAllCourse()){
//            System.out.println(c.getName());
//        }

        //TEST SEARCH COURSENAME
//        for (String name: courseService.searchCourseName("prog")){
//            System.out.println(name);
//        }

//        AccountService accountService = applicationContext.getBean(AccountService.class);
//
//        Account account = new Account();
//        account.setId(1);
//        account.setUser_name("nttsang");
//        account.setPassword("nttsang");
//        account.setInstructor(new Instructor(11));
//        account.setUser_role("admin");
//        accountService.addAccount(account);
    }
}
