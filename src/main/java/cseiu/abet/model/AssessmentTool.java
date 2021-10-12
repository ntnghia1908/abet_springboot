/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author meoco
 */
@Entity
@Table(name = "assessment_tool")
@XmlRootElement
public class AssessmentTool implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssessmentToolPK assessmentToolPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "percentage")
    private Float percentage;


    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Assessment assessment;


    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Course course;


    @JoinColumn(name = "loutcome_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private LearningOutcome learningOutcome;

    public AssessmentTool() {
    }

    public AssessmentTool(AssessmentToolPK assessmentToolPK) {
        this.assessmentToolPK = assessmentToolPK;
    }

    public AssessmentTool(int assessmentId, String courseId, int loutcomeId) {
        this.assessmentToolPK = new AssessmentToolPK(assessmentId, courseId, loutcomeId);
    }

    public AssessmentToolPK getAssessmentToolPK() {
        return assessmentToolPK;
    }

    public void setAssessmentToolPK(AssessmentToolPK assessmentToolPK) {
        this.assessmentToolPK = assessmentToolPK;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
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

    public LearningOutcome getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(LearningOutcome learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assessmentToolPK != null ? assessmentToolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssessmentTool)) {
            return false;
        }
        AssessmentTool other = (AssessmentTool) object;
        if ((this.assessmentToolPK == null && other.assessmentToolPK != null) || (this.assessmentToolPK != null && !this.assessmentToolPK.equals(other.assessmentToolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AssessmentTool[ assessmentToolPK=" + assessmentToolPK + " ]";
    }

}
