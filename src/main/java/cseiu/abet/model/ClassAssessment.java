/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

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
@Table(name = "class_assessment")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ClassAssessment implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ClassAssessmentPK classAssessmentPK;

    @Column(name = "precentage")
    private Integer precentage;

    @XmlTransient
    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assessment assessmentId;

    @XmlTransient
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ClassSession class1;

    @XmlTransient
    @JoinColumn(name = "learning_outcome_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LearningOutcome learningOutcomeId;

    public ClassAssessment() {
    }

    public ClassAssessment(ClassAssessmentPK classAssessmentPK) {
        this.classAssessmentPK = classAssessmentPK;
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

}
