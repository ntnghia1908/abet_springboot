package cseiu.abet.controller;

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
@RequestMapping("/assessment_tool")
public class AssessmentToolController {
    private final AssessmentToolService assessmentToolService;

    public AssessmentToolController(AssessmentToolService assessmentToolService) {
        this.assessmentToolService = assessmentToolService;
    }

    @GetMapping("/{cousreId}")
    public ResponseEntity<List<AssessmentTool>> getAssemssmentToolByCourse(@PathVariable("cousreId") String courseId) {
        List<AssessmentTool> assessmentToolTable = assessmentToolService.getAssessmentTootTableByCourse(courseId);
        return new ResponseEntity<>(assessmentToolTable, HttpStatus.OK);
    }
}
