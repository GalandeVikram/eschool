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
@Table(name = "SubjectDetail")
@XmlRootElement
public class SubjectDetail implements Serializable{
    @Id
    @Column(name="subjectDetailID", length=10, nullable=false)    
    private int subjectDetailID;
        
    @Column(name="subjectDetailName", length=50, nullable=false)    
    private String subjectDetailName;    
    
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID")
    @ManyToOne
    private Subject subjectID;
    
    @XmlTransient
    @OneToMany(mappedBy = "subjectDetailID")
    private Collection<ExamTransaction> ExamTransactionCollection;

    public int getSubjectDetailID() {
        return subjectDetailID;
    }

    public void setSubjectDetailID(int subjectDetailID) {
        this.subjectDetailID = subjectDetailID;
    }

    public String getSubjectDetailName() {
        return subjectDetailName;
    }

    public void setSubjectDetailName(String subjectDetailName) {
        this.subjectDetailName = subjectDetailName;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }

    public Collection<ExamTransaction> getExamTransactionCollection() {
        return ExamTransactionCollection;
    }

    public void setExamTransactionCollection(Collection<ExamTransaction> ExamTransactionCollection) {
        this.ExamTransactionCollection = ExamTransactionCollection;
    }
}
