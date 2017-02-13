/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo.master;

import com.itcube.bo.configuration.pojo.ClassRoomPOJO;
import com.itcube.bo.configuration.pojo.SubjectPOJO;
import com.itcube.bo.exam.pojo.ExamPOJO;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class SetExam {

    private List<ClassRoomPOJO> classRoomList;
    private List<ExamPOJO> examList;
    private List<SubjectPOJO> subjectList;
    private String classRoomCode;
    private String examCode;
    private String subjectCode;
    private String examDate;
    private String examStartTime;
    private String examEndTime;
    private String examMaxMarks;
    private String examMinMarks;

    public String getClassRoomCode() {
        return classRoomCode;
    }

    public void setClassRoomCode(String classRoomCode) {
        this.classRoomCode = classRoomCode;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public List<ExamPOJO> getExamList() {
        return examList;
    }

    public void setExamList(List<ExamPOJO> examList) {
        this.examList = examList;
    }

    public String getExamMaxMarks() {
        return examMaxMarks;
    }

    public void setExamMaxMarks(String examMaxMarks) {
        this.examMaxMarks = examMaxMarks;
    }

    public String getExamMinMarks() {
        return examMinMarks;
    }

    public void setExamMinMarks(String examMinMarks) {
        this.examMinMarks = examMinMarks;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public List<SubjectPOJO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectPOJO> subjectList) {
        this.subjectList = subjectList;
    }

    public List<ClassRoomPOJO> getClassRoomList() {
        return classRoomList;
    }

    public void setClassRoomList(List<ClassRoomPOJO> classRoomList) {
        this.classRoomList = classRoomList;
    }
}
