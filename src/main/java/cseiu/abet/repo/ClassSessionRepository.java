package cseiu.abet.repo;

import cseiu.abet.model.Course;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import cseiu.abet.model.ClassSession;

import java.util.List;
import java.util.Optional;

public interface ClassSessionRepository extends JpaRepository<ClassSession, String>{

    @Query(
            value = "SELECT  * FROM class_session cs WHERE cs.instructor_id= :id",
            nativeQuery = true
    )
    List<ClassSession> findClassForInstructor(@Param("id") int id);

    @Query(
            value = "SELECT  * FROM class_session cs " +
                    "WHERE cs.instructor_id= :instructorId " +
                    "AND  cs.semester = :semester " +
                    "AND  cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSession(@Param("instructorId") int instructorId,
                                        @Param("semester") int semester,
                                        @Param("year") String year);

//    SAMPLE
//    @Query(
//            value = "SELECT  * FROM course c WHERE c.id= :id",
//            nativeQuery = true
//    )
//    Course findCourseById(@Param("id") String id);
}
