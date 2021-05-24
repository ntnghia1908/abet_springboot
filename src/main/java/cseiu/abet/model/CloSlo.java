/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "clo_slo")
@XmlRootElement
public class CloSlo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CloSloPK cloSloPK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentage")
    private Float percentage;


    @JoinColumn(name ="slo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Slo slo;


    @JoinColumn(name = "lo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LearningOutcome learningOutcome;


    public CloSlo() {
    }

    public CloSlo(CloSloPK cloSloPK) {
        this.cloSloPK = cloSloPK;
    }

    public CloSlo(int sloId, int loId) {
        this.cloSloPK = new CloSloPK(sloId, loId);
    }

    public CloSloPK getCloSloPK() {
        return cloSloPK;
    }

    public void setCloSloPK(CloSloPK cloSloPK) {
        this.cloSloPK = cloSloPK;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public LearningOutcome getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(LearningOutcome learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cloSloPK != null ? cloSloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CloSlo)) {
            return false;
        }
        CloSlo other = (CloSlo) object;
        if ((this.cloSloPK == null && other.cloSloPK != null) || (this.cloSloPK != null && !this.cloSloPK.equals(other.cloSloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CloSlo[ cloSloPK=" + cloSloPK + " ]";
    }
    
}
