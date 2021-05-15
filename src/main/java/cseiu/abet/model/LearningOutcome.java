/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "learning_outcome")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "LearningOutcome.findAll", query = "SELECT l FROM LearningOutcome l")
    , @NamedQuery(name = "LearningOutcome.findById", query = "SELECT l FROM LearningOutcome l WHERE l.id = :id")})
public class LearningOutcome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Lob
    @Column(name = "description_vn")
    private String descriptionVn;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningOutcome")
    private List<CloSlo> cloSloList;

    @XmlTransient
    @JsonBackReference
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningOutcome")
    private List<AssessmentTool> assessmentToolList;

    @XmlTransient
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningOutcomeId")
    private List<ClassAssessment> classAssessmentList;

    public LearningOutcome() {
    }

    public LearningOutcome(Integer id) {
        this.id = id;
    }

    public LearningOutcome(Integer id, String description, String descriptionVn) {
        this.id = id;
        this.description = description;
        this.descriptionVn = descriptionVn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionVn() {
        return descriptionVn;
    }

    public void setDescriptionVn(String descriptionVn) {
        this.descriptionVn = descriptionVn;
    }

    @XmlTransient
    public List<CloSlo> getCloSloList() {
        return cloSloList;
    }

    public void setCloSloList(List<CloSlo> cloSloList) {
        this.cloSloList = cloSloList;
    }

    public Object getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningOutcome)) {
            return false;
        }
        LearningOutcome other = (LearningOutcome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LearningOutcome[ id=" + id + " ]";
    }
    
}
