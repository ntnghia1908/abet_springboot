package cseiu.abet.rest_controller;

import cseiu.abet.model.Course;
import cseiu.abet.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_api")
public class CourseControllerRest {
    private final CourseService courseService;

    public CourseControllerRest(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourseFromDB() {
        List<Course> courses = courseService.getAllCourse();
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getByIdCourse(@PathVariable("id") String id) {
        Course courses = courseService.findCourseById(id);
        return  new ResponseEntity<>(courses, HttpStatus.OK);
    }



}
