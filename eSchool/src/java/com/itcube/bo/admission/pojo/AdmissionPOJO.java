/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.admission.pojo;

import com.itcube.bo.configuration.pojo.AcademicYearPOJO;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class AdmissionPOJO {
    private String admDate;
    private List<AcademicYearPOJO> academicYearList;    
    private String studentId;
    private String studentName;
    private String gender;
    private String dob;
    private String presentAddress;
    private String permanentAddress;
    private String country;
    private String state;

    public List<AcademicYearPOJO> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<AcademicYearPOJO> academicYearList) {
        this.academicYearList = academicYearList;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
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
}
