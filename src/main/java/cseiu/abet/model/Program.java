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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")
    , @NamedQuery(name = "Program.findById", query = "SELECT p FROM Program p WHERE p.id = :id")
    , @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name")
    , @NamedQuery(name = "Program.findByDuration", query = "SELECT p FROM Program p WHERE p.duration = :duration")
    , @NamedQuery(name = "Program.findByVersion", query = "SELECT p FROM Program p WHERE p.version = :version")
    , @NamedQuery(name = "Program.findByType", query = "SELECT p FROM Program p WHERE p.type = :type")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "version")
    private String version;

    @Column(name = "type")
    private String type;

    @JsonBackReference
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    @ManyToOne
    private Major major;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private List<CourseProgram> courseProgramList;

    public Program() {
    }

    public Program(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @XmlTransient
    public List<CourseProgram> getCourseProgramList() {
        return courseProgramList;
    }

    public void setCourseProgramList(List<CourseProgram> courseProgramList) {
        this.courseProgramList = courseProgramList;
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
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Program[ id=" + id + " ]";
    }
    
}
