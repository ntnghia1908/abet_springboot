/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "class_assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassAssessment.findAll", query = "SELECT c FROM ClassAssessment c")
    , @NamedQuery(name = "ClassAssessment.findByClassId", query = "SELECT c FROM ClassAssessment c WHERE c.classId = :classId")
    , @NamedQuery(name = "ClassAssessment.findByPrecentage", query = "SELECT c FROM ClassAssessment c WHERE c.precentage = :precentage")})
public class ClassAssessment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "precentage")
    private Integer precentage;
    @JoinColumn(name = "assessment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Assessment assessmentId;
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ClassSession class1;
    @JoinColumn(name = "learning_outcome_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LearningOutcome learningOutcomeId;

    public ClassAssessment() {
    }

    public ClassAssessment(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getPrecentage() {
        return precentage;
    }

    public void setPrecentage(Integer precentage) {
        this.precentage = precentage;
    }

    public Assessment getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Assessment assessmentId) {
        this.assessmentId = assessmentId;
    }

    public ClassSession getClass1() {
        return class1;
    }

    public void setClass1(ClassSession class1) {
        this.class1 = class1;
    }

    public LearningOutcome getLearningOutcomeId() {
        return learningOutcomeId;
    }

    public void setLearningOutcomeId(LearningOutcome learningOutcomeId) {
        this.learningOutcomeId = learningOutcomeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassAssessment)) {
            return false;
        }
        ClassAssessment other = (ClassAssessment) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClassAssessment[ classId=" + classId + " ]";
    }
    
}
