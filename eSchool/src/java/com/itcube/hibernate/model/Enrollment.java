/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {

    @Id
    @Column(name = "roll_code")
    private BigInteger rollNumber;
    
    @JoinColumn(name = "studentCode", referencedColumnName = "studentCode")
    @ManyToOne
    private Student1 studentCode;
    
    @JoinColumn(name = "stdd_code", referencedColumnName = "stdd_code")
    @ManyToOne
    private StandardDetail stddCode;

    public BigInteger getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(BigInteger rollNumber) {
        this.rollNumber = rollNumber;
    }

    public StandardDetail getStddCode() {
        return stddCode;
    }

    public void setStddCode(StandardDetail stddCode) {
        this.stddCode = stddCode;
    }

    public Student1 getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Student1 studentCode) {
        this.studentCode = studentCode;
    }
    
}
