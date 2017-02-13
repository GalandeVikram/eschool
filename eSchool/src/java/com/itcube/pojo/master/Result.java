/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.master;

import com.itcube.hibernate.db.AcademicYear;
import java.util.List;
import com.itcube.hibernate.db.Standard;

/**
 *
 * @author vikram.galande
 */
public class Result {

    private String academicYear;
    private AcademicYear accYearList;
    private String standard;
    private List<Standard> standardList;
    private String rollNumber;
    private String seatNumber;
    private String studentName;
    private String totoalMarks;
    private String grade;
    private List<ResultDetails> resultDetails;
    private String result;
    private List<Result> finalResultList;

    public List<Result> getFinalResultList() {
        return finalResultList;
    }

    public void setFinalResultList(List<Result> finalResultList) {
        this.finalResultList = finalResultList;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public AcademicYear getAccYearList() {
        return accYearList;
    }

    public void setAccYearList(AcademicYear accYearList) {
        this.accYearList = accYearList;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public List<Standard> getStandardList() {
        return standardList;
    }

    public void setStandardList(List<Standard> standardList) {
        this.standardList = standardList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ResultDetails> getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(List<ResultDetails> resultDetails) {
        this.resultDetails = resultDetails;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTotoalMarks() {
        return totoalMarks;
    }

    public void setTotoalMarks(String totoalMarks) {
        this.totoalMarks = totoalMarks;
    }
}
