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
public class CloSloPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "slo_id")
    private int sloId;
    @Basic(optional = false)
    @Column(name = "lo_id")
    private int loId;

    public CloSloPK() {
    }

    public CloSloPK(int sloId, int loId) {
        this.sloId = sloId;
        this.loId = loId;
    }

    public int getSloId() {
        return sloId;
    }

    public void setSloId(int sloId) {
        this.sloId = sloId;
    }

    public int getLoId() {
        return loId;
    }

    public void setLoId(int loId) {
        this.loId = loId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sloId;
        hash += (int) loId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CloSloPK)) {
            return false;
        }
        CloSloPK other = (CloSloPK) object;
        if (this.sloId != other.sloId) {
            return false;
        }
        if (this.loId != other.loId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CloSloPK[ sloId=" + sloId + ", loId=" + loId + " ]";
    }
    
}
