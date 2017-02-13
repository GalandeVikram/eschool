/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.dto;

import java.io.Serializable;

/**
 *
 * @author vikram.galande
 */
public class ExamDTO implements Serializable{
    private int examDetailID;
    private String examDetailName;

    public int getExamDetailID() {
        return examDetailID;
    }

    public void setExamDetailID(int examDetailID) {
        this.examDetailID = examDetailID;
    }

    public String getExamDetailName() {
        return examDetailName;
    }

    public void setExamDetailName(String examDetailName) {
        this.examDetailName = examDetailName;
    }
}
