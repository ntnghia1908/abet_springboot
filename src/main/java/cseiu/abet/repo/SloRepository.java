package cseiu.abet.repo;

import cseiu.abet.model.Slo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SloRepository extends JpaRepository<Slo, String>, JpaSpecificationExecutor<Slo> {

}