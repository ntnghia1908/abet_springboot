package cseiu.abet.services;
import cseiu.abet.model.Student;
import cseiu.abet.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cseiu.abet.services.UtilityService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAllStudent();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
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

    public Student getStudentByID (String studentID){
        return studentRepository.findStudentByID(studentID);
    }

    public Student updateStudent (Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent (String id){
        studentRepository.deleteById(id);
    }
    
}
