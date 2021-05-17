package cseiu.abet.services;

import cseiu.abet.model.Course;
import cseiu.abet.model.CourseAssessment;
import org.springframework.stereotype.Service;
import cseiu.abet.repo.CourseAssessmentRepository;

import java.util.List;

@Service
public class CourseAssessmentService {
    public final CourseAssessmentRepository courseAssessmentRepository;


    public CourseAssessmentService(CourseAssessmentRepository courseAssessmentRepository) {
        this.courseAssessmentRepository = courseAssessmentRepository;
    }

    public List<CourseAssessment> getCourseAssessmentByCourseId (String courseId){
        return courseAssessmentRepository.findCourseAssessmentsByCourseId(courseId);
    }

    public CourseAssessment addCourseAssessment(CourseAssessment ca){
        return courseAssessmentRepository.save(ca);
    }

    public CourseAssessment updateCourseAssessment(CourseAssessment ca){
        return courseAssessmentRepository.save(ca);
    }

    public CourseAssessment getByCourseAndAssessment(String courseId, int assessmentID){
        return courseAssessmentRepository.findByCourseAndAssessment(courseId, assessmentID);
    }

    public void deleteCourseAssessmentObject(CourseAssessment as){
        courseAssessmentRepository.delete(as);
    }

    public void deleteCourseAssessment(String courseID, int assessmentID){
        CourseAssessment ca = courseAssessmentRepository.findByCourseAndAssessment(courseID, assessmentID);
        courseAssessmentRepository.delete(ca);
    }


}
