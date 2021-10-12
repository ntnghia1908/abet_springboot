package cseiu.abet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import cseiu.abet.model.*;
import cseiu.abet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;
    private final ClassSessionService classSessionService;
    private final AssessmentToolService assessmentToolService;
    private final AbetService abetService;
    private final CourseAssessmentService courseAssessmentService;
    private final LearningOutcomeService learningOutcomeService;

    public CourseController(CourseService courseService, ClassSessionService classSessionService,
                            AssessmentToolService assessmentToolService, AbetService abetService,
                            CourseAssessmentService courseAssessmentService, LearningOutcomeService learningOutcomeService) {
        this.courseService = courseService;
        this.classSessionService = classSessionService;
        this.assessmentToolService = assessmentToolService;
        this.abetService = abetService;
        this.courseAssessmentService = courseAssessmentService;
        this.learningOutcomeService = learningOutcomeService;
    }

    @GetMapping("/all")
    public String getAllCourseFromDB(Model model, Principal principal) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "admin/course-list";
    }

    @Transactional
    @GetMapping("/view/{id}")
    public String getByIdCourse(@PathVariable("id") String id, Model model) throws JsonProcessingException {
        Course course = courseService.findCourseById(id);
        List<ClassSession> classSessionList = classSessionService.getClassSessionByCourse(id);

        List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseWithoutComboAss("IT079");
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse(id);

        Hashtable<Integer, Hashtable> newAssessmentTool = new Hashtable<>();
        for (LearningOutcome lo: learningOutcomeList){
            Hashtable<Integer, Float> item = new Hashtable<>();
            for (CourseAssessment ca: courseAssessmentList){
                if (assessmentToolService.getByCourseAssessmentAndLO(id,ca.getCourseAssessmentPK().getAssessmentId(),lo.getId()) !=null){
                    item.put(ca.getCourseAssessmentPK().getAssessmentId(),assessmentToolService.getByCourseAssessmentAndLO(id, ca.getCourseAssessmentPK().getAssessmentId(), lo.getId()).getPercentage());
                }else{
                    item.put(ca.getCourseAssessmentPK().getAssessmentId(),0F);
                }
            }
            newAssessmentTool.put(lo.getId(),item);
        }

        Hashtable<Integer, Hashtable> abetMapping = new Hashtable<>();
        for (LearningOutcome lo: learningOutcomeList){
            Hashtable<Integer,Float> item = new Hashtable<>();
            for (int slo=1;slo<7; slo++){
                if (abetService.getAbetMappingForCloSlo(lo.getId(),slo)!=null){
                    item.put(slo, abetService.getAbetMappingForCloSlo(lo.getId(),slo).getPercentage());
                }else{
                    item.put(slo,0F);
                }
            }
            abetMapping.put(lo.getId(),item);
        }

        model.addAttribute("course", course);
        model.addAttribute("newAssessmentTool", newAssessmentTool);
        model.addAttribute("loList", learningOutcomeList);
        model.addAttribute("courseAssessment", courseAssessmentList);
        model.addAttribute("classSessionList", classSessionList);
        model.addAttribute("abet", abetMapping);
        return "admin/course-detail";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") String id) {
        courseService.deleteCourse(id);
        return "redirect:/course/all";
    }

}
