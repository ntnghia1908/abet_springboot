package cseiu.abet.model;

import java.util.List;

public class AssessmentForm {
    private  List<ClassAssessmentCourse> classAssessmentCourses;
    private  List<ClassAssessmentTool> classAssessmentTools;
    private  List<ClassSloClo> classSloClos;
    private  List<CourseAssessment> courseAssessmentList;
    private  List<AssessmentTool> assessmentToolList;
    private  List<CloSlo> cloSloList;


    public AssessmentForm(List<ClassAssessmentCourse> classAssessmentCourses,
                          List<ClassAssessmentTool> classAssessmentTools, List<ClassSloClo> classSloClos,
                          List<CourseAssessment> courseAssessmentList, List<AssessmentTool> assessmentToolList,
                          List<CloSlo> cloSloList) {
        this.classAssessmentCourses = classAssessmentCourses;
        this.classAssessmentTools = classAssessmentTools;
        this.classSloClos = classSloClos;
        this.courseAssessmentList = courseAssessmentList;
        this.assessmentToolList = assessmentToolList;
        this.cloSloList = cloSloList;
    }

    public void setClassAssessmentCourses(List<ClassAssessmentCourse> classAssessmentCourses) {
        this.classAssessmentCourses = classAssessmentCourses;
    }

    public void setClassAssessmentTools(List<ClassAssessmentTool> classAssessmentTools) {
        this.classAssessmentTools = classAssessmentTools;
    }

    public void setClassSloClos(List<ClassSloClo> classSloClos) {
        this.classSloClos = classSloClos;
    }

    public void setCourseAssessmentList(List<CourseAssessment> courseAssessmentList) {
        this.courseAssessmentList = courseAssessmentList;
    }

    public void setAssessmentToolList(List<AssessmentTool> assessmentToolList) {
        this.assessmentToolList = assessmentToolList;
    }

    public void setCloSloList(List<CloSlo> cloSloList) {
        this.cloSloList = cloSloList;
    }

    public AssessmentForm(){}

    public List<ClassAssessmentCourse> getClassAssessmentCourses() {
        return classAssessmentCourses;
    }

    public List<ClassAssessmentTool> getClassAssessmentTools() {
        return classAssessmentTools;
    }

    public List<ClassSloClo> getClassSloClos() {
        return classSloClos;
    }

    public List<CourseAssessment> getCourseAssessmentList() {
        return courseAssessmentList;
    }

    public List<AssessmentTool> getAssessmentToolList() {
        return assessmentToolList;
    }

    public List<CloSlo> getCloSloList() {
        return cloSloList;
    }
}
