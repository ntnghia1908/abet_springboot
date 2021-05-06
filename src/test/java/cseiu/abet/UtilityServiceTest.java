package cseiu.abet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.services.UtilityService;
import cseiu.abet.model.Result;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class UtilityServiceTest {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(UtilityServiceTest.class, args);
        UtilityService utilityS = applicationContext.getBean(UtilityService.class);
        String excelFilePath = "F:/Documents/SCSE/TA/C Programming/testData.xlsx";
        List<Result> studentResult = utilityS.readStudentScoreFromExcelFile(excelFilePath);
        for (Result sr: studentResult){
            System.out.println(sr.getMidScore());

        }

    }
}
