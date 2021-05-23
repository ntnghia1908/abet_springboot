package cseiu.abet.repo;

import cseiu.abet.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Optional<Instructor> findInstructorById(int id);

    @Query(
            value ="select instructor.id from instructor where instructor.name like %:keyword%",
            nativeQuery = true
    )
    Integer searchInstructorIdGivenName(@Param("keyword") String keyword);
}