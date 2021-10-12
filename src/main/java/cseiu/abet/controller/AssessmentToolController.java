package cseiu.abet.controller;

import cseiu.abet.model.*;
import cseiu.abet.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/assessemtTool")
public class AssessmentToolController {
    private final AssessmentToolService assessmentToolService;

    public AssessmentToolController(CourseService courseService, ClassSessionService classSessionService,
                            AssessmentToolService assessmentToolService, AbetService abetService,
                            CourseAssessmentService courseAssessmentService, LearningOutcomeService learningOutcomeService) {

        this.assessmentToolService = assessmentToolService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AssessmentTool>> getCourseAssessmentTool(@PathVariable("id") String id) {
        List<AssessmentTool> result = assessmentToolService.getAssessmentTootTableByCourse(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
//        Employee employee = employeeService.findEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

}
