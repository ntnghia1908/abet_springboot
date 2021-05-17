package cseiu.abet.services;


import cseiu.abet.exception.CourseNotFoundExpection;
import cseiu.abet.model.Course;
import cseiu.abet.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepo;

    @Autowired
    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourse() {
        return  courseRepo.selectAllCourse();
    }

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course updateCourses(Course course) {
        return courseRepo.save(course);
    }

    public Course findCourseById(String id) {
        return courseRepo.findCourseById(id);
//                .orElseThrow(() -> new CourseNotFoundExpection("Course by id " + id + " was not found"));
    }

    public void deleteCourse(String id) {
        courseRepo.deleteById(id);
    }
}
