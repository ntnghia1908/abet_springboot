package cseiu.abet.services;

import cseiu.abet.model.CourseProgram;
import cseiu.abet.repo.CourseProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseProgramService {
    private final CourseProgramRepository courseProgramRepository;

    @Autowired
    public CourseProgramService(CourseProgramRepository courseProgramRepository) {
        this.courseProgramRepository = courseProgramRepository;
    }

    public List<CourseProgram> getListofCourseByProgram(int propId) {
        List<CourseProgram> coursePrograms =courseProgramRepository.findByProgramNative(propId);
        return coursePrograms;
    }

}
