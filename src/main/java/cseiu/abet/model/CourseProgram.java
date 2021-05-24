/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "course_program")
@XmlRootElement
public class CourseProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseProgramPK courseProgramPK;

    @Basic(optional = false)
    @Column(name = "course_code")
    private String courseCode;

    @Basic(optional = false)
    @Column(name = "course_type_id")
    private int courseTypeId;


    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;


    @JoinColumn(name = "program_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;

    public CourseProgram() {
    }

    public CourseProgram(CourseProgramPK courseProgramPK) {
        this.courseProgramPK = courseProgramPK;
    }

    public CourseProgram(CourseProgramPK courseProgramPK, String courseCode, int courseTypeId) {
        this.courseProgramPK = courseProgramPK;
        this.courseCode = courseCode;
        this.courseTypeId = courseTypeId;
    }

    public CourseProgram(String courseId, int programId) {
        this.courseProgramPK = new CourseProgramPK(courseId, programId);
    }

    public CourseProgramPK getCourseProgramPK() {
        return courseProgramPK;
    }

    public void setCourseProgramPK(CourseProgramPK courseProgramPK) {
        this.courseProgramPK = courseProgramPK;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseProgramPK != null ? courseProgramPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseProgram)) {
            return false;
        }
        CourseProgram other = (CourseProgram) object;
        if ((this.courseProgramPK == null && other.courseProgramPK != null) || (this.courseProgramPK != null && !this.courseProgramPK.equals(other.courseProgramPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CourseProgram[ courseProgramPK=" + courseProgramPK + " ]";
    }
    
}
