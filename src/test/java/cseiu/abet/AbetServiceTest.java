package cseiu.abet;

import cseiu.abet.model.CloSlo;
import cseiu.abet.services.AbetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AbetServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AbetServiceTest.class, args);
        AbetService abetService = applicationContext.getBean(AbetService.class);

        for (CloSlo cloSlo: abetService.getAbetMappingTable("IT079")){
            System.out.println(cloSlo.getCloSloPK().getLoId()+"--"+cloSlo.getCloSloPK().getSloId()+"--"+cloSlo.getPercentage());
        }




    }
}
