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

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor findInstructorById(int id) {
        return instructorRepository.findInstructorById(id)
                .orElseThrow(()->new InstructorNotFoundExpection("The instructor id " + id +"is not found"));
    }

    public List<Instructor> findAllInstructor() {
        return instructorRepository.findAll();
    }

    public void deleleInstructor(int id) {
        instructorRepository.deleteById(id);
    }

    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

}
