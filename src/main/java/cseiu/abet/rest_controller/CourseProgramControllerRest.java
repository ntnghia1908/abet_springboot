package cseiu.abet.rest_controller;

import cseiu.abet.model.CourseProgram;
import cseiu.abet.services.CourseProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course_program_api")
public class CourseProgramControllerRest {
    private final CourseProgramService courseProgramService;

    public CourseProgramControllerRest(CourseProgramService courseProgramService) {
        this.courseProgramService = courseProgramService;
    }

    @GetMapping("/{program_id}")
    public ResponseEntity<List<CourseProgram>> getListofCouseByProgram(@PathVariable("program_id") int programId) {
        List<CourseProgram> coursePrograms = courseProgramService.getListofCourseByProgram(programId);
        return new ResponseEntity<>(coursePrograms, HttpStatus.OK);
    }
}
