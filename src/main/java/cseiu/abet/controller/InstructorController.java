package cseiu.abet.controller;

import cseiu.abet.model.Instructor;
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

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    public final String templateDir = "instructor/";
    public final String defaultUrl = "instructor/index";

    @GetMapping("/all")
    public String getInstructor(Model model) {
        List<Instructor> instructors = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructors);
        return defaultUrl;
    }

    @GetMapping("/{id}")
    public String getInstructor(@PathVariable("id") int id, Model model) {
        Instructor instructor = instructorService.findInstructorById(id);
        model.addAttribute("instructor", instructor);
        return defaultUrl;
    }

    @RequestMapping("/add")
    public String showNewInstructorPage(Model model) {
        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);
        return "instructor/add_instructor";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("instructor") Instructor instructor) {
        instructorService.addInstructor(instructor);
        return "redirect:/instructor/all";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditInstructorPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("instructor/edit_instructor");
        Instructor instructor = instructorService.findInstructorById(id);
        mav.addObject("instructor", instructor);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable(name = "id") int id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructor/all";
    }
}
