/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cseiu.abet.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id")
    , @NamedQuery(name = "Instructor.findByName", query = "SELECT i FROM Instructor i WHERE i.name = :name")
    , @NamedQuery(name = "Instructor.findByDegree", query = "SELECT i FROM Instructor i WHERE i.degree = :degree")
    , @NamedQuery(name = "Instructor.findByEmail", query = "SELECT i FROM Instructor i WHERE i.email = :email")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "degree")
    private String degree;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorId")
    private List<ClassSession> classList;

    @OneToOne(mappedBy = "instructor")
    @JoinColumn(referencedColumnName = "id")
    private Account account;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    
    public List<ClassSession> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassSession> classList) {
        this.classList = classList;
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
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Instructor[ id=" + id + " ]";
    }
    
}
