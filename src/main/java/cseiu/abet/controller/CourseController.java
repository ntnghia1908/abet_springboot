package cseiu.abet.controller;

import cseiu.abet.model.Course;
import cseiu.abet.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public String getAllCourseFromDB(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return  "course";
    }

    @GetMapping("/{id}")
    public String getByIdCourse(@PathVariable("id") String id, Model model) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        return  "course_detail";
    }

}
