package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Instructor;
import cseiu.abet.model.Result;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping("/classSession")
public class ClassSessionController {
    public final String templateDir = "classSession/";
    public final String defaultUrl = "classSession/index";

    private final ClassSessionService classSessionService;
    private final ResultService resultService;


    public ClassSessionController(ClassSessionService classSessionService, ResultService resultService) {
        this.classSessionService = classSessionService;
        this.resultService = resultService;
    }

    @GetMapping("/all")
    public String getAllClassess(Model model){
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        List<String> academicYearList = classSessionService.getAllAcademicYear();
        Hashtable<Integer,String> instructorList = new Hashtable<>();
        for (ClassSession cl: classSessionList){
            instructorList.put(cl.getInstructorId().getId(),cl.getInstructorId().getName());
        }
        model.addAttribute("classSessionList", classSessionList);
        model.addAttribute("academicList", academicYearList);
        model.addAttribute("instructorList", instructorList);
        return "admin/class-list";
    }

    @GetMapping("/view/{id}")
    public String showDetailClassPage(@PathVariable(name = "id") int id ,Model model) {
        ModelAndView mav = new ModelAndView("classSession/class_detail");
        ClassSession classSession = classSessionService.getClassById(id);
        List<Result> resultList = resultService.getResultByClass(id);
        model.addAttribute("classSession", classSession);
        model.addAttribute("resultList", resultList);
        return "/admin/class-detail";
    }
    @RequestMapping("/add")
    public String showAddClassPage(Model model) {
        ClassSession classSession = new ClassSession();
        model.addAttribute("classSession", classSession);
        return "admin/class-edit";
    }

    @RequestMapping("/edit/{class_id}")
    public String showUpdateClassPage(@PathVariable("class_id") int class_id, Model model){
        ClassSession classSession = classSessionService.getClassById(class_id);
        model.addAttribute("classSession", classSession);
        return "admin/class-edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClass(@PathVariable(name="id") int id){
        ClassSession classSession = classSessionService.getClassById(id);
        classSessionService.deleteClass(classSession);
        return "redirect:/classSession/all";
    }
}
