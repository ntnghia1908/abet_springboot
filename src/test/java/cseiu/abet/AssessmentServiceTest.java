package cseiu.abet;
import cseiu.abet.model.*;
import cseiu.abet.services.CourseAssessmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.services.AssessmentToolService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@SpringBootApplication
public class AssessmentServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);
        CourseAssessmentService courseAssessmentService = applicationContext.getBean(CourseAssessmentService.class);


        // FIND ASSESSMENT TOOL FOR GIVEN COURSE
        List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse("IT079");
        Hashtable<Integer, Hashtable> new_ass_tools = new Hashtable<>();
        Hashtable<Integer, String> listLearningOutcome = new Hashtable<>();
        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseWithoutComboAss("IT079");

        for (AssessmentTool as: assessmentToolList) {
            listLearningOutcome.put(as.getLearningOutcome().getId(), as.getLearningOutcome().getDescription());
            Hashtable<Integer, Float> listPercentage = new Hashtable<>();
            for (CourseAssessment ca: courseAssessmentList){
                int count =0;
                for (AssessmentTool at: assessmentToolList){
                    if (at.getAssessment().getId() == ca.getAssessment().getId()
                        && at.getLearningOutcome().getId() == as.getLearningOutcome().getId()){
                        listPercentage.put(at.getAssessment().getId(), at.getPercentage());
                        count =1;
                        break;
                    }
                }
                if (count==0){
                    listPercentage.put(ca.getAssessment().getId(),0F);
                }

            }
            new_ass_tools.put(as.getLearningOutcome().getId(), listPercentage);

        }
        System.out.println(new_ass_tools.get(101));
//        //ADD ASSESSMENT TOOL FOR GIVEN COURSE
//        AssessmentTool as = new AssessmentTool();
//        as.setAssessmentToolPK(new AssessmentToolPK(1, "IT002",1));
//        assessmentToolService.addAssessmentTool(as);
//
//        //UPDATE ASSESSMENT TOOL
//        AssessmentTool ast = assessmentToolService.getByCourseAssessmentAndLO("IT002",1,1);
//        ast.setPercentage(40F);
//        assessmentToolService.updateAssessmentTool(ast);

        //DELETE ASSESSMENT TOOL
     //   assessmentToolService.deleteAssessmentTool("IT002",1,1);
    }
}
