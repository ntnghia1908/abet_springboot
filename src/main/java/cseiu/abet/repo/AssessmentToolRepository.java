package cseiu.abet.repo;

import cseiu.abet.model.AssessmentTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AssessmentToolRepository extends JpaRepository<AssessmentTool, Integer>, JpaSpecificationExecutor<AssessmentTool> {
    public List<AssessmentTool> findAssessmentToolByCourseId(String courseId);
}