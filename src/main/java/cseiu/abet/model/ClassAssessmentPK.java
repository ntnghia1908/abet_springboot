package cseiu.abet.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassAssessmentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;

    @Basic(optional = false)
    @Column(name = "assessment_id")
    private int assessmentId;

    @Basic(optional = false)
    @Column(name = "learning_outcome_id")
    private int loutcomeId;

    public ClassAssessmentPK(int classId, int assessmentId, int loutcomeId) {
        this.classId = classId;
        this.assessmentId = assessmentId;
        this.loutcomeId = loutcomeId;
    }

    public ClassAssessmentPK() {
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

    public int getLoutcomeId() {
        return loutcomeId;
    }

    public void setLoutcomeId(int loutcomeId) {
        this.loutcomeId = loutcomeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassAssessmentPK that = (ClassAssessmentPK) o;
        return classId == that.classId && assessmentId == that.assessmentId && loutcomeId == that.loutcomeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, assessmentId, loutcomeId);
    }

    @Override
    public String toString() {
        return "ClassAssessmentToolsPK{" +
                "classId=" + classId +
                ", assessmentId=" + assessmentId +
                ", loutcomeId=" + loutcomeId +
                '}';
    }
}
