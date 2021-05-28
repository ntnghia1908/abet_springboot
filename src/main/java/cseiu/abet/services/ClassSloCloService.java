package cseiu.abet.services;

import cseiu.abet.model.ClassSloClo;
import cseiu.abet.model.ClassSloCloPK;
import cseiu.abet.model.CloSlo;
import cseiu.abet.model.LearningOutcome;
import cseiu.abet.repo.ClassCloSloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<ClassSloClo> getAbetMappingForClass(int class_id){
        return classCloSloRepository.findAbetMappingForClass(class_id);
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
        item.setPercentage(cloSlo.getPercentage());
        return classCloSloRepository.save(item);
    }

    public boolean checkValidation(List<ClassSloClo> classSloCloList, List<LearningOutcome> learningOutcomeList) {
        int check = 1;
        for (LearningOutcome lo : learningOutcomeList) {
            float sum = 0;
            for (ClassSloClo c : classSloCloList) {
                if (c.getLearningOutcomeId().getId() == lo.getId()) {
                    sum += c.getPercentage();
                }
            }
            if (sum != 100) {
                check = 0;
                break;
            }
        }

        if (check == 0) {
            return false;
        } else {
            return true;
        }
    }

}
