package cseiu.abet.repo;

import cseiu.abet.model.CourseAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, String>, JpaSpecificationExecutor<CourseAssessment> {

}