/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author meoco
 */
@Embeddable
public class CourseProgramPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "course_id")
    private String courseId;
    @Basic(optional = false)
    @Column(name = "program_id")
    private int programId;

    public CourseProgramPK() {
    }

    public CourseProgramPK(String courseId, int programId) {
        this.courseId = courseId;
        this.programId = programId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        hash += (int) programId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseProgramPK)) {
            return false;
        }
        CourseProgramPK other = (CourseProgramPK) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        if (this.programId != other.programId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CourseProgramPK[ courseId=" + courseId + ", programId=" + programId + " ]";
    }
    
}
