/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "class_session")
@XmlRootElement
public class ClassSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "groupTheory")
    private Integer groupTheory;

    @Column(name = "group_lab")
    private Integer groupLab;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "academic_year")
    private String academicYear;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classSession")
    private List<Result> resultList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classSession")
    private List<ClassAssessmentCourse> classAssessmentCourseList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private List<ClassAssessmentTool> classAssessmentTools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classSession")
    private List<ClassSloClo> classSloClos;

    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course course;

    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instructor instructorId;

    public ClassSession() {
    }

    public ClassSession(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupTheory() {
        return groupTheory;
    }

    public void setGroupTheory(Integer group) {
        this.groupTheory = group;
    }

    public Integer getGroupLab() {
        return groupLab;
    }

    public void setGroupLab(Integer groupLab) {
        this.groupLab = groupLab;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }


    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public List<ClassSloClo> getClassSloClos() {
        return classSloClos;
    }

    public void setClassSloClos(List<ClassSloClo> classSloClos) {
        this.classSloClos = classSloClos;
    }


    public List<ClassAssessmentCourse> getClassAssessmentCourseList() {
        return classAssessmentCourseList;
    }

    public void setClassAssessmentCourseList(List<ClassAssessmentCourse> classAssessmentCourseList) {
        this.classAssessmentCourseList = classAssessmentCourseList;
    }

    public List<ClassAssessmentTool> getClassAssessmentTools() {
        return classAssessmentTools;
    }

    public void setClassAssessmentTools(List<ClassAssessmentTool> classAssessmentTools) {
        this.classAssessmentTools = classAssessmentTools;
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course courseId) {
        this.course = courseId;
    }

    public Instructor getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Instructor instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassSession)) {
            return false;
        }
        ClassSession other = (ClassSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Class[ id=" + id + " ]";
    }

}
