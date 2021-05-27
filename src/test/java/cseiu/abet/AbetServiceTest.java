package cseiu.abet;

import cseiu.abet.model.ClassSloClo;
import cseiu.abet.model.ClassSloCloPK;
import cseiu.abet.model.CloSlo;
import cseiu.abet.services.AbetService;
import cseiu.abet.services.ClassSloCloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AbetServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AbetServiceTest.class, args);
        AbetService abetService = applicationContext.getBean(AbetService.class);
        ClassSloCloService classSloCloService = applicationContext.getBean((ClassSloCloService.class));




//        for (CloSlo cloSlo: abetService.getAbetMappingTable("IT079")){
//            System.out.println(cloSlo.getCloSloPK().getLoId()+"--"+cloSlo.getCloSloPK().getSloId()+"--"+cloSlo.getPercentage());
//            ClassSloClo item = new ClassSloClo();
//            item.setClassSloCloPK(new ClassSloCloPK(cloSlo.getCloSloPK().getLoId(), cloSlo.getCloSloPK().getSloId(), 20 ));
//            item.setPercentage(20F);
//            System.out.println(item.getClassSloCloPK().getClo_id()+"--"+item.getClassSloCloPK().getSloId()+"--"+item.getPercentage());
//        }




    }
}
