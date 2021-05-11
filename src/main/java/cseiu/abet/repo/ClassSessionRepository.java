package cseiu.abet.repo;

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

}
