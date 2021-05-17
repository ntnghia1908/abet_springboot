package cseiu.abet.services;

import cseiu.abet.model.Assessment;
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

    public AssessmentTool addAssessmentTool (AssessmentTool as){
        return assessmentToolRepo.save(as);
    }

    public AssessmentTool getByCourseAssessmentAndLO(String course_id, int assessment_id, int loutcome_id){
        return assessmentToolRepo.findByCourseAssessmentAndLO(course_id,assessment_id,loutcome_id);
    }
    public AssessmentTool updateAssessmentTool (AssessmentTool as){
        return assessmentToolRepo.save(as);
    }

    public void deleteAssessmentToolObject(AssessmentTool at){
        assessmentToolRepo.delete(at);
    }

    public void deleteAssessmentTool(String course_id, int assessment_id, int loutcome_id){
        AssessmentTool at = assessmentToolRepo.findByCourseAssessmentAndLO(course_id,assessment_id,loutcome_id);
        assessmentToolRepo.delete(at);
    }
}
