/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author meoco
 */
@Embeddable
public class ResultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "student_id")
    private String studentId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "class_id")
    private int classId;

    public ResultPK() {
    }

    public ResultPK(String studentId, int classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        hash += (int) classId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultPK)) {
            return false;
        }
        ResultPK other = (ResultPK) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        if (this.classId != other.classId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ResultPK[ studentId=" + studentId + ", classId=" + classId + " ]";
    }
    
}
