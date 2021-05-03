package cseiu.abet.services;

import cseiu.abet.model.CloSlo;
import cseiu.abet.repo.CloSloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbetService {
    private final CloSloRepository cloSloRepository;

    @Autowired
    public AbetService(CloSloRepository cloSloRepository) {
        this.cloSloRepository = cloSloRepository;
    }

    public List<CloSlo> getAbetMappingTable(String courseId) {
        return cloSloRepository.selectAbetMapping(courseId);
    }
}
