package cseiu.abet;
import cseiu.abet.model.Assessment;
import cseiu.abet.model.AssessmentToolPK;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.model.AssessmentTool;
import cseiu.abet.services.AssessmentToolService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@SpringBootApplication
public class AssessmentServiceTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CourseServiceTest.class, args);
        AssessmentToolService assessmentToolService = applicationContext.getBean(AssessmentToolService.class);


        // FIND ASSESSMENT TOOL FOR GIVEN COURSE
        List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse("IT079");
        Hashtable<Integer, List> new_ass_tools = new Hashtable<>();
        Hashtable<Integer, String> listLearningOutcome = new Hashtable<>();

        for (AssessmentTool as: assessmentToolList) {
            listLearningOutcome.put(as.getLearningOutcome().getId(), as.getLearningOutcome().getDescription());

        }

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
