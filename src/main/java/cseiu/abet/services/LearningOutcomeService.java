package cseiu.abet.services;

import cseiu.abet.model.LearningOutcome;
import cseiu.abet.repo.LearningOutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LearningOutcomeService {
    private final LearningOutcomeRepository learningOutcomeRepository;

    @Autowired
    public LearningOutcomeService(LearningOutcomeRepository learningOutcomeRepository) {
        this.learningOutcomeRepository = learningOutcomeRepository;
    }

    public List<LearningOutcome> getLOByCourse(String course_id){
        return learningOutcomeRepository.findLearningOutcomeByCourse(course_id);
    }
}
