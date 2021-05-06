package cseiu.abet.repo;

import cseiu.abet.model.CloSlo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CloSloRepository extends JpaRepository<CloSlo, Integer>, JpaSpecificationExecutor<CloSlo> {
    @Query(
            value = "SELECT * FROM clo_slo WHERE lo_id IN " +
                    "(SELECT loutcome_id FROM assessment_tool " +
                    "WHERE course_id = :courseId)",
            nativeQuery = true
    )
    List<CloSlo> selectAbetMapping(@Param("courseId") String courseId);

}