/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.result.pojo;

import com.itcube.bo.configuration.pojo.SubjectPOJO;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class ResultPOJO {
    private String examName;
    private String studentName;
    private String standardName;
    private String division;
    private String rollNumber;
    private String seatNumber;
    private List<SubjectPOJO> subjectList;
    private String grade;
    private String result;
    private String place;
    private String resultDate;
    private String totalMarksObtained;
    private String totalMarks;
    private String percentage;
    
    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<SubjectPOJO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectPOJO> subjectList) {
        this.subjectList = subjectList;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getTotalMarksObtained() {
        return totalMarksObtained;
    }

    public void setTotalMarksObtained(String totalMarksObtained) {
        this.totalMarksObtained = totalMarksObtained;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
