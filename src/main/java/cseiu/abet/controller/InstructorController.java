package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Instructor;
import cseiu.abet.services.ClassSessionService;
import cseiu.abet.services.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;
    private final ClassSessionService classSessionService;

    public InstructorController(InstructorService instructorService,
                                ClassSessionService classSessionService) {

        this.instructorService = instructorService;
        this.classSessionService = classSessionService;
    }
    public final String templateDir = "instructor/";
    public final String defaultUrl = "instructor/index";

    @GetMapping("/all")
    public String getInstructor(Model model) {
        List<Instructor> instructors = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructors);
        return "admin/instructor-list";
    }

    @GetMapping("/view/{id}")
    public String getInstructor(@PathVariable("id") int id, Model model) {
        Instructor instructor = instructorService.findInstructorById(id);
        List<ClassSession> classSessionList = classSessionService.findClassGivenInstructor(id);
        model.addAttribute("instructor", instructor);
        model.addAttribute("classList",classSessionList);
        return "admin/instructor-detail";
    }

    @RequestMapping("/add")
    public String showNewInstructorPage(Model model) {
        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);
        return "admin/instructor-edit";
    }

    @RequestMapping("/edit/{instructor_id}")
    public String showUpdateInstructorPage(@PathVariable("instructor_id") int instructor_id, Model model){
        Instructor instructor = instructorService.findInstructorById(instructor_id);
        model.addAttribute("instructor", instructor);
        return "admin/instructor-edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addInstructor (@ModelAttribute("instructor") Instructor instructor, Model model) {
        instructorService.addInstructor(instructor);
        model.addAttribute("instructor", instructor);
        return "admin/instructor-detail";
    }

    @RequestMapping("/update/{instructor_id}")
    public String updateInstructor(@ModelAttribute("instructor") Instructor instructor,
                                   @PathVariable("instructor_id") int instructor_id){
        instructor.setId(instructor_id);
        instructorService.updateInstructor(instructor);
        return "redirect:/instructor/view/"+instructor_id;
    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveProduct(@ModelAttribute("instructor") Instructor instructor) {
//        instructorService.addInstructor(instructor);
//        return "redirect:/instructor/all";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditInstructorPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("instructor/edit_instructor");
//        Instructor instructor = instructorService.findInstructorById(id);
//        mav.addObject("instructor", instructor);
//        return mav;
//    }

    @RequestMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable(name = "id") int id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructor/all";
    }
}
