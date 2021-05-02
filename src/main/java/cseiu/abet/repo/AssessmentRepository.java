package cseiu.abet.repo;

import cseiu.abet.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer>, JpaSpecificationExecutor<Assessment> {

}