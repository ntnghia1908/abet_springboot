/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author meoco
 */
@Entity
@Table(name = "course")
@XmlRootElement
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
//    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "name_vn")
    private String nameVn;

    @Column(name = "credit_theory")
    private Integer creditTheory;

    @Column(name = "credit_lab")
    private Integer creditLab;

    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<LearningOutcome> learningOutcomeList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<AssessmentTool> assessmentToolList;


    @JoinColumn(name = "course_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CourseLevel courseLevel;


    //    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,  mappedBy = "course")
    private List<CourseAssessment> courseAssessmentList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<CourseProgram> courseProgramList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<ClassSession> classList;


    public Course() {
    }

    public Course(String id) {
        this.id = id;
    }

    public Course(String id, String nameVn, String description) {
        this.id = id;
        this.nameVn = nameVn;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameVn() {
        return nameVn;
    }

    public void setNameVn(String nameVn) {
        this.nameVn = nameVn;
    }

    public Integer getCreditTheory() {
        return creditTheory;
    }

    public void setCreditTheory(Integer creditTheory) {
        this.creditTheory = creditTheory;
    }

    public Integer getCreditLab() {
        return creditLab;
    }

    public void setCreditLab(Integer creditLab) {
        this.creditLab = creditLab;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }


    public List<LearningOutcome> getLearningOutcomeList() {
        return learningOutcomeList;
    }

    public void setLearningOutcomeList(List<LearningOutcome> learningOutcomeList) {
        this.learningOutcomeList = learningOutcomeList;
    }


    public List<AssessmentTool> getAssessmentToolList() {
        return assessmentToolList;
    }

    public void setAssessmentToolList(List<AssessmentTool> assessmentToolList) {
        this.assessmentToolList = assessmentToolList;
    }

    public List<CourseAssessment> getCourseAssessment() {
        return courseAssessmentList;
    }

    public void setCourseAssessment(List<CourseAssessment> courseAssessments) {
        this.courseAssessmentList = courseAssessments;
    }


    public List<CourseProgram> getCourseProgramList() {
        return courseProgramList;
    }

    public void setCourseProgramList(List<CourseProgram> courseProgramList) {
        this.courseProgramList = courseProgramList;
    }


    public List<ClassSession> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassSession> classList) {
        this.classList = classList;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Course[ id=" + id + " ]";
    }

}
