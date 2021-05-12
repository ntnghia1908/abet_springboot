package cseiu.abet.controller;

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
@RequestMapping("/classSession")
public class ClassSessionController {
    private final ClassSessionService classSessionService;


    public ClassSessionController(ClassSessionService classSessionService) {
        this.classSessionService = classSessionService;
    }

    @GetMapping("/getByInstructor/{instructorId}")
    public ResponseEntity<List<ClassSession>> getClassOfGivenInstructor (@PathVariable("instructorId") int instructorId) {
        List<ClassSession> classSessionList = classSessionService.findClassGivenInstructor(instructorId);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

    @GetMapping("/getByInstructor/{instructorId}/{year}/{semester}")
    public ResponseEntity<List<ClassSession>> getClassSession(@PathVariable int instructorId,
                                                              @PathVariable String year,
                                                              @PathVariable int semester) {
        System.err.printf("instructor: %d, year: %s, semester: %d", instructorId,year, semester);
        List<ClassSession> classSessionList = classSessionService.getClassSession(instructorId, semester, year);
        return  new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }


    @GetMapping("/getByInstructor/{instructorId}/{year}")
    public ResponseEntity<List<ClassSession>> getClassSessionByInstructorAndYear(@PathVariable int instructorId,
                                                                                @PathVariable String year){
        List<ClassSession> classSessionList = classSessionService.getClassSessionByInstructorAndYear(instructorId,year);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

    @GetMapping("/getByCourse/{courseId}/{year}")
    public ResponseEntity<List<ClassSession>> getClassSessionByCourseAndYear(@PathVariable String courseId,
                                                                             @PathVariable String year){
        List<ClassSession> classSessionList = classSessionService.getClassSessionByCourseAndYear(courseId, year);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

    @GetMapping("/getByCourse/{courseId}")
    public ResponseEntity<List<ClassSession>> getClassSessionByCourse(@PathVariable String courseId){
        List<ClassSession> classSessionList = classSessionService.getClassSessionByCourse(courseId);
        return new ResponseEntity<>(classSessionList, HttpStatus.OK);
    }

    @GetMapping("/getByCourse/{courseId}/{semester}/{year}")
    public ResponseEntity<List<ClassSession>> getClassSessionByCourseSemAndYear(@PathVariable String courseId,
                                                                                @PathVariable int semester,
                                                                                @PathVariable String year){
        List<ClassSession> classSessionList = classSessionService.getClassSessionByCourseAndSemAndYear(courseId, semester,year);
        return new ResponseEntity<>(classSessionList,HttpStatus.OK);
    }

    @GetMapping("/getByTime/{year}/{semester}")
    public ResponseEntity<List<ClassSession>> getClassSessionBySemesterAndYear(@PathVariable String year,
                                                                               @PathVariable int semester ){
        List<ClassSession> classSessionList = classSessionService.getClassSessionBySemesterAndYear(semester, year);
        return new ResponseEntity<>(classSessionList,HttpStatus.OK);
    }

}
