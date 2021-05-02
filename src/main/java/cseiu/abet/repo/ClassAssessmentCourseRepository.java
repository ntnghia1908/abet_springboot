package cseiu.abet.repo;

import cseiu.abet.model.ClassAssessmentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassAssessmentCourseRepository extends JpaRepository<ClassAssessmentCourse, Integer>, JpaSpecificationExecutor<ClassAssessmentCourse> {

}