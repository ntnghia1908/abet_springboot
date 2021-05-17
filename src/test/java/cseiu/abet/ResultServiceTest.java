package cseiu.abet;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Result;
import cseiu.abet.services.UtilityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import cseiu.abet.services.ResultService;

import java.util.List;

@SpringBootApplication
public class ResultServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ResultServiceTest.class, args);
        ResultService resultService = applicationContext.getBean(ResultService.class);
        UtilityService utilityService = applicationContext.getBean(UtilityService.class);

        //Add list of students to class (by upload excel file)
        String excelFilePath = "/Users/minhthu/Documents/IU/Project/IT079_studentList.xlsx";
        List<Result> lists = utilityService.readStudentScoreFromExcelFile(excelFilePath);
        for (Result r: lists){
           r.setClass1(new ClassSession(10));
          //  resultService.addResultToClass(r);
            System.out.println(r.getClass1().getId()+"---"+r.getStudent().getId()+"---"+r.getInClassScore());
            resultService.addResultToClass(r);
        }


//        //Find the results of all students in specific class
//        for (Result r: resultService.getResultByClass(10)){
//            System.out.println(r.getStudent().getName());
//        }
//
//        //Find the result of a given students in all classes
//        for (Result r: resultService.getResultByStudent("ITITIU19002")){
//            System.out.println(r.getClass1().getCourse().getName());
//        }
//
//        //Find the result of a given student in a specific class
//        Result r = resultService.getResultByStudentAndClass("ITITIU18102", 10);
//        System.out.println(r.getClass1().getCourse().getName());
    }
}
