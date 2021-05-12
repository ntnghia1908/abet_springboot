package cseiu.abet.rest_controller;

import cseiu.abet.model.AssessmentTool;
import cseiu.abet.services.AssessmentToolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assessment_tool_api")
public class AssessmentToolControllerRest {
    private final AssessmentToolService assessmentToolService;

    public AssessmentToolControllerRest(AssessmentToolService assessmentToolService) {
        this.assessmentToolService = assessmentToolService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<AssessmentTool>> getAssessmentToolByCourse(@PathVariable("courseId") String courseId) {
        List<AssessmentTool> assessmentToolTable = assessmentToolService.getAssessmentTootTableByCourse(courseId);
        return new ResponseEntity<>(assessmentToolTable, HttpStatus.OK);
    }
}
