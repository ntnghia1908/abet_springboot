package cseiu.abet.repo;

import cseiu.abet.model.CourseProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseProgramRepository extends JpaRepository<CourseProgram, Integer>, JpaSpecificationExecutor<CourseProgram> {

    @Query(
            value = "select * from course_program " +
                    "where program_id = :program_id",
            nativeQuery = true
    )
    List<CourseProgram> findByProgramNative(@Param("program_id") int propId);

}