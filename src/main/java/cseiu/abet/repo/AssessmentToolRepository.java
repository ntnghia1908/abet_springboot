package cseiu.abet.repo;

import cseiu.abet.model.AssessmentTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AssessmentToolRepository extends JpaRepository<AssessmentTool, Integer>, JpaSpecificationExecutor<AssessmentTool> {

}