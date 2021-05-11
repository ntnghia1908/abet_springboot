package cseiu.abet.repo;

import cseiu.abet.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Optional<Instructor> findInstructorById(int id);

//    @Override
//    List<Instructor> findAll();
}