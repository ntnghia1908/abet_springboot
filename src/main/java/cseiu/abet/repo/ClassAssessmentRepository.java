package cseiu.abet.repo;

import cseiu.abet.model.ClassAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ClassAssessmentRepository extends JpaRepository<ClassAssessment, Integer>, JpaSpecificationExecutor<ClassAssessment> {

}