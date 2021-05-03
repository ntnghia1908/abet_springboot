package cseiu.abet.services;

import cseiu.abet.exception.InstructorNotFoundExpection;
import cseiu.abet.model.Instructor;
import cseiu.abet.repo.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findInstructorById(id).orElseThrow(()->new InstructorNotFoundExpection("The intructor id " + id +"is not found"));
    }

    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }
}
