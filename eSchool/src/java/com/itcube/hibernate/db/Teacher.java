/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;


import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable{
    @Id
    @Column(name="teachID", length=8, nullable=false)
    private int teachID;
    
    @Column(name="teachName", length=50, nullable=false)
    private String teachName;
    
    @Column(name="teachDOB")    
    private Date teachDOB;
    
    @Column(name="teachGender", length=1, nullable=false)
    private char teachGender;
    
    @Column(name="teachAddress1", length=50, nullable=false)
    private String teachAddress1;
    
    @Column(name="teachAddress2", length=50, nullable=false)
    private String teachAddress2;
    
    @Column(name="teachContact", length=50, nullable=false)
    private String teachContact;
    
    @Column(name="teachEmail", length=50, nullable=false)
    private String teachEmail;
    
    @Column(name="teachPhotoPath", length=50, nullable=false)
    private String teachPhotoPath;
    
    @Column(name="teachSignPath", length=50, nullable=false)
    private String teachSignPath;

    public String getTeachAddress1() {
        return teachAddress1;
    }

    public void setTeachAddress1(String teachAddress1) {
        this.teachAddress1 = teachAddress1;
    }

    public String getTeachAddress2() {
        return teachAddress2;
    }

    public void setTeachAddress2(String teachAddress2) {
        this.teachAddress2 = teachAddress2;
    }

    public String getTeachContact() {
        return teachContact;
    }

    public void setTeachContact(String teachContact) {
        this.teachContact = teachContact;
    }

    public Date getTeachDOB() {
        return teachDOB;
    }

    public void setTeachDOB(Date teachDOB) {
        this.teachDOB = teachDOB;
    }

    public String getTeachEmail() {
        return teachEmail;
    }

    public void setTeachEmail(String teachEmail) {
        this.teachEmail = teachEmail;
    }

    public char getTeachGender() {
        return teachGender;
    }

    public void setTeachGender(char teachGender) {
        this.teachGender = teachGender;
    }

    public int getTeachID() {
        return teachID;
    }

    public void setTeachID(int teachID) {
        this.teachID = teachID;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getTeachPhotoPath() {
        return teachPhotoPath;
    }

    public void setTeachPhotoPath(String teachPhotoPath) {
        this.teachPhotoPath = teachPhotoPath;
    }

    public String getTeachSignPath() {
        return teachSignPath;
    }

    public void setTeachSignPath(String teachSignPath) {
        this.teachSignPath = teachSignPath;
    }    
}
