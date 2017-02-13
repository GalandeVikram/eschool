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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "academicYear")
@XmlRootElement
public class AcademicYear implements Serializable {
    @Id
    @Column(name = "academicYearID", nullable = false)
    private int academicYearID;
    @Column(name = "academicYearName")
    private String academicYearName;
    
    @OneToMany(mappedBy = "academicYearID")
    private Collection<ClassRoom> classRoomCollection;
    
    @OneToMany(mappedBy = "academicYearID")
    private Collection<ExamDetail> examDetailCollection;    
    

    public int getAcademicYearID() {
        return academicYearID;
    }

    public void setAcademicYearID(int academicYearID) {
        this.academicYearID = academicYearID;
    }

    public String getAcademicYearName() {
        return academicYearName;
    }

    public void setAcademicYearName(String academicYearName) {
        this.academicYearName = academicYearName;
    }

    @XmlTransient
    public Collection<ClassRoom> getClassRoomCollection() {
        return classRoomCollection;
    }

    public void setClassRoomCollection(Collection<ClassRoom> classRoomCollection) {
        this.classRoomCollection = classRoomCollection;
    }

    @XmlTransient
    public Collection<ExamDetail> getExamDetailCollection() {
        return examDetailCollection;
    }

    public void setExamDetailCollection(Collection<ExamDetail> examDetailCollection) {
        this.examDetailCollection = examDetailCollection;
    }
    
    
}
