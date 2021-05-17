package cseiu.abet.repo;

import cseiu.abet.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    @Query(
            value ="select * from student",
            nativeQuery = true
    )
    List<Student> findAllStudent();

    @Query(
        value ="select * from student s where s.major = :major",
            nativeQuery = true
    )
    List<Student> findStudentByMajor(@Param("major") String major);

    @Query(
            value ="select * from student s where s.batch = :batch",
            nativeQuery = true
    )
    List<Student> findStudentByBatch(@Param("batch") int batch);

    @Query(
            value ="select * from student s where s.batch = :batch and s.major = :major",
            nativeQuery = true
    )
    List<Student> findStudentByMajorAndBatch(@Param("batch") int batch,
                                             @Param("major") String major);

    @Query(
            value ="select * from student where id = :id",
            nativeQuery = true
    )
    Student findStudentByID(@Param("id") String id);
}