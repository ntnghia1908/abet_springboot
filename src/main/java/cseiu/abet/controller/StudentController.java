package cseiu.abet.controller;
import cseiu.abet.model.Result;
import cseiu.abet.model.Student;
import cseiu.abet.services.ResultService;
import cseiu.abet.services.StudentService;
import cseiu.abet.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final ResultService resultService;
    private final UtilityService utilityService;
    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");


    public StudentController(StudentService studentService, ResultService resultService, UtilityService utilityService) {

        this.studentService = studentService;
        this.resultService = resultService;
        this.utilityService = utilityService;
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

    @RequestMapping("/add")
    public String showNewStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "admin/student-edit";
    }

    @RequestMapping("/edit/{student_id}")
    public String showUpdateStudentPage(@PathVariable("student_id") String student_id, Model model){
        Student student = studentService.getStudentByID(student_id);
        model.addAttribute("student", student);
        return "admin/student-edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String editInstructor (@ModelAttribute("student") Student student, Model model) {
        studentService.addStudent(student);
        model.addAttribute("student", student);
        return "admin/student-detail";
    }

    @RequestMapping(value ="/saveAuto", method = RequestMethod.POST)
    public String saveStudentAutomatic(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {

//        List<Student> studentList = utilityService.readStudentListFromExcelFile(path);
//        for (Student student: studentList){
//            studentService.addStudent(student); }

        return "redirect:/student/all";
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
