package cseiu.abet.controller;


import cseiu.abet.model.ClassAssessmentCourse;
import cseiu.abet.model.ClassSession;
import cseiu.abet.model.LearningOutcome;
import cseiu.abet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/assessment")
public class AssessmentController {
    private final ClassCourseAssessmentService classCourseAssessmentService;
    private final ClassSloCloService classSloCloService;
    private final ClassAssessmentToolService assessmentToolService;
    private final LearningOutcomeService learningOutcomeService;
    private final ClassSessionService classSessionService;

    public AssessmentController(ClassCourseAssessmentService classCourseAssessmentService, ClassSloCloService classSloCloService, ClassAssessmentToolService assessmentToolService, LearningOutcomeService learningOutcomeService, ClassSessionService classSessionService) {
        this.classCourseAssessmentService = classCourseAssessmentService;
        this.classSloCloService = classSloCloService;
        this.assessmentToolService = assessmentToolService;
        this.learningOutcomeService = learningOutcomeService;
        this.classSessionService = classSessionService;
    }

    @GetMapping("/edit/{class_id}")
    public String showAssessmentEditpage(@PathVariable(name="class_id") int class_id, Model model){
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse(classSession.getCourse().getId());
        List<ClassAssessmentCourse> classAssessmentCourses = classCourseAssessmentService.getClassAssessmentCourseByClassWithoutCombo(class_id);


        model.addAttribute("classSession", classSession);
        model.addAttribute("loList", learningOutcomeList);
        model.addAttribute("assessmentCourse", classAssessmentCourses);
        return "/admin/assessment-edit";

    }

}
