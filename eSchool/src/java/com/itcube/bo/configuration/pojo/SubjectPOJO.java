/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.configuration.pojo;

/**
 *
 * @author vikram.galande
 */
public class SubjectPOJO {
    private String subjectID;
    private String subjectName;
    private String marksObtained;
    private String subjectMaxMarks;
    private String subjectMinMarks;
    private String subjectResultFlag;
    private String examTXNID;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String getSubjectMaxMarks() {
        return subjectMaxMarks;
    }

    public void setSubjectMaxMarks(String subjectMaxMarks) {
        this.subjectMaxMarks = subjectMaxMarks;
    }

    public String getSubjectMinMarks() {
        return subjectMinMarks;
    }

    public void setSubjectMinMarks(String subjectMinMarks) {
        this.subjectMinMarks = subjectMinMarks;
    }

    public String getSubjectResultFlag() {
        return subjectResultFlag;
    }

    public void setSubjectResultFlag(String subjectResultFlag) {
        this.subjectResultFlag = subjectResultFlag;
    }

    public String getExamTXNID() {
        return examTXNID;
    }

    public void setExamTXNID(String examTXNID) {
        this.examTXNID = examTXNID;
    }
}
