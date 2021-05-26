package cseiu.abet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "class_slo_clo")
public class ClassSloClo implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ClassSloCloPK classSloCloPK;

    @Column(name = "percentage")
    private Integer percentage;

    @JoinColumn(name = "slo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Slo sloId;

    @JoinColumn(name = "clo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private LearningOutcome learningOutcomeId;

    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private ClassSession classSession;

    public ClassSloClo() {
    }

    public ClassSloClo(ClassSloCloPK classSloCloPK, Integer percentage, Slo sloId, LearningOutcome learningOutcomeId) {
        this.classSloCloPK = classSloCloPK;
        this.percentage = percentage;
        this.sloId = sloId;
        this.learningOutcomeId = learningOutcomeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ClassSloCloPK getClassSloCloPK() {
        return classSloCloPK;
    }

    public void setClassSloCloPK(ClassSloCloPK classSloCloPK) {
        this.classSloCloPK = classSloCloPK;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer precentage) {
        this.percentage = percentage;
    }

    public Slo getSloId() {
        return sloId;
    }

    public void setSloId(Slo sloId) {
        this.sloId = sloId;
    }

    public LearningOutcome getLearningOutcomeId() {
        return learningOutcomeId;
    }

    public void setLearningOutcomeId(LearningOutcome learningOutcomeId) {
        this.learningOutcomeId = learningOutcomeId;
    }


    public ClassSession getClassSession() {
        return classSession;
    }

    public void setClassSession(ClassSession classSession) {
        this.classSession = classSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSloClo that = (ClassSloClo) o;
        return classSloCloPK.equals(that.classSloCloPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classSloCloPK);
    }

    @Override
    public String toString() {
        return "ClassSloClo{" +
                "classSloCloPK=" + classSloCloPK +
                ", percentage=" + percentage +
                ", sloId=" + sloId +
                ", learningOutcomeId=" + learningOutcomeId +
                '}';
    }
}
