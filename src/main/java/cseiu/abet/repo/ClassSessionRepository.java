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

public interface ClassSessionRepository<Instructor> extends JpaRepository<ClassSession, String>{
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
                    "AND  cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSession(@Param("instructorId") int instructorId,
                                        @Param("semester") int semester,
                                        @Param("year") String year);

    @Query(
            value ="SELECT * from class_session cs" +
                    " where cs.semester = :semester and cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionBySemesterAndYear(@Param("semester") int semester,
                                                         @Param("year") String year);

    @Query(
            value ="select * from class_session cs " +
                    "where cs.instructor_id = :instructor_id and cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionsByInstructorAndAcademicYear(@Param("instructor_id") int instructor_id,
                                                                    @Param("year") String year);

    @Query(
            value ="select * from class_session cs where cs.course_id = :course_id and cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionsByCourseIdAndAcademicYear(@Param("course_id") String course_id,
                                                                  @Param("year") String year);

    @Query(
            value ="select * from class_session cs where cs.course_id= :course_id",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionsByCourse(@Param("course_id") String course_id);

    @Query(
            value ="select * from class_session cs where cs.course_id = :course_id and cs.semester = :semester " +
                    "and cs.academic_year = :year",
            nativeQuery = true
    )
    List<ClassSession> findClassSessionsByCourseSemAndYear(@Param("course_id") String course_id,
                                                           @Param("semester") int semester,
                                                           @Param("year") String year);
    @Query(
            value ="select distinct r.academic_year from class_session r",
            nativeQuery = true
    )
    List<String> findAllAcademicYear();

    @Query(
            value ="select * from class_session where class_session.id = :class_id",
            nativeQuery = true
    )
    ClassSession findClassById(@Param("class_id") int class_id);



}
