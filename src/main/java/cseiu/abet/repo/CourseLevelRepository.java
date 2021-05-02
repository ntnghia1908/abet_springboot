package cseiu.abet.repo;

import cseiu.abet.model.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseLevelRepository extends JpaRepository<CourseLevel, Integer>, JpaSpecificationExecutor<CourseLevel> {

}