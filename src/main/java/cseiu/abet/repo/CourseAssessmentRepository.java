package cseiu.abet.repo;

import cseiu.abet.model.CourseAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, String>, JpaSpecificationExecutor<CourseAssessment> {
    @Query (
            value = "select * from course_assessment where course_id = :courseId",
            nativeQuery = true
    )
    List<CourseAssessment> findCourseAssessmentsByCourseId (@Param("courseId") String courseId);

    @Query(
            value ="select * from course_assessment where course_id = :course_id and assessment_id = :assessment_id",
            nativeQuery = true
    )
    CourseAssessment findByCourseAndAssessment(@Param("course_id") String course_id,
                                               @Param("assessment_id") int assessment_id);

    @Query(
            value = "select * from course_assessment where course_id = :courseId and assessment_id not in (10)",
            nativeQuery = true
    )
    List<CourseAssessment> findCourseAssessmentByCourseWithoutComboAss(@Param("courseId") String courseId);

    @Query(
        value = "select lo.description, group_concat(a.type,':', atl.percentage) as assessment\n" +
                "from learning_outcome lo, course_assessment ca, assessment_tool atl, assessment a\n" +
                "where lo.course_id = ca.course_id\n" +
                "and atl.assessment_id = ca.assessment_id\n" +
                "and atl.course_id = ca.course_id\n" +
                "and atl.loutcome_id = lo.id\n" +
                "and a.id = atl.assessment_id\n" +
                "and lo.course_id = :courseId\n" +
                "and ca.assessment_id != 10\n" +
                "group by lo.id\n",
        nativeQuery = true
    )
    List<Object> assessmentToolByCourse(@Param("courseId") String courseId);
}