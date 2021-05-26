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
public class ClassAssessmentTool implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ClassAssessmentPK classAssessmentPK;

    @Column(name = "precentage")
    private Integer precentage;


    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assessment assessmentId;


    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ClassSession class1;


    @JoinColumn(name = "learning_outcome_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LearningOutcome learningOutcomeId;

    public ClassAssessmentTool() {
    }

    public ClassAssessmentPK getClassAssessmentPK() {
        return classAssessmentPK;
    }

    public void setClassAssessmentPK(ClassAssessmentPK classAssessmentPK) {
        this.classAssessmentPK = classAssessmentPK;
    }

    public ClassAssessmentTool(ClassAssessmentPK classAssessmentPK) {
        this.classAssessmentPK = classAssessmentPK;
    }

    public Integer getPercentage() {
        return precentage;
    }

    public void setPercentage(Integer precentage) {
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
