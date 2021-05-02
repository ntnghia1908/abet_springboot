package cseiu.abet.repo;

import cseiu.abet.model.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassSessionRepository extends JpaRepository<ClassSession, Integer>, JpaSpecificationExecutor<ClassSession> {

}