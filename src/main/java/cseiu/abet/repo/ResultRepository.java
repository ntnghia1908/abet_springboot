package cseiu.abet.repo;

import cseiu.abet.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer>, JpaSpecificationExecutor<Result> {

    @Query(
            value = "select * from result r where r.class_id = :class_id",
            nativeQuery = true
    )
    List<Result> findResultByClass(@Param("class_id") int class_id);

    @Query(
            value ="select * from result r where r.student_id = :student_id",
            nativeQuery = true
    )
    List<Result> findResultByStudent(@Param("student_id") String student_id);

    @Query(
            value ="select * from result r where r.student_id = :student_id and r.class_id = :class_id",
            nativeQuery = true
    )
    Result findResultByStudentAndClass(@Param("student_id") String student_id,
                                             @Param("class_id") int class_id);
}