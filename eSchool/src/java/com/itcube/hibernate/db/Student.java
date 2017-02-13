/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "Student")
@XmlRootElement
public class Student implements Serializable{
    @Id
    @Column(name="studID", length=8, nullable=false)
    private int studID;
    
    @Column(name="studName", length=50, nullable=false)
    private String studName;
    
    @Column(name="studDOB")    
    private Date studDOB;
    
    @Column(name="studGender", length=1, nullable=false)
    private char studGender;
    
    @Column(name="studAddress1", length=50, nullable=false)
    private String studAddress1;
    
    @Column(name="studAddress2", length=50, nullable=false)
    private String studAddress2;
    
    @JoinColumn(name = "talukaID", referencedColumnName = "talukaID")
    @ManyToOne
    private Taluka talukaID;
    
    @Column(name="studContact", length=50, nullable=false)
    private String studContact;
    
    @Column(name="studEmail", length=50, nullable=false)
    private String studEmail;
    
    @Column(name="studPhotoPath", length=265, nullable=false)
    private String studPhotoPath;
    
    @Column(name="studSignPath", length=265, nullable=false)
    private String studSignPath;

    @OneToMany(mappedBy = "studID")
    private Collection<Admission> admissionCollection;
    
    
    public String getStudAddress1() {
        return studAddress1;
    }

    public void setStudAddress1(String studAddress1) {
        this.studAddress1 = studAddress1;
    }

    public String getStudAddress2() {
        return studAddress2;
    }

    public void setStudAddress2(String studAddress2) {
        this.studAddress2 = studAddress2;
    }

    public String getStudContact() {
        return studContact;
    }

    public void setStudContact(String studContact) {
        this.studContact = studContact;
    }

    public Date getStudDOB() {
        return studDOB;
    }

    public void setStudDOB(Date studDOB) {
        this.studDOB = studDOB;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public char getStudGender() {
        return studGender;
    }

    public void setStudGender(char studGender) {
        this.studGender = studGender;
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudPhotoPath() {
        return studPhotoPath;
    }

    public void setStudPhotoPath(String studPhotoPath) {
        this.studPhotoPath = studPhotoPath;
    }

    public String getStudSignPath() {
        return studSignPath;
    }

    public void setStudSignPath(String studSignPath) {
        this.studSignPath = studSignPath;
    }

    @XmlTransient
    public Collection<Admission> getAdmissionCollection() {
        return admissionCollection;
    }

    public void setAdmissionCollection(Collection<Admission> admissionCollection) {
        this.admissionCollection = admissionCollection;
    }

    public Taluka getTalukaID() {
        return talukaID;
    }

    public void setTalukaID(Taluka talukaID) {
        this.talukaID = talukaID;
    }
}
