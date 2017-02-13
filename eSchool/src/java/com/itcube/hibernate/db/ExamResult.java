/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "ExamResult")
public class ExamResult implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "resultID", length = 6, nullable = false)
    private int resultID;
    
    @Column(name = "marksObtained", length = 3, nullable = true)
    private int marksObtained;
    
    @JoinColumn(name = "examTxnID", referencedColumnName = "examTxnID")
    @ManyToOne
    private ExamTransaction examTxnID;
    
    @JoinColumn(name = "seatNumber", referencedColumnName = "seatNumber")
    @ManyToOne
    private ExamForm seatNumber;

    public ExamTransaction getExamTxnID() {
        return examTxnID;
    }

    public void setExamTxnID(ExamTransaction examTxnID) {
        this.examTxnID = examTxnID;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public int getResultID() {
        if(0 == resultID){
            resultID = 1;
        }
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public ExamForm getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(ExamForm seatNumber) {
        this.seatNumber = seatNumber;
    }
}
