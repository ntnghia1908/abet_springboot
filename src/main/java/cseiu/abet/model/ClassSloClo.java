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

    @Column(name = "persentage")
    private Integer precentage;

    @JoinColumn(name = "slo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Slo sloId;

    @JoinColumn(name = "clo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private LearningOutcome learningOutcomeId;

    public ClassSloClo() {
    }

    public ClassSloClo(ClassSloCloPK classSloCloPK, Integer precentage, Slo sloId, LearningOutcome learningOutcomeId) {
        this.classSloCloPK = classSloCloPK;
        this.precentage = precentage;
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

    public Integer getPrecentage() {
        return precentage;
    }

    public void setPrecentage(Integer precentage) {
        this.precentage = precentage;
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
                ", precentage=" + precentage +
                ", sloId=" + sloId +
                ", learningOutcomeId=" + learningOutcomeId +
                '}';
    }
}
