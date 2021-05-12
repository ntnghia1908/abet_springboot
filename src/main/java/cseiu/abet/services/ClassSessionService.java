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

    public List<ClassSession> getClassSession(int instructorId, int semester, String year) {
        return classSessionRepository.findClassSession(instructorId, semester, year);
    }
    public List<ClassSession> getClassSessionBySemesterAndYear(int semester, String year){
        return classSessionRepository.findClassSessionBySemesterAndYear(semester,year);
    }
    public List<ClassSession> getClassSessionByInstructorAndYear(int instructor_id, String year){
        return classSessionRepository.findClassSessionsByInstructorAndAcademicYear(instructor_id, year);
    }
    public List<ClassSession> getClassSessionByCourseAndYear(String courseId, String year){
        return classSessionRepository.findClassSessionsByCourseIdAndAcademicYear(courseId, year);
    }
    public List<ClassSession> getClassSessionByCourse(String courseId){
        return classSessionRepository.findClassSessionsByCourse(courseId);
    }
    public List<ClassSession> getClassSessionByCourseAndSemAndYear(String courseId, int semester, String year){
        return classSessionRepository.findClassSessionsByCourseSemAndYear(courseId,semester,year);
    }
}
