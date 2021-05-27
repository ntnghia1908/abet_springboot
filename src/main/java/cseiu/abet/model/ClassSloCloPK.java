package cseiu.abet.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClassSloCloPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "slo_id")
    private Integer sloId;

    @Column(name = "clo_id")
    private Integer clo_id;

    public ClassSloCloPK(Integer clo_id, Integer sloId, Integer classId) {
        this.classId = classId;
        this.sloId = sloId;
        this.clo_id = clo_id;
    }

    public ClassSloCloPK() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSloId() {
        return sloId;
    }

    public void setSloId(Integer sloId) {
        this.sloId = sloId;
    }

    public Integer getClo_id() {
        return clo_id;
    }

    public void setClo_id(Integer clo_id) {
        this.clo_id = clo_id;
    }

    @Override
    public String toString() {
        return "ClassSloCloPK{" +
                "classId=" + classId +
                ", sloId=" + sloId +
                ", clo_id=" + clo_id +
                '}';
    }
}
