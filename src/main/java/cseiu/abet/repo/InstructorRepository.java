package cseiu.abet.repo;

import cseiu.abet.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>, JpaSpecificationExecutor<Instructor> {

}