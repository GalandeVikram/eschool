/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
@Table(name = "ExamTransaction")
@XmlRootElement
public class ExamTransaction implements Serializable {

    @Id    
    @Column(name = "examTxnID", nullable = false)
    private int examTxnID;
    @Column(name = "examTxnDate", nullable = false)
    private Date examTxnDate;
    @Column(name = "examTxnStartTime", nullable = false)
    private Time examTxnStartTime;
    @Column(name = "examTxnEndTime", nullable = false)
    private Time examTxnEndTime;
    @Column(name = "examTxnMaxMarks", nullable = false)
    private int examTxnMaxMarks;
    @Column(name = "examTxnMinMarks", nullable = false)
    private int examTxnMinMarks;
    
    @JoinColumn(name = "examDetailID", referencedColumnName = "examDetailID")
    @ManyToOne
    private ExamDetail examDetailID;
    
    @JoinColumn(name = "subjectDetailID", referencedColumnName = "subjectDetailID")
    @ManyToOne
    private SubjectDetail subjectDetailID;
    
    @JoinColumn(name = "classRoomID", referencedColumnName = "classRoomID")
    @ManyToOne
    private ClassRoom classRoomID;
    
    @XmlTransient
    @OneToMany(mappedBy = "examTxnID")
    private Collection<ExamResult> resultCollection;

    public ClassRoom getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(ClassRoom classRoomID) {
        this.classRoomID = classRoomID;
    }

    public ExamDetail getExamDetailID() {
        return examDetailID;
    }

    public void setExamDetailID(ExamDetail examDetailID) {
        this.examDetailID = examDetailID;
    }

    public SubjectDetail getSubjectDetailID() {
        return subjectDetailID;
    }

    public void setSubjectDetailID(SubjectDetail subjectDetailID) {
        this.subjectDetailID = subjectDetailID;
    }

    public Date getExamTxnDate() {
        return examTxnDate;
    }

    public void setExamTxnDate(Date examTxnDate) {
        this.examTxnDate = examTxnDate;
    }

    public Time getExamTxnEndTime() {
        return examTxnEndTime;
    }

    public void setExamTxnEndTime(Time examTxnEndTime) {
        this.examTxnEndTime = examTxnEndTime;
    }

    public int getExamTxnID() {
        return examTxnID;
    }

    public void setExamTxnID(int examTxnID) {
        this.examTxnID = examTxnID;
    }

    public int getExamTxnMaxMarks() {
        return examTxnMaxMarks;
    }

    public void setExamTxnMaxMarks(int examTxnMaxMarks) {
        this.examTxnMaxMarks = examTxnMaxMarks;
    }

    public int getExamTxnMinMarks() {
        return examTxnMinMarks;
    }

    public void setExamTxnMinMarks(int examTxnMinMarks) {
        this.examTxnMinMarks = examTxnMinMarks;
    }

    public Time getExamTxnStartTime() {
        return examTxnStartTime;
    }

    public void setExamTxnStartTime(Time examTxnStartTime) {
        this.examTxnStartTime = examTxnStartTime;
    }

    public Collection<ExamResult> getResultCollection() {
        return resultCollection;
    }

    public void setResultCollection(Collection<ExamResult> resultCollection) {
        this.resultCollection = resultCollection;
    }
}
