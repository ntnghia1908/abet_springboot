package cseiu.abet.controller;


import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Instructor;
import cseiu.abet.model.Student;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.InstructorService;
import cseiu.abet.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    private final StudentService studentService;
    private final ClassSessionService classSessionService;
    private final InstructorService instructorService;

    public DashboardController(StudentService studentService, ClassSessionService classSessionService, InstructorService instructorService) {
        this.studentService = studentService;
        this.classSessionService = classSessionService;
        this.instructorService = instructorService;
    }

    @GetMapping("/dashboard")
    public String showDashboarf(Model model) {
        List<Instructor> instructors = instructorService.findAllInstructor();
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("instructorList", instructors);
        model.addAttribute("studentList", studentList);
        model.addAttribute("classList" ,classSessionList);
        return "admin/dashboard";
    }

}
