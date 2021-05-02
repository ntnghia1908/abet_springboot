package cseiu.abet.repo;

import cseiu.abet.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer>, JpaSpecificationExecutor<Discipline> {

}