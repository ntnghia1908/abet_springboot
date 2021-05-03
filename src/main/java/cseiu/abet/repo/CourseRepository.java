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
    Optional<Course> findCourseById(@Param("id") String id);

    void deleteCourseById(String id);

//    List<Course> findAllCourses();

    @Query(
            value = "SELECT  * FROM course ",
            nativeQuery = true
    )
    List<Course> findAllNative();


    @Override
    List<Course> findAll();
}