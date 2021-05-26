package cseiu.abet.services;

import cseiu.abet.model.ClassSloClo;
import cseiu.abet.model.ClassSloCloPK;
import cseiu.abet.model.CloSlo;
import cseiu.abet.repo.ClassCloSloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClassSloCloService {
    private final ClassCloSloRepository classCloSloRepository;

    @Autowired
    public ClassSloCloService(ClassCloSloRepository classCloSloRepository) {
        this.classCloSloRepository = classCloSloRepository;
    }

    public ClassSloClo getAbetForSloCloInClass (int class_id, int lo_id, int slo_id){
        return classCloSloRepository.findAbetMappingForLoAndSlo(lo_id, slo_id, class_id);
    }

    public ClassSloClo addClassSloClo (ClassSloClo classSloClo){
        return classCloSloRepository.save(classSloClo);
    }

    public ClassSloClo updateClassSloClo (ClassSloClo classSloClo){
        return classCloSloRepository.save(classSloClo);
    }

    public ClassSloClo addClassSloCloBasedOnCourse (CloSlo cloSlo, int class_id){
        ClassSloClo item = new ClassSloClo();
        item.setClassSloCloPK(new ClassSloCloPK(cloSlo.getCloSloPK().getLoId(), cloSlo.getCloSloPK().getSloId(), class_id));
        item.setPercentage((int)(double) cloSlo.getPercentage());
        return classCloSloRepository.save(item);
    }
}
