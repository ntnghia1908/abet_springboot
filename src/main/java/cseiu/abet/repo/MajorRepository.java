package cseiu.abet.repo;

import cseiu.abet.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MajorRepository extends JpaRepository<Major, Integer>, JpaSpecificationExecutor<Major> {

}