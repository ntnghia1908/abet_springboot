package cseiu.abet.controller;

import cseiu.abet.model.Instructor;
import cseiu.abet.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Instructor>> getInstructor() {
        List<Instructor> instructors = instructorService.getAllInstructor();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable("id") int id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }
}
