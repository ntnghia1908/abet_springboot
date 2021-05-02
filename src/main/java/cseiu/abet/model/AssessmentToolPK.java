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
public class AssessmentToolPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "assessment_id")
    private int assessmentId;
    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;
    @Basic(optional = false)
    @Column(name = "loutcome_id")
    private int loutcomeId;

    public AssessmentToolPK() {
    }

    public AssessmentToolPK(int assessmentId, String courseId, int loutcomeId) {
        this.assessmentId = assessmentId;
        this.courseId = courseId;
        this.loutcomeId = loutcomeId;
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

    public int getLoutcomeId() {
        return loutcomeId;
    }

    public void setLoutcomeId(int loutcomeId) {
        this.loutcomeId = loutcomeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) assessmentId;
        hash += (courseId != null ? courseId.hashCode() : 0);
        hash += (int) loutcomeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssessmentToolPK)) {
            return false;
        }
        AssessmentToolPK other = (AssessmentToolPK) object;
        if (this.assessmentId != other.assessmentId) {
            return false;
        }
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        if (this.loutcomeId != other.loutcomeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AssessmentToolPK[ assessmentId=" + assessmentId + ", courseId=" + courseId + ", loutcomeId=" + loutcomeId + " ]";
    }
    
}
