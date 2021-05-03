package cseiu.abet.controller;

import cseiu.abet.model.Course;
import cseiu.abet.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> courses = courseService.findAllCourse();
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getByIdCourse(@PathVariable("id") String id) {
        Course courses = courseService.findCourseById(id);
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
