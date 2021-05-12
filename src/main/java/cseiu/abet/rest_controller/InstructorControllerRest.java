package cseiu.abet.rest_controller;

import cseiu.abet.model.Instructor;
import cseiu.abet.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor_api")
public class InstructorControllerRest {
    private final InstructorService instructorService;

    public InstructorControllerRest(InstructorService instructorService) {
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

    @PostMapping("/add")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor newInstructor = instructorService.addInstructor(instructor);
        return  new ResponseEntity<>(newInstructor, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteInstructor(@PathVariable("id") int id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
