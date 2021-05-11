package cseiu.abet.services;
import cseiu.abet.model.ClassSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cseiu.abet.repo.ClassSessionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassSessionService {
    private final ClassSessionRepository classSessionRepository;

    @Autowired
    public ClassSessionService(ClassSessionRepository classSessionRepository) {
        this.classSessionRepository = classSessionRepository;
    }

    public List<ClassSession> findClassGivenInstructor(int instructorId){
        return classSessionRepository.findClassForInstructor(instructorId);
    }
}
