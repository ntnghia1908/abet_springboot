package cseiu.abet.controller;


import cseiu.abet.model.*;
import cseiu.abet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/assessment")
public class AssessmentController {
    private final ClassCourseAssessmentService classCourseAssessmentService;
    private final ClassSloCloService classSloCloService;
    private final ClassAssessmentToolService assessmentToolService;
    private final LearningOutcomeService learningOutcomeService;
    private final ClassSessionService classSessionService;
    private final ResultService resultService;
    private final GradingService gradingService;

    public AssessmentController(ClassCourseAssessmentService classCourseAssessmentService, ClassSloCloService classSloCloService, ClassAssessmentToolService assessmentToolService, LearningOutcomeService learningOutcomeService, ClassSessionService classSessionService, ResultService resultService, GradingService gradingService) {
        this.classCourseAssessmentService = classCourseAssessmentService;
        this.classSloCloService = classSloCloService;
        this.assessmentToolService = assessmentToolService;
        this.learningOutcomeService = learningOutcomeService;
        this.classSessionService = classSessionService;
        this.resultService = resultService;
        this.gradingService = gradingService;
    }

    @GetMapping("/editAssessmentTool/{class_id}")
    public String showAssessmentEditpage(@PathVariable(name = "class_id") int class_id, Model model) {
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse(classSession.getCourse().getId());
        List<ClassAssessmentCourse> classAssessmentCourses = classCourseAssessmentService.getClassAssessmentCourseByClassWithoutCombo(class_id);

        model.addAttribute("classSession", classSession);
        model.addAttribute("loList", learningOutcomeList);
        model.addAttribute("assessmentCourse", classAssessmentCourses);
        return "/admin/assessment-edit";

    }

    @GetMapping("/editAbetMapping/{class_id}")
    public String showAbetMappingEditPage(@PathVariable(name = "class_id") int class_id, Model model) {
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<ClassSloClo> classSloClos = classSloCloService.getAbetMappingForClass(class_id);
        AssessmentForm form = new AssessmentForm();
        form.setClassSloClos(classSloClos);
        model.addAttribute("classSession", classSession);
        model.addAttribute("form", form);
        return "/admin/abetMapping-edit";
    }

    @RequestMapping(value = "/updateAbetMapping/{class_id}", method = RequestMethod.POST)
    public String updateAbetMapping(@ModelAttribute("form") AssessmentForm form, @PathVariable("class_id") int class_id,
                                    RedirectAttributes redirAttrs) {
        List<ClassSloClo> newAbetMapping = form.getClassSloClos();
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse(classSession.getCourse().getId());
        List<ClassAssessmentCourse> classAssessmentCourses = classCourseAssessmentService.getClassAssessmentCourseByClass(class_id);
        List<ClassAssessmentTool> classAssessmentTools = assessmentToolService.getAssessmentToolForClass(class_id);
        if (classSloCloService.checkValidation(newAbetMapping, learningOutcomeList) == true) {
            for (ClassSloClo c : newAbetMapping) {
                c.setClassSloCloPK(new ClassSloCloPK(c.getLearningOutcomeId().getId(), c.getSloId().getId(), class_id));
                classSloCloService.updateClassSloClo(c);
            }
            // UPDATE STUDENT SCORE//
            List<Result> resultList = resultService.getResultByClass(class_id);
            for (Result result:resultList){
                resultService.updateResultInClass(gradingService.calculateAbetScoreOfStudent(classAssessmentTools,
                        classAssessmentCourses,newAbetMapping,result));
            }
            return "redirect:/classSession/view/" + class_id;
        } else {
            redirAttrs.addFlashAttribute("message", "The sum of percentage of each Learning Outcome must be 100%");
            return "redirect:/assessment/editAbetMapping/" + class_id;

        }
    }


}
