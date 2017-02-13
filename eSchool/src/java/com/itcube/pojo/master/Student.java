/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.master;

import java.util.List;
import com.itcube.hibernate.model.Country1;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 *
 * @author vikram.galande
 */
public class Student {    
    private String studentID;
    private String rollNumber;
    private String code;
    private String name;
    private String fname;
    private String mname;
    private String lname;
    private String dateOfBirth;
    private String presentAddress;
    private String permanentAddress;
    private String country;
    private String state;
    private String district;
    private String taluka;
    private String gender;
    private String pincode;
    private String landline;
    private String mobile;
    private String email;
    private String photo;
    private CommonsMultipartFile photoData;
    private CommonsMultipartFile signData;
    private String signature;
    private String saveBtn;
    public List<Country1> countryList;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    

    public String getPincode() {
        return pincode;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public List<Country1> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country1> countryList) {
        this.countryList = countryList;
    }

    public CommonsMultipartFile getPhotoData() {
        return photoData;
    }

    public void setPhotoData(CommonsMultipartFile photoData) {
        this.photoData = photoData;
    }

    public CommonsMultipartFile getSignData() {
        return signData;
    }

    public void setSignData(CommonsMultipartFile signData) {
        this.signData = signData;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(String saveBtn) {
        this.saveBtn = saveBtn;
    }
}
