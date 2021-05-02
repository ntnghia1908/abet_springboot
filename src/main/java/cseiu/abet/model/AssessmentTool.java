/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "assessment_tool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssessmentTool.findAll", query = "SELECT a FROM AssessmentTool a")
    , @NamedQuery(name = "AssessmentTool.findByAssessmentId", query = "SELECT a FROM AssessmentTool a WHERE a.assessmentToolPK.assessmentId = :assessmentId")
    , @NamedQuery(name = "AssessmentTool.findByCourseId", query = "SELECT a FROM AssessmentTool a WHERE a.assessmentToolPK.courseId = :courseId")
    , @NamedQuery(name = "AssessmentTool.findByLoutcomeId", query = "SELECT a FROM AssessmentTool a WHERE a.assessmentToolPK.loutcomeId = :loutcomeId")
    , @NamedQuery(name = "AssessmentTool.findByPercentage", query = "SELECT a FROM AssessmentTool a WHERE a.percentage = :percentage")})
public class AssessmentTool implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssessmentToolPK assessmentToolPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentage")
    private Float percentage;
    @JoinColumn(name = "assessment_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assessment assessment;
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "loutcome_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
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

    public Float getPercentage() {
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
