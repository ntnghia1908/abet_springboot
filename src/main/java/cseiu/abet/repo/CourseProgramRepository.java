package cseiu.abet.repo;

import cseiu.abet.model.CourseProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseProgramRepository extends JpaRepository<CourseProgram, Integer>, JpaSpecificationExecutor<CourseProgram> {

}