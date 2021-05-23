package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Course;
import cseiu.abet.model.Instructor;
import cseiu.abet.model.Result;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.CourseService;
import cseiu.abet.services.InstructorService;
import cseiu.abet.services.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/classSession")
public class ClassSessionController {
    public final String templateDir = "classSession/";
    public final String defaultUrl = "classSession/index";

    private final ClassSessionService classSessionService;
    private final ResultService resultService;
    private final CourseService courseService;
    private final InstructorService instructorService;


    public ClassSessionController(ClassSessionService classSessionService, ResultService resultService, CourseService courseService, InstructorService instructorService) {
        this.classSessionService = classSessionService;
        this.resultService = resultService;
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public String getAllClassess(Model model) {
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        model.addAttribute("classSessionList", classSessionList);
        return "admin/class-list";
    }

    @GetMapping("/view/{id}")
    public String showDetailClassPage(@PathVariable(name = "id") int id, Model model) {
        ClassSession classSession = classSessionService.getClassById(id);
        List<Result> resultList = resultService.getResultByClass(id);
        model.addAttribute("classSession", classSession);
        model.addAttribute("resultList", resultList);
        return "/admin/class-detail";
    }

    @RequestMapping("/add")
    public String showAddClassPage(Model model) {
        ClassSession classSession = new ClassSession();
        List<Course> courseList = courseService.getAllCourse();
        List<String> courseName = new ArrayList<>();
        for (Course c : courseList) {
            courseName.add(c.getName());
        }
        List<Instructor> instructorList = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructorList);
        model.addAttribute("classSession", classSession);
        model.addAttribute("courseList", courseList);
        model.addAttribute("courseNames", courseName);
        return "admin/class-edit";
    }

    @RequestMapping("/edit/{class_id}")
    public String showUpdateClassPage(@PathVariable("class_id") int class_id, Model model) {
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<Course> courseList = courseService.getAllCourse();
        List<String> courseName = new ArrayList<>();
        for (Course c : courseList) {
            courseName.add(c.getName());
        }
        List<Instructor> instructorList = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructorList);
        model.addAttribute("classSession", classSession);
        model.addAttribute("courseList", courseList);
        model.addAttribute("courseNames", courseName);

        return "admin/class-edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String editInstructor(@ModelAttribute("classSession") ClassSession classSession, Model model) {
        classSessionService.addClassSession(classSession);
        model.addAttribute("classSession", classSession);
        return "/admin/class-detail";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClass(@PathVariable(name = "id") int id) {
        ClassSession classSession = classSessionService.getClassById(id);
        classSessionService.deleteClass(classSession);
        return "redirect:/classSession/all";
    }



}


