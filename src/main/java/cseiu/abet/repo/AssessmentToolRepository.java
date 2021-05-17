package cseiu.abet.repo;

import cseiu.abet.model.AssessmentTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssessmentToolRepository extends JpaRepository<AssessmentTool, Integer>, JpaSpecificationExecutor<AssessmentTool> {
    public List<AssessmentTool> findAssessmentToolByCourseId(String courseId);

    @Query(
            value = "select * from abet.assessment_tool " +
                    "where assessment_id = :assessment_id " +
                    "and course_id = :course_id " +
                    "and loutcome_id = :loutcome_id",
            nativeQuery = true
    )
    AssessmentTool findByCourseAssessmentAndLO (@Param("course_id") String course_id,
                                               @Param("assessment_id") int assessment_id,
                                               @Param("loutcome_id") int loutcome_id);
}