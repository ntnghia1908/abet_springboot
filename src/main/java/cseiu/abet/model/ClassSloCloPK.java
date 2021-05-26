package cseiu.abet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClassSloCloPK implements Serializable {

    @Column(name = "lo_id")
    private Integer loId;

    @Column(name = "slo_id")
    private Integer sloId;

    public ClassSloCloPK(Integer loId, Integer sloId) {
        this.loId = loId;
        this.sloId = sloId;
    }

    public ClassSloCloPK() {
    }

    public Integer getLoId() {
        return loId;
    }

    public void setLoId(Integer loId) {
        this.loId = loId;
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
                "loId=" + loId +
                ", sloId=" + sloId +
                '}';
    }
}
