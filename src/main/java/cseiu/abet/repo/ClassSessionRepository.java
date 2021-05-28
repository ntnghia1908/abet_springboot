package cseiu.abet.repo;

import cseiu.abet.model.Instructor;
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
            value ="select * from class_session",
            nativeQuery = true
    )
    List<ClassSession> findAllClasses();

    @Query(
            value = "SELECT  * FROM class_session cs WHERE cs.instructor_id= :id",
            nativeQuery = true
    )
    List<ClassSession> findClassForInstructor(@Param("id") int id);

    @Query(
            value = "SELECT  * FROM class_session cs " +
                    "WHERE cs.instructor_id= :instructorId " +
                    "AND  cs.semester = :semester " +
                    "AND  cs.academic_year = :year and cs.course_id = :course_id and cs.group_theory = :group_theory",
            nativeQuery = true
    )
    ClassSession findClassSessionByAllInfor(@Param("instructorId") int instructorId,
                                            @Param("semester") int semester,
                                            @Param("year") String year,
                                            @Param("course_id") String course_id,
                                            @Param("group_theory") int group_theory);

    @Query(
            value ="select * from class_session cs where cs.course_id= :course_id",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionsByCourse(@Param("course_id") String course_id);



    @Query(
            value ="select * from class_session where class_session.id = :class_id",
            nativeQuery = true
    )
    ClassSession findClassById(@Param("class_id") int class_id);


    @Query(
            value ="select * from class_session where course_id not in " +
                    "(select course_id from result, class_session where " +
                    "result.student_id = :student_id and result.class_id = class_session.id)",

            nativeQuery = true
    )
    List<ClassSession> findCourseStudentNotEnroll(@Param("student_id") String student_id);
}
