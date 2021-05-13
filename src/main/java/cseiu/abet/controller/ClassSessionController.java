package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Instructor;
import cseiu.abet.services.ClassSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/classSession")
public class ClassSessionController {
    public final String templateDir = "classSession/";
    public final String defaultUrl = "classSession/index";

    private final ClassSessionService classSessionService;



    public ClassSessionController(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping("/all")
    public String getAllClassess(Model model){
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        List<String> academicYearList = classSessionService.getAllAcademicYear();
       // List<Instructor> instructorList = classSessionService.getTeachingInstructor();
        model.addAttribute("classSessionList", classSessionList);
        model.addAttribute("academicList", academicYearList);
     //   model.addAttribute("instructorList", instructorList);
        return defaultUrl;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showEditInstructorPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("classSession/class_detail");
        ClassSession classSession = classSessionService.getClassById(id);
        mav.addObject("classSession", classSession);
        return mav;
    }

}
