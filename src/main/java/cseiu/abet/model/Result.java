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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meoco
 */
@Entity
@Table(name = "result")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
    , @NamedQuery(name = "Result.findByStudentId", query = "SELECT r FROM Result r WHERE r.resultPK.studentId = :studentId")
    , @NamedQuery(name = "Result.findByClassId", query = "SELECT r FROM Result r WHERE r.resultPK.classId = :classId")
    , @NamedQuery(name = "Result.findByMidScore", query = "SELECT r FROM Result r WHERE r.midScore = :midScore")
    , @NamedQuery(name = "Result.findByFinalScore", query = "SELECT r FROM Result r WHERE r.finalScore = :finalScore")
    , @NamedQuery(name = "Result.findByInClassScore", query = "SELECT r FROM Result r WHERE r.inClassScore = :inClassScore")
    , @NamedQuery(name = "Result.findByGpa", query = "SELECT r FROM Result r WHERE r.gpa = :gpa")
    , @NamedQuery(name = "Result.findByAbetScore", query = "SELECT r FROM Result r WHERE r.abetScore = :abetScore")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultPK resultPK;

    @Column(name = "mid_score")
    private Integer midScore;

    @Column(name = "final_score")
    private Integer finalScore;

    @Column(name = "in_class_score")
    private Integer inClassScore;

    @Column(name = "GPA")
    private Integer gpa;

    @Column(name = "abet_score")
    private Integer abetScore;

    @XmlTransient
    @JsonBackReference
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ClassSession class1;

    @XmlTransient
    @JsonBackReference
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    @Column(name = "abet_1")
    Integer abet1;

    @Column(name = "abet_2")
    Integer abet2;

    @Column(name = "abet_3")
    Integer abet3;

    @Column(name = "abet_4")
    Integer abet4;

    @Column(name = "abet_5")
    Integer abet5;

    @Column(name = "abet_6")
    Integer abet6;

    @Column(name = "avg")
    Float avg;

    public Result() {
    }

    public Result(ResultPK resultPK) {
        this.resultPK = resultPK;
    }

    public Result(String studentId, int classId) {
        this.resultPK = new ResultPK(studentId, classId);
    }

    public ResultPK getResultPK() {
        return resultPK;
    }

    public void setResultPK(ResultPK resultPK) {
        this.resultPK = resultPK;
    }

    public Integer getMidScore() {
        return midScore;
    }

    public void setMidScore(Integer midScore) {
        this.midScore = midScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public Integer getInClassScore() {
        return inClassScore;
    }

    public void setInClassScore(Integer inClassScore) {
        this.inClassScore = inClassScore;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

    public Integer getAbetScore() {
        return abetScore;
    }

    public void setAbetScore(Integer abetScore) {
        this.abetScore = abetScore;
    }

    public ClassSession getClass1() {
        return class1;
    }

    public void setClass1(ClassSession class1) {
        this.class1 = class1;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getAbet1() {
        return abet1;
    }

    public void setAbet1(Integer abet1) {
        this.abet1 = abet1;
    }

    public Integer getAbet2() {
        return abet2;
    }

    public void setAbet2(Integer abet2) {
        this.abet2 = abet2;
    }

    public Integer getAbet3() {
        return abet3;
    }

    public void setAbet3(Integer abet3) {
        this.abet3 = abet3;
    }

    public Integer getAbet4() {
        return abet4;
    }

    public void setAbet4(Integer abet4) {
        this.abet4 = abet4;
    }

    public Integer getAbet5() {
        return abet5;
    }

    public void setAbet5(Integer abet5) {
        this.abet5 = abet5;
    }

    public Integer getAbet6() {
        return abet6;
    }

    public void setAbet6(Integer abet6) {
        this.abet6 = abet6;
    }

    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultPK != null ? resultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.resultPK == null && other.resultPK != null) || (this.resultPK != null && !this.resultPK.equals(other.resultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Result[ resultPK=" + resultPK + " ]";
    }
    
}
