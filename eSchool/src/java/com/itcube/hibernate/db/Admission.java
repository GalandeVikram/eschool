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
@Table(name = "Admission")
@XmlRootElement
public class Admission implements Serializable {

    @Id
    @Column(name = "rollNumber", length = 8, nullable = false)
    private int rollNumber;
    
    @JoinColumn(name = "classRoomID", referencedColumnName = "classRoomID")
    @ManyToOne
    private ClassRoom classRoomID;
    
    @JoinColumn(name = "studID", referencedColumnName = "studID")
    @ManyToOne
    private Student studID;

    @XmlTransient
    @OneToMany(mappedBy = "rollNumber")
    private Collection<ExamForm> examFormCollection;
    
    public ClassRoom getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(ClassRoom classRoomID) {
        this.classRoomID = classRoomID;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Student getStudID() {
        return studID;
    }

    public void setStudID(Student studID) {
        this.studID = studID;
    }

    public Collection<ExamForm> getExamFormCollection() {
        return examFormCollection;
    }

    public void setExamFormCollection(Collection<ExamForm> examFormCollection) {
        this.examFormCollection = examFormCollection;
    }
}
