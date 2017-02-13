/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ClassRoom")
@XmlRootElement
public class ClassRoom implements Serializable {
    
    private Long classRoomID;
    private Room roomID;
    private Division divisionID;
    private Standard stdID;
    private AcademicYear academicYearID;
    private Collection<Admission> admissionCollection;
    private Set<SubjectDetail> subjectDetails = new HashSet<SubjectDetail>(0);    
    private Collection<ExamTransaction> ExamTransactionCollection;
    
    @Id
    @Column(name = "classRoomID", nullable = false)
    public Long getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(Long classRoomID) {
        this.classRoomID = classRoomID;
    }

    @JoinColumn(name = "academicYearID", referencedColumnName = "academicYearID")
    @ManyToOne
    public AcademicYear getAcademicYearID() {
        return academicYearID;
    }

    public void setAcademicYearID(AcademicYear academicYearID) {
        this.academicYearID = academicYearID;
    }

    @JoinColumn(name = "divisionID", referencedColumnName = "divisionID")
    @ManyToOne
    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }

    @JoinColumn(name = "roomID", referencedColumnName = "roomID")
    @ManyToOne
    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    @JoinColumn(name = "stdID", referencedColumnName = "stdID")
    @ManyToOne
    public Standard getStdID() {
        return stdID;
    }

    public void setStdID(Standard stdID) {
        this.stdID = stdID;
    }

    @OneToMany(mappedBy = "classRoomID")
    @XmlTransient
    public Collection<Admission> getAdmissionCollection() {
        return admissionCollection;
    }

    public void setAdmissionCollection(Collection<Admission> admissionCollection) {
        this.admissionCollection = admissionCollection;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ClassRoom_Subject", joinColumns = {
        @JoinColumn(name = "classRoomID")}, inverseJoinColumns = {
        @JoinColumn(name = "subjectDetailID")})
    public Set<SubjectDetail> getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(Set<SubjectDetail> subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @XmlTransient
    @OneToMany(mappedBy = "classRoomID")
    public Collection<ExamTransaction> getExamTransactionCollection() {
        return ExamTransactionCollection;
    }

    public void setExamTransactionCollection(Collection<ExamTransaction> ExamTransactionCollection) {
        this.ExamTransactionCollection = ExamTransactionCollection;
    }
}
