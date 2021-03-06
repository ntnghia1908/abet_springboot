/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a")
    , @NamedQuery(name = "Assessment.findById", query = "SELECT a FROM Assessment a WHERE a.id = :id")
    , @NamedQuery(name = "Assessment.findByType", query = "SELECT a FROM Assessment a WHERE a.type = :type")})
public class Assessment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;


    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment")
    private List<AssessmentTool> assessmentToolList;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessmentId")
    private List<ClassAssessment> classAssessmentList;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment")
    private List<ClassAssessmentCourse> classAssessmentCourseList;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment")
    private List<CourseAssessment> courseAssessmentList;

    public Assessment() {
    }

    public Assessment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<AssessmentTool> getAssessmentToolList() {
        return assessmentToolList;
    }

    public void setAssessmentToolList(List<AssessmentTool> assessmentToolList) {
        this.assessmentToolList = assessmentToolList;
    }

    @XmlTransient
    public List<ClassAssessment> getClassAssessmentList() {
        return classAssessmentList;
    }

    public void setClassAssessmentList(List<ClassAssessment> classAssessmentList) {
        this.classAssessmentList = classAssessmentList;
    }

    @XmlTransient
    public List<ClassAssessmentCourse> getClassAssessmentCourseList() {
        return classAssessmentCourseList;
    }

    public void setClassAssessmentCourseList(List<ClassAssessmentCourse> classAssessmentCourseList) {
        this.classAssessmentCourseList = classAssessmentCourseList;
    }

    @XmlTransient
    public List<CourseAssessment> getCourseAssessmentList() {
        return courseAssessmentList;
    }

    public void setCourseAssessmentList(List<CourseAssessment> courseAssessmentList) {
        this.courseAssessmentList = courseAssessmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Assessment[ id=" + id + " ]";
    }
    
}
