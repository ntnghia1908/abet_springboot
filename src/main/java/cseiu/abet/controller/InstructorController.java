package cseiu.abet.controller;

import cseiu.abet.model.Instructor;
import cseiu.abet.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Instructor>> getInstructor() {
        List<Instructor> instructors = instructorService.findAllInstructor();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable("id") int id) {
        Instructor instructor = instructorService.findInstructorById(id);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }
}
