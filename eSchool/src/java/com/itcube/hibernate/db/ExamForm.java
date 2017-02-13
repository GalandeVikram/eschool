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
@Table(name = "ExamForm")
@XmlRootElement
public class ExamForm implements Serializable{
    @Id    
    @Column(name = "seatNumber", length = 12, nullable = false)
    private int seatNumber;
    
    @JoinColumn(name = "examDetailID", referencedColumnName = "examDetailID")
    @ManyToOne
    private ExamDetail examDetailID;
    
    @JoinColumn(name = "rollNumber", referencedColumnName = "rollNumber")
    @ManyToOne
    private Admission rollNumber;
    
    @XmlTransient
    @OneToMany(mappedBy = "seatNumber")
    private Collection<ExamResult> seatNumberCollection;
    
    public ExamDetail getExamDetailID() {
        return examDetailID;
    }

    public void setExamDetailID(ExamDetail examDetailID) {
        this.examDetailID = examDetailID;
    }
    
    public Admission getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Admission rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Collection<ExamResult> getSeatNumberCollection() {
        return seatNumberCollection;
    }
    
    public void setSeatNumberCollection(Collection<ExamResult> seatNumberCollection) {
        this.seatNumberCollection = seatNumberCollection;
    }
}
