/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "ExamDetail")
@XmlRootElement
public class ExamDetail implements Serializable {

    @Id
    @Column(name = "examDetailID", length = 10, nullable = false)
    private int examDetailID;
    
    @Column(name = "examDetailName", length = 50, nullable = false)
    private String examDetailName;
    
    @JoinColumn(name = "examID", referencedColumnName = "examID")
    @ManyToOne
    private Exam examID;
    
    @JoinColumn(name = "academicYearID", referencedColumnName = "academicYearID")
    @ManyToOne
    private AcademicYear academicYearID;
    
    @XmlTransient
    @OneToMany(mappedBy = "examDetailID")
    private Collection<ExamTransaction> examTransactionCollection;
    
    @XmlTransient
    @OneToMany(mappedBy = "examDetailID")
    private Collection<ExamForm> examFormCollection;

    public int getExamDetailID() {
        return examDetailID;
    }

    public void setExamDetailID(int examDetailID) {
        this.examDetailID = examDetailID;
    }

    public String getExamDetailName() {
        return examDetailName;
    }

    public void setExamDetailName(String examDetailName) {
        this.examDetailName = examDetailName;
    }

    public Exam getExamID() {
        return examID;
    }

    public void setExamID(Exam examID) {
        this.examID = examID;
    }

    public AcademicYear getAcademicYearID() {
        return academicYearID;
    }

    public void setAcademicYearID(AcademicYear academicYearID) {
        this.academicYearID = academicYearID;
    }

    public Collection<ExamForm> getExamFormCollection() {
        return examFormCollection;
    }

    public void setExamFormCollection(Collection<ExamForm> examFormCollection) {
        this.examFormCollection = examFormCollection;
    }

    public Collection<ExamTransaction> getExamTransactionCollection() {
        return examTransactionCollection;
    }

    public void setExamTransactionCollection(Collection<ExamTransaction> examTransactionCollection) {
        this.examTransactionCollection = examTransactionCollection;
    }
}
