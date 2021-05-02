/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author meoco
 */
@Embeddable
public class CourseAssessmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "assessment_id")
    private int assessmentId;
    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;

    public CourseAssessmentPK() {
    }

    public CourseAssessmentPK(int assessmentId, String courseId) {
        this.assessmentId = assessmentId;
        this.courseId = courseId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) assessmentId;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseAssessmentPK)) {
            return false;
        }
        CourseAssessmentPK other = (CourseAssessmentPK) object;
        if (this.assessmentId != other.assessmentId) {
            return false;
        }
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CourseAssessmentPK[ assessmentId=" + assessmentId + ", courseId=" + courseId + " ]";
    }
    
}
