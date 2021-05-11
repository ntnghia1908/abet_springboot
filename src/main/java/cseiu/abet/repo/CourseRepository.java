package cseiu.abet.repo;

import cseiu.abet.model.Course;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(
            value = "SELECT  * FROM course c WHERE c.id= :id",
            nativeQuery = true
    )
    Course findCourseById(@Param("id") String id);

    void deleteCourseById(String id);



    @Query(
            value = "SELECT  * FROM course ",
            nativeQuery = true
    )
    List<Course> selectAllCourse();


    @Override
    List<Course> findAll();
}