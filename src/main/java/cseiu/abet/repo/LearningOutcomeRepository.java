package cseiu.abet.repo;

import cseiu.abet.model.LearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LearningOutcomeRepository extends JpaRepository<LearningOutcome, Integer>, JpaSpecificationExecutor<LearningOutcome> {
    @Query(
            value ="select * from learning_outcome where course_id = :course_id",
            nativeQuery = true
    )
    List<LearningOutcome> findLearningOutcomeByCourse(@Param("course_id") String course_id);
}