package cseiu.abet.controller;

import cseiu.abet.model.AssessmentTool;
import cseiu.abet.model.Course;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public CourseController(CourseService courseService, ClassSessionService classSessionService,
                            AssessmentToolService assessmentToolService, AbetService abetService,
                            CourseAssessmentService courseAssessmentService) {
        this.courseService = courseService;
        this.classSessionService = classSessionService;
        this.assessmentToolService = assessmentToolService;
        this.abetService = abetService;
        this.courseAssessmentService = courseAssessmentService;
    }

    @GetMapping("/all")
    public String getAllCourseFromDB(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "admin/course-list";
    }

    @Transactional
    @GetMapping("/view/{id}")
    public String getByIdCourse(@PathVariable("id") String id, Model model) {
        Course course = courseService.findCourseById(id);

        List<AssessmentTool> assessmentTools = assessmentToolService.getAssessmentTootTableByCourse(id);
        Hashtable<Integer, String> listLearningOutcome = new Hashtable<>();
        List<CourseAssessment> courseAssessments = courseAssessmentService.getCourseAssessmentByCourseWithoutComboAss(id);

        for (AssessmentTool as:assessmentTools){
            listLearningOutcome.put(as.getLearningOutcome().getId(), as.getLearningOutcome().getDescription());
        }
        model.addAttribute("course", course);
        model.addAttribute("assessmentTools", assessmentTools);
        model.addAttribute("loList", listLearningOutcome);
        model.addAttribute("courseAssessment", courseAssessments);
        return "admin/course-detail";
    }

}
