/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "course_assessment")
@XmlRootElement
public class CourseAssessment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseAssessmentPK courseAssessmentPK;

    @Basic(optional = false)
    @Column(name = "percentage")
    private int percentage;


    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)

    private Assessment assessment;


    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)


    private Course course;

    public CourseAssessment() {
    }

    public CourseAssessment(CourseAssessmentPK courseAssessmentPK) {
        this.courseAssessmentPK = courseAssessmentPK;
    }

    public CourseAssessment(CourseAssessmentPK courseAssessmentPK, int percentage) {
        this.courseAssessmentPK = courseAssessmentPK;
        this.percentage = percentage;
    }

    public CourseAssessment(int assessmentId, String courseId) {
        this.courseAssessmentPK = new CourseAssessmentPK(assessmentId, courseId);
    }

    public CourseAssessmentPK getCourseAssessmentPK() {
        return courseAssessmentPK;
    }

    public void setCourseAssessmentPK(CourseAssessmentPK courseAssessmentPK) {
        this.courseAssessmentPK = courseAssessmentPK;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseAssessmentPK != null ? courseAssessmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseAssessment)) {
            return false;
        }
        CourseAssessment other = (CourseAssessment) object;
        if ((this.courseAssessmentPK == null && other.courseAssessmentPK != null) || (this.courseAssessmentPK != null && !this.courseAssessmentPK.equals(other.courseAssessmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CourseAssessment[ courseAssessmentPK=" + courseAssessmentPK + " ]";
    }
    
}
