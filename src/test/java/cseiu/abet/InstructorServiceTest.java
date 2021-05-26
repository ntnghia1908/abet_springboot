package cseiu.abet;

import cseiu.abet.model.Account;
import cseiu.abet.model.Instructor;
import cseiu.abet.services.AccountService;
import cseiu.abet.services.InstructorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InstructorServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(InstructorServiceTest.class, args);
        InstructorService instructorSevice = applicationContext.getBean(InstructorService.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);

        Account account = new Account();
        account.setId(2);
        account.setUser_name("tttung");
        account.setPassword("ttung");
        account.setInstructor(new Instructor(10));
        account.setUser_role("admin");
        accountService.addAccount(account);

//        account = accountService.checkLogin("nttsang", "nttsang");
//        System.out.println(account.getId());

//        // FIND ALL INSTRUCTOR//
//        for (Instructor instructor: instructorSevice.findAllInstructor()){
//            System.out.println(instructor.getName());
//        }
//
//        //FIND SPECIFIC INSTRUCTOR//
//        Instructor instructor = instructorSevice.findInstructorById(2);
//        System.out.println(instructor.getName()+"---"+instructor.getEmail());
//
//        //ADD NEW INSTRUCTOR
//        Instructor new_instructor = new Instructor();
//        new_instructor.setId(34);
//        new_instructor.setName("Le Duy Tan");
//        instructorSevice.addInstructor((new_instructor));
//
//        //UPDATE INSTRUCTOR//
//        Instructor update_instructor = instructorSevice.findInstructorById(4);
//        update_instructor.setDegree("Assof.Pro.Dr");
//
//        //DELETE INSTRUCTOR
//        instructorSevice.deleteInstructor(33);
      //  System.out.println(instructorSevice.searchInstructorIdByName("Nguyen Thi Thanh Sang"));


    }
}
