package cseiu.abet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClassSloCloPK implements Serializable {

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "slo_id")
    private Integer sloId;

    public ClassSloCloPK(Integer loId, Integer sloId) {
        this.classId = loId;
        this.sloId = sloId;
    }

    public ClassSloCloPK() {
    }

    public Integer getLoId() {
        return classId;
    }

    public void setLoId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSloId() {
        return sloId;
    }

    public void setSloId(Integer sloId) {
        this.sloId = sloId;
    }

    @Override
    public String toString() {
        return "ClassSloCloPK{" +
                "loId=" + classId +
                ", sloId=" + sloId +
                '}';
    }
}
