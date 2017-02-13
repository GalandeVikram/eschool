/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo;

import com.itcube.bo.admission.pojo.AdmissionPOJO;
import com.itcube.bo.exam.deligates.ExamDelegates;

/**
 *
 * @author vikram.galande
 */
public class ExamBO {
    ExamDelegates examDelegates = null;
    public ExamBO() {
        examDelegates = new ExamDelegates();
    }
    
    public String createAdmission(AdmissionPOJO pojo) {
        return null;//examDelegates.createAdmission(pojo);
    }
}
