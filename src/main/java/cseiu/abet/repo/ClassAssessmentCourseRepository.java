package cseiu.abet.repo;

import cseiu.abet.model.ClassAssessmentCourse;
import cseiu.abet.model.CourseAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassAssessmentCourseRepository extends JpaRepository<ClassAssessmentCourse, Integer>, JpaSpecificationExecutor<ClassAssessmentCourse> {

    @Query(
            value ="select * from class_assessment_course where class_id = :class_id",
            nativeQuery = true
    )
    List<ClassAssessmentCourse> findClassAssessmentCourseByClass(@Param("class_id")  int class_id);

}