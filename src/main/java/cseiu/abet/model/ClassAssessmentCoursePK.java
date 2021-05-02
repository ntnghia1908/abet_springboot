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
public class ClassAssessmentCoursePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;
    @Basic(optional = false)
    @Column(name = "assessment_id")
    private int assessmentId;

    public ClassAssessmentCoursePK() {
    }

    public ClassAssessmentCoursePK(int classId, int assessmentId) {
        this.classId = classId;
        this.assessmentId = assessmentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) classId;
        hash += (int) assessmentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassAssessmentCoursePK)) {
            return false;
        }
        ClassAssessmentCoursePK other = (ClassAssessmentCoursePK) object;
        if (this.classId != other.classId) {
            return false;
        }
        if (this.assessmentId != other.assessmentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClassAssessmentCoursePK[ classId=" + classId + ", assessmentId=" + assessmentId + " ]";
    }
    
}
