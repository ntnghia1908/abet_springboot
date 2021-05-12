package cseiu.abet.rest_controller;

import cseiu.abet.model.ClassSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cseiu.abet.services.ClassSessionService;

import java.util.List;

@Controller
@RequestMapping("/classSession_api")
public class ClassSessionControllerRest {
    private final ClassSessionService classSessionService;


    public ClassSessionControllerRest(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<List<ClassSession>> getClassOfGivenInstructor (@PathVariable("instructorId") int instructorId) {
        List<ClassSession> classSessionList = classSessionService.findClassGivenInstructor(instructorId);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

    @GetMapping("/{instructorId}/{year}/{semester}")
    public ResponseEntity<List<ClassSession>> getClassSession(@PathVariable int instructorId,
                                                              @PathVariable String year,
                                                              @PathVariable int semester) {
        System.err.printf("instructor: %d, year: %s, semester: %d", instructorId,year, semester);
        List<ClassSession> classSessionList = classSessionService.getClassSession(instructorId, semester, year);
        return  new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

}
