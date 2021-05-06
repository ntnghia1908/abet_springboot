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

}