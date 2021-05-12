package cseiu.abet.services;
import cseiu.abet.model.Student;
import cseiu.abet.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAllStudent();
    }

    public List<Student> getStudentByMajor (String major){
        return studentRepository.findStudentByMajor(major);
    }

    public List<Student> getStudentByBatch(int batch){
        return studentRepository.findStudentByBatch(batch);
    }

    public List<Student> getStudentByBatchAndMajor(int batch, String major){
        return studentRepository.findStudentByMajorAndBatch(batch,major);
    }
}
