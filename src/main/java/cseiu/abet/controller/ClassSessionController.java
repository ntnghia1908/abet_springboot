package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.CloSlo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cseiu.abet.services.ClassSessionService;

import java.util.List;

@Controller
@RequestMapping("/classSession")
public class ClassSessionController {
    private final ClassSessionService classSessionService;


    public ClassSessionController(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<List<ClassSession>> getClassOfGivenInstructor (@PathVariable("instructorId") int instructorId) {
        List<ClassSession> classSessionList = classSessionService.findClassGivenInstructor(instructorId);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }
}
