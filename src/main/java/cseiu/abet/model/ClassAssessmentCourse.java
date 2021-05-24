/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

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

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "class_assessment_course")
@XmlRootElement
public class ClassAssessmentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClassAssessmentCoursePK classAssessmentCoursePK;

    @Column(name = "percentage")
    private Integer percentage;

    @Basic(optional = false)
    @Column(name = "lo_id")
    private int loId;

    @Basic(optional = false)
    @Column(name = "slo_id")
    private int sloId;

    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assessment assessment;

    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ClassSession classSession;

    public ClassAssessmentCourse() {
    }

    public ClassAssessmentCourse(ClassAssessmentCoursePK classAssessmentCoursePK) {
        this.classAssessmentCoursePK = classAssessmentCoursePK;
    }

    public ClassAssessmentCourse(ClassAssessmentCoursePK classAssessmentCoursePK, int loId, int sloId) {
        this.classAssessmentCoursePK = classAssessmentCoursePK;
        this.loId = loId;
        this.sloId = sloId;
    }

    public ClassAssessmentCourse(int classId, int assessmentId) {
        this.classAssessmentCoursePK = new ClassAssessmentCoursePK(classId, assessmentId);
    }

    public ClassAssessmentCoursePK getClassAssessmentCoursePK() {
        return classAssessmentCoursePK;
    }

    public void setClassAssessmentCoursePK(ClassAssessmentCoursePK classAssessmentCoursePK) {
        this.classAssessmentCoursePK = classAssessmentCoursePK;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public int getLoId() {
        return loId;
    }

    public void setLoId(int loId) {
        this.loId = loId;
    }

    public int getSloId() {
        return sloId;
    }

    public void setSloId(int sloId) {
        this.sloId = sloId;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public ClassSession getClassSession() {
        return classSession;
    }

    public void setClassSession(ClassSession class1) {
        this.classSession = class1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classAssessmentCoursePK != null ? classAssessmentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassAssessmentCourse)) {
            return false;
        }
        ClassAssessmentCourse other = (ClassAssessmentCourse) object;
        if ((this.classAssessmentCoursePK == null && other.classAssessmentCoursePK != null) || (this.classAssessmentCoursePK != null && !this.classAssessmentCoursePK.equals(other.classAssessmentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClassAssessmentCourse[ classAssessmentCoursePK=" + classAssessmentCoursePK + " ]";
    }
    
}
