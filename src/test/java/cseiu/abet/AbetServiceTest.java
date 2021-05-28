package cseiu.abet;

import cseiu.abet.model.*;
import cseiu.abet.services.AbetService;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.ClassSloCloService;
import cseiu.abet.services.LearningOutcomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AbetServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AbetServiceTest.class, args);
        AbetService abetService = applicationContext.getBean(AbetService.class);
        ClassSloCloService classSloCloService = applicationContext.getBean((ClassSloCloService.class));
        LearningOutcomeService learningOutcomeService = applicationContext.getBean(LearningOutcomeService.class);
        ClassSessionService classSessionService = applicationContext.getBean(ClassSessionService.class);

        List<ClassSloClo> classSloClos = new ArrayList<>();
        ClassSloClo item1 = new ClassSloClo(new ClassSloCloPK(99,1,55), 100F, new Slo(1), new LearningOutcome(99));
        ClassSloClo item2 = new ClassSloClo(new ClassSloCloPK(100,2,55), 100F, new Slo(2), new LearningOutcome(100));
        ClassSloClo item3 = new ClassSloClo(new ClassSloCloPK(101,2,55), 40F, new Slo(2), new LearningOutcome(101));
        ClassSloClo item4 = new ClassSloClo(new ClassSloCloPK(101,6,55), 60F, new Slo(6), new LearningOutcome(101));

        classSloClos.add(item1);
        classSloClos.add(item2);
        classSloClos.add(item3);
        classSloClos.add(item4);

        List<LearningOutcome> lo = learningOutcomeService.getLOByCourse(classSessionService.getClassById(55).getCourse().getId());
        List<ClassSloClo> classSloCloList = classSloCloService.getAbetMappingForClass(55);
        for (ClassSloClo c: classSloCloList){
            System.out.println(c.getSloId().getId()+"--"+c.getLearningOutcomeId().getId()+"--"+c.getPercentage());
        }
        System.out.println(classSloCloService.checkValidation(classSloCloList, lo));


//        for (CloSlo cloSlo: abetService.getAbetMappingTable("IT079")){
//            System.out.println(cloSlo.getCloSloPK().getLoId()+"--"+cloSlo.getCloSloPK().getSloId()+"--"+cloSlo.getPercentage());
//            ClassSloClo item = new ClassSloClo();
//            item.setClassSloCloPK(new ClassSloCloPK(cloSlo.getCloSloPK().getLoId(), cloSlo.getCloSloPK().getSloId(), 20 ));
//            item.setPercentage(20F);
//            System.out.println(item.getClassSloCloPK().getClo_id()+"--"+item.getClassSloCloPK().getSloId()+"--"+item.getPercentage());
//        }




    }
}
