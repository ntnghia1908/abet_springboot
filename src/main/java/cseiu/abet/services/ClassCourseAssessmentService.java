package cseiu.abet.services;

import cseiu.abet.model.ClassAssessmentCourse;
import cseiu.abet.model.ClassAssessmentCoursePK;
import cseiu.abet.model.CourseAssessment;
import cseiu.abet.repo.ClassAssessmentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassCourseAssessmentService {
    private final ClassAssessmentCourseRepository classAssessmentCourseRepository;

    @Autowired
    public ClassCourseAssessmentService(ClassAssessmentCourseRepository classAssessmentCourseRepository) {
        this.classAssessmentCourseRepository = classAssessmentCourseRepository;
    }

    public List<ClassAssessmentCourse> getClassAssessmentCourseByClass(int class_id){
        return classAssessmentCourseRepository.findClassAssessmentCourseByClass(class_id);
    }

    public ClassAssessmentCourse addClassAssessmentCourse(ClassAssessmentCourse classAssessmentCourse){
        return classAssessmentCourseRepository.save(classAssessmentCourse);
    }

    public ClassAssessmentCourse updateClassAssessmentCourse(ClassAssessmentCourse classAssessmentCourse){
        return classAssessmentCourseRepository.save(classAssessmentCourse);
    }

    public ClassAssessmentCourse addClassAssessmentFromCourse(CourseAssessment ca, int class_id){
        ClassAssessmentCourse classAssessmentCourse = new ClassAssessmentCourse();
        classAssessmentCourse.setClassAssessmentCoursePK(new ClassAssessmentCoursePK(class_id, ca.getCourseAssessmentPK().getAssessmentId()));
        classAssessmentCourse.setPercentage(ca.getPercentage());
        return classAssessmentCourseRepository.save(classAssessmentCourse);
    }

}
