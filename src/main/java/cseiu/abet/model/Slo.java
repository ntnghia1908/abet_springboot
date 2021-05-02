/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "slo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slo.findAll", query = "SELECT s FROM Slo s")
    , @NamedQuery(name = "Slo.findById", query = "SELECT s FROM Slo s WHERE s.id = :id")
    , @NamedQuery(name = "Slo.findByDescription", query = "SELECT s FROM Slo s WHERE s.description = :description")
    , @NamedQuery(name = "Slo.findByCriteria", query = "SELECT s FROM Slo s WHERE s.criteria = :criteria")})
public class Slo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "criteria")
    private Integer criteria;

    public Slo() {
    }

    public Slo(Integer id) {
        this.id = id;
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

    public Integer getCriteria() {
        return criteria;
    }

    public void setCriteria(Integer criteria) {
        this.criteria = criteria;
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
        if (!(object instanceof Slo)) {
            return false;
        }
        Slo other = (Slo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Slo[ id=" + id + " ]";
    }
    
}
