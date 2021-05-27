package cseiu.abet.services;

import cseiu.abet.model.AssessmentTool;
import cseiu.abet.model.ClassAssessmentPK;
import cseiu.abet.model.ClassAssessmentTool;
import cseiu.abet.repo.ClassAssessmentToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassAssessmentToolService {
    private final ClassAssessmentToolRepository classAssessmentToolRepository;

    @Autowired
    public ClassAssessmentToolService(ClassAssessmentToolRepository classAssessmentToolRepository) {
        this.classAssessmentToolRepository = classAssessmentToolRepository;
    }

    public ClassAssessmentTool getClassAssessmentToolByAssessmentAndLO(int class_id, int assessment_id, int lo_id){
        return classAssessmentToolRepository.findByAssessmentAndLO(class_id, assessment_id,lo_id);
    }

    public ClassAssessmentTool addClassAssessmentTool(ClassAssessmentTool classAssessmentTool){
        return classAssessmentToolRepository.save(classAssessmentTool);
    }
    public ClassAssessmentTool updateClassAssessmentTool(ClassAssessmentTool classAssessmentTool){
        return classAssessmentToolRepository.save(classAssessmentTool);
    }

    public List<ClassAssessmentTool> getAssessmentToolForClass(int class_id){
        return classAssessmentToolRepository.findAssessmentToolForClass(class_id);
    }

    public ClassAssessmentTool addAssessmentToolToClassBasedOnCourse(AssessmentTool at, int class_id){
        ClassAssessmentTool cat = new ClassAssessmentTool();
        cat.setClassAssessmentPK(new ClassAssessmentPK(class_id,at.getAssessmentToolPK().getAssessmentId(), at.getAssessmentToolPK().getLoutcomeId()));
        cat.setPercentage( at.getPercentage());
        return classAssessmentToolRepository.save(cat);
    }
}
