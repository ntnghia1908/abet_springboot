package cseiu.abet.rest_controller;
import cseiu.abet.model.Student;
import cseiu.abet.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentControllerRest {
    private final StudentService studentService;

    public StudentControllerRest(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Student>> getAllStudent(){
//        List<Student> studentList = studentService.getAllStudent();
//        return new ResponseEntity<>(studentList, HttpStatus.OK);
//    }
//
//    @GetMapping("/getByMajor/{major}")
//    public ResponseEntity<List<Student>> getStudentByMajor(@PathVariable String major){
//        List<Student> studentList = studentService.getStudentByMajor(major);
//        return new ResponseEntity<>(studentList, HttpStatus.OK);
//    }
//
//    @GetMapping("/getByBatch/{batch}")
//    public ResponseEntity<List<Student>> getStudentByBatch(@PathVariable int batch){
//        List<Student> studentList = studentService.getStudentByBatch(batch);
//        return new ResponseEntity<>(studentList,HttpStatus.OK);
//    }
//
//    @GetMapping("/{batch}/{major}")
//    public ResponseEntity<List<Student>> getStudentByBatchAndMajor(@PathVariable int batch, @PathVariable String major){
//        List<Student> studentList = studentService.getStudentByBatchAndMajor(batch, major);
//        return new ResponseEntity<>(studentList,HttpStatus.OK);
//    }
}
