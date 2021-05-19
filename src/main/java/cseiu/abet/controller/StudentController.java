package cseiu.abet.controller;
import cseiu.abet.model.Result;
import cseiu.abet.model.Student;
import cseiu.abet.services.ResultService;
import cseiu.abet.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final ResultService resultService;
    public final String templateDir = "student/";
    public final String defaultUrl = "student/index";

    public StudentController(StudentService studentService, ResultService resultService) {

        this.studentService = studentService;
        this.resultService = resultService;
    }

    @GetMapping("/all")
    public String getAllStudent(Model model){
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("studentList", studentList);
        return "admin/student-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name="id") String id){
        studentService.deleteStudent(id);
        return "redirect:/student/all";
    }
     @RequestMapping("view/{id}")
    public String viewStudentInfor(@PathVariable(name="id") String id, Model model){
        Student student = studentService.getStudentByID(id);
        List<Result> studentResults = resultService.getResultByStudent(id);
        model.addAttribute("studentResults", studentResults);
        model.addAttribute("student", student);
        return "admin/student-detail";
     }

//    @GetMapping("/getByMajor/{major}")
//    public String getStudentByMajor(@PathVariable String major, Model model){
//        List<Student> studentList = studentService.getStudentByMajor(major);
//        model.addAttribute("studentListByMajor", studentList);
//        return "student";
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
