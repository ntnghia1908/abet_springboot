package cseiu.abet.repo;

import cseiu.abet.model.ClassAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassAssessmentRepository extends JpaRepository<ClassAssessment, Integer>, JpaSpecificationExecutor<ClassAssessment> {

}