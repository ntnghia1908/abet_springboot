package cseiu.abet.repo;

import cseiu.abet.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResultRepository extends JpaRepository<Result, Integer>, JpaSpecificationExecutor<Result> {

}