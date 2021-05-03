package cseiu.abet.services;

import cseiu.abet.model.AssessmentTool;
import cseiu.abet.repo.AssessmentToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentToolService {
    public final AssessmentToolRepository assessmentToolRepo;

    @Autowired
    public AssessmentToolService(AssessmentToolRepository assessmentToolRepo) {
        this.assessmentToolRepo = assessmentToolRepo;
    }

    public List<AssessmentTool> getAssessmentTootTableByCourse(String courseId) {
        return assessmentToolRepo.findAssessmentToolByCourseId(courseId);
    }
}
