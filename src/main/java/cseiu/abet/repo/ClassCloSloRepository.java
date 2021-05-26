package cseiu.abet.repo;

import cseiu.abet.model.ClassSloClo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassCloSloRepository extends JpaRepository<ClassSloClo, Integer>, JpaSpecificationExecutor<ClassSloClo> {
    @Query(
            value ="select * from class_slo_clo where clo_id = :clo_id and slo_id = :slo_id and class_id = :class_id",
            nativeQuery = true
    )
    ClassSloClo findAbetMappingForLoAndSlo(@Param("clo_id") int lo_id, @Param("slo_id") int slo_id, @Param("class_id") int class_id);

}
