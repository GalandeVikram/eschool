/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.interfaces;

import com.itcube.bo.configuration.pojo.ClassRoomPOJO;
import com.itcube.bo.exam.pojo.ExamPOJO;
import com.itcube.pojo.master.SetExam;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface ExamInterface {
    //public String createAdmission(AdmissionPOJO pojo);    
    public List<ClassRoomPOJO> getClassRoomList(int academicYear);  
    public List<ExamPOJO> getExamList(int academicYear);  
    public void addExam(SetExam setExam);
    public void addExamForm(SetExam setExam);
}
