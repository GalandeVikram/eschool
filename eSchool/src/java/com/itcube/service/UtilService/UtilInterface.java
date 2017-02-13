/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.UtilService;

import com.itcube.bo.configuration.pojo.SubjectPOJO;
import com.itcube.hibernate.db.District;
import com.itcube.hibernate.db.State;
import com.itcube.hibernate.db.Taluka;
import com.itcube.hibernate.model.Country1;
import com.itcube.pojo.master.Exam;

import com.itcube.hibernate.db.Student;
import com.itcube.pojo.master.Subject;
import com.itcube.pojo.master.Village;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface UtilInterface {
    public List<Country1> getAllCountries();
    public List<State> getStateList(String countryCode);
    public List<District> getDistrictList(int stateCode);
    public List<Taluka> getTalukaList(int districtCode);
    public List<Village> getVillageList(String talukaCode);    
    public Student getStudentInfo(int studentCode);    
    public List<Exam> getMasterExam();    
    public List<Subject> getExamDetailCode(String standardCode, String examCode);
    public List<Student> getStudentRollNoList(String standardCode);    
    public List<Student> getStudentList(String studName);    
    public List<SubjectPOJO> getSubject(long classRoomID);
}
