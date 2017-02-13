/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.master;

import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class ExamForm {
    private String msg;
    private String academicYear;
    private List<AcademicYear> accYearList;
    private String examMaster;
    private List<Exam> examMasterList;
    private String standard;
    private List<Standard> standardList;
    private String subject;
    private List<Subject> subjectList;
    private String student;
    private List<Student> studentList;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    
    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public List<AcademicYear> getAccYearList() {
        return accYearList;
    }

    public void setAccYearList(List<AcademicYear> accYearList) {
        this.accYearList = accYearList;
    }

    public String getExamMaster() {
        return examMaster;
    }

    public void setExamMaster(String examMaster) {
        this.examMaster = examMaster;
    }

    public List<Exam> getExamMasterList() {
        return examMasterList;
    }

    public void setExamMasterList(List<Exam> examMasterList) {
        this.examMasterList = examMasterList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
