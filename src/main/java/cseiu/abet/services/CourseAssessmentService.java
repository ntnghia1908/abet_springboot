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
}
