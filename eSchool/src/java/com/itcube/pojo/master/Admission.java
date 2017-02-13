/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.master;

import com.itcube.hibernate.db.AcademicYear;
import com.itcube.hibernate.db.Standard;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class Admission {

    private String admDate;
    private String academicYear;
    private String studentId;
    private String studentName;
    private String gender;
    private String dob;
    private String presentAddress;
    private String permanentAddress;
    private String country;
    private String state;
    private String district;
    private String taluka;
    private String pincode;
    private String landline;
    private String mobile;
    private String email;
    private String standard;
    private String division;
    private String subject;
    private AcademicYear accYearList;
    private List<com.itcube.hibernate.db.Standard> stdDetailsList;
    private String msg;

    public String getAcademicYear() {
        return academicYear;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAdmDate() {
        return admDate;
    }

    public void setAdmDate(String admDate) {
        this.admDate = admDate;
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public List<Standard> getStdDetailsList() {
        return stdDetailsList;
    }

    public void setStdDetailsList(List<Standard> stdDetailsList) {
        this.stdDetailsList = stdDetailsList;
    }

    public AcademicYear getAccYearList() {
        return accYearList;
    }

    public void setAccYearList(AcademicYear accYearList) {
        this.accYearList = accYearList;
    }
    
}
