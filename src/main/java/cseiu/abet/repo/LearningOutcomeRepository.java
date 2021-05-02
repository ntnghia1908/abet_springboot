package cseiu.abet.repo;

import cseiu.abet.model.LearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LearningOutcomeRepository extends JpaRepository<LearningOutcome, Integer>, JpaSpecificationExecutor<LearningOutcome> {

}