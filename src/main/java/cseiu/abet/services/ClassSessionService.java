package cseiu.abet.services;
import cseiu.abet.model.ClassSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cseiu.abet.repo.ClassSessionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassSessionService {
    private final ClassSessionRepository classSessionRepository;

    @Autowired
    public ClassSessionService(ClassSessionRepository classSessionRepository) {
        this.classSessionRepository = classSessionRepository;
    }

    public List<ClassSession> getAllClasses(){
        return classSessionRepository.findAllClasses();
    }
    public List<ClassSession> findClassGivenInstructor(int instructorId){
        return classSessionRepository.findClassForInstructor(instructorId);
    }

    public List<ClassSession> getClassSessionByCourse(String courseId){
        return classSessionRepository.findClassSessionsByCourse(courseId);
    }

    public ClassSession getClassById(int class_id){
        return classSessionRepository.findClassById(class_id);
    }

    public ClassSession addClassSession(ClassSession cs) {
        return  classSessionRepository.save(cs);
    }

    public ClassSession updateClassSession (ClassSession cs){return classSessionRepository.save(cs);}

    public void deleteClass (ClassSession classSession){ classSessionRepository.delete(classSession);}

    public List<ClassSession> getCourseStudentNotEnroll(String student_id){
        return classSessionRepository.findCourseStudentNotEnroll(student_id);
    }

    public ClassSession getClassSessionWithFullInfor(ClassSession c){
        return classSessionRepository.findClassSessionByAllInfor(c.getInstructorId().getId(), c.getSemester(), c.getAcademicYear(),
                c.getCourse().getId(), c.getGroupTheory());
    }

}
