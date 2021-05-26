package cseiu.abet.repo;

import cseiu.abet.model.AssessmentTool;
import cseiu.abet.model.ClassAssessmentTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassAssessmentToolRepository extends JpaRepository<ClassAssessmentTool, Integer>, JpaSpecificationExecutor<ClassAssessmentTool> {
    @Query(
            value = "select * from class_assessment " +
                    "where assessment_id = :assessment_id " +
                    "and class_id = :class_id " +
                    "and learning_outcome_id = :learning_outcome_id",
            nativeQuery = true
    )
    ClassAssessmentTool findByAssessmentAndLO (@Param("class_id") int class_id,
                                                @Param("assessment_id") int assessment_id,
                                                @Param("learning_outcome_id") int learning_outcome_id);

    @Query(
            value="select * from class_assessment where class_id = :class_id",
            nativeQuery = true
    )
    List<ClassAssessmentTool> findAssessmentToolForClass(@Param("class_id") int class_id);

}