/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */

@Entity
@Table(name="Student")
public class Student1 implements Serializable {
    @Id
    //@GeneratedValue
    @Column(name="studentCode")
    private Long id;
    @Column(name="studentFname")
    private String fname;
    @Column(name="studentMname")
    private String mname;
    @Column(name="studentLname")
    private String lname;
    @Column(name="studentName")
    private String name;
    @Column(name="studentGender")
    private String gender;
    @Column(name="studentDOB")
    private String dateOfBirth;
    @Column(name="studentPresentAdd")
    private String presentAddress;
    @Column(name="studentPermanetAdd")
    private String permanentAddress;
    @Column(name="c_code")
    private String country;
    @Column(name="s_code")
    private String state;
    @Column(name="d_Code")
    private String district;
    @Column(name="t_Code")    
    private String taluka;
    @Column(name="studentPin")
    private String pincode;
    @Column(name="studentPhone")
    private String landline;
    @Column(name="studentMobile")
    private String mobile;
    @Column(name="studentEmail")
    private String email;
    @Column(name="photoPath")
    private String photo;
    @Column(name="signPath")
    private String signature;
    @OneToMany(mappedBy = "studentCode")
    private Collection<Enrollment> enrollmentCollection;
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }    
}
