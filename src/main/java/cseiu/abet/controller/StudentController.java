package cseiu.abet.controller;
import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Result;
import cseiu.abet.model.Student;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.ResultService;
import cseiu.abet.services.StudentService;
import cseiu.abet.services.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final ResultService resultService;
    private final UtilityService utilityService;
    private final ClassSessionService classSessionService;
    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");


    public StudentController(StudentService studentService, ResultService resultService, UtilityService utilityService, ClassSessionService classSessionService) {

        this.studentService = studentService;
        this.resultService = resultService;
        this.utilityService = utilityService;
        this.classSessionService = classSessionService;
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
    public String addStudent (@ModelAttribute("student") Student student, Model model) {
        studentService.addStudent(student);
        model.addAttribute("student", student);
        return "admin/student-detail";
    }

    @RequestMapping(value ="/saveAuto", method = RequestMethod.POST)
    public String saveStudentAutomatic(@RequestParam("file") MultipartFile file) throws IOException {
        List<Student> studentList = utilityService.readStudentListFromExcelFile(file.getInputStream());
        for (Student student: studentList) {
            studentService.addStudent(student);
        }
            return "redirect:/student/all";
    }

    @RequestMapping(value ="/update/{student_id}" , method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student student, @PathVariable(name="student_id") String student_id){
        student.setId(student_id);
        studentService.updateStudent(student);
        return "redirect:/student/view/"+student_id;
    }

    @RequestMapping("/assignCourse/{student_id}")
    public String showAssignCoursePage(@PathVariable("student_id") String student_id, Model model){
        Student student = studentService.getStudentByID(student_id);
        List<ClassSession> classSessionList =  classSessionService.getCourseStudentNotEnroll(student_id);
        model.addAttribute("student", student);
        model.addAttribute("classes", classSessionList);
        return "admin/assign-course";
    }
}
