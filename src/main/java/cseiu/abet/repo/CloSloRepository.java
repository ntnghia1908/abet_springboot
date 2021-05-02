package cseiu.abet.repo;

import cseiu.abet.model.CloSlo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CloSloRepository extends JpaRepository<CloSlo, Integer>, JpaSpecificationExecutor<CloSlo> {

}