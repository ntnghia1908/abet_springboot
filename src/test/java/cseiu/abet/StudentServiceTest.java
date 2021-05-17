package cseiu.abet;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import cseiu.abet.model.Student;
import cseiu.abet.services.StudentService;
import cseiu.abet.services.UtilityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication

public class StudentServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StudentServiceTest.class, args);
        StudentService studentService = applicationContext.getBean(StudentService.class);
        UtilityService utilityService = applicationContext.getBean(UtilityService.class);

        //INSERT NEW STUDENT
//        Student student = new Student();
//        student.setId("ITITIU2001");
//        student.setName("Nguyen Van A");
//        studentService.addStudent(student);

        //UPDATE STUDENT
//        Student student = studentService.getStudentByID("ITITIU2001");
//        student.setName("Nguyen Thi A");
//        student.setBatch(2020);
//        student.setMajor("IT");
//        studentService.updateStudent(student);

        // DELETE STUDENT
       // studentService.deleteStudent("ITITIU2001");

        //FIND LIST OF STUDENTS
//        for (Student s: studentService.getAllStudent()){
//            System.out.println(s.getName());
//        }
//        //FIND LIST OF STUDENT BY MAJOR
//        for (Student s: studentService.getStudentByMajor("DS")){
//            System.out.println(s.getName());
//        }
//        //FIND LIST OF STUDENT BY BATCH
//        for (Student s: studentService.getStudentByBatch(2018)){
//            System.out.println(s.getName());
//        }
//        //FIND STUDENT BY BATCH AND MAJOR
//        for (Student s: studentService.getStudentByBatchAndMajor(2018, "IT")){
//            System.out.println(s.getName());
//        }

        // IMPORT STUDENTS BY UPLOADING EXCEL FILE
//        String studentFilePath ="/Users/minhthu/Documents/IU/Project/studentList.xlsx";
//        List<Student> studentList = utilityService.readStudentListFromExcelFile(studentFilePath);
//        for (Student s: studentList){
//            studentService.addStudent(s);
//            studentService.deleteStudent(s.getId());
   //     }



    }
}
