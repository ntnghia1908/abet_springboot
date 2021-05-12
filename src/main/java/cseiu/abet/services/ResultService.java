package cseiu.abet.services;
import cseiu.abet.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cseiu.abet.repo.ResultRepository;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getResultByClass (int class_id){
        return resultRepository.findResultByClass(class_id);
    }

    public List<Result> getResultByStudent (String studentId){
        return resultRepository.findResultByStudent(studentId);
    }

    public List<Result> getResultByStudentAndClass (String student_id, int class_id){
        return resultRepository.findResultByStudentAndClass(student_id, class_id);
    }
}
