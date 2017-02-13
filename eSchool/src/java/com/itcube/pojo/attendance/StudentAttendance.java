/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.attendance;

/**
 *
 * @author vikram.galande
 */
public class StudentAttendance {

    private String attendanceDate;
    private String stdCode;
    private String stdName;
    private String subCode;
    private String subName;
    private String teacherCode;
    private String teacherName;
    private String rollNumbers;

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getRollNumbers() {
        return rollNumbers;
    }

    public void setRollNumbers(String rollNumbers) {
        this.rollNumbers = rollNumbers;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
