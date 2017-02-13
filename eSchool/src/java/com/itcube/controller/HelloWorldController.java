/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller;

import com.itcube.bo.configuration.pojo.SubjectPOJO;
import com.itcube.hibernate.db.District;
import com.itcube.hibernate.db.State;
import com.itcube.hibernate.db.Student;
import com.itcube.hibernate.db.Taluka;
import com.itcube.service.UtilService.UtilInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author vikram.galande
 */
@Controller
public class HelloWorldController {

    private UtilInterface utilInterface;

    @Autowired
    public void setUtilInterface(UtilInterface utilInterface) {
        this.utilInterface = utilInterface;
    }

    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        return new ModelAndView("hello", "message", "Spring MVC Demo");
    }

    @RequestMapping(value = "/getState", method = RequestMethod.GET)
    public @ResponseBody
    String getState(@RequestParam String countryCode) {
        List<State> listState = new ArrayList<State>();
        System.out.println("countryCode :" + countryCode);
        listState = utilInterface.getStateList(countryCode);
        String stateString = "0000:Select";

        for (State s : listState) {
            stateString = stateString + ";" + s.getStateID() + ":" + s.getStateName();
        }
        return stateString;
    }

    @RequestMapping(value = "/getDistrict", method = RequestMethod.GET)
    public @ResponseBody
    String getDistrict(@RequestParam String stateCode) {
        List<District> listDistrict = new ArrayList<District>();
        System.out.println("stateCode :" + stateCode);
        listDistrict = utilInterface.getDistrictList(Integer.parseInt(stateCode));
        String districtString = "000000:Select";

        for (District d : listDistrict) {
            districtString = districtString + ";" + d.getDistrictID() + ":" + d.getDistrictName();
        }
        return districtString;
    }

    @RequestMapping(value = "/getTaluka", method = RequestMethod.GET)
    public @ResponseBody
    String getTaluka(@RequestParam String districtCode) {
        List<Taluka> listTaluka = new ArrayList<Taluka>();
        System.out.println("talukaCode :" + districtCode);
        listTaluka = utilInterface.getTalukaList(Integer.parseInt(districtCode));
        String talukaString = "00000000:Select";

        for (Taluka t : listTaluka) {
            talukaString = talukaString + ";" + t.getTalukaID() + ":" + t.getTalukaName();
        }
        return talukaString;
    }

    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    public @ResponseBody
    String getStudentInfo(@RequestParam String studentCode) {
        com.itcube.hibernate.db.Student student = new com.itcube.hibernate.db.Student();
        student = utilInterface.getStudentInfo(Integer.parseInt(studentCode));
        String studentInfo = "";
        if (null != student) {
            studentInfo = studentInfo + student.getStudName() + ";"
                    + student.getStudGender() + ";"
                    + student.getStudDOB() + ";"
                    + student.getStudAddress1() + ";"
                    + student.getStudAddress2() + ";"
                    + "" + ";"
                    + "" + ";"
                    + "" + ";"
                    + "" + ";"
                    + "" + ";"
                    + "" + ";"
                    + student.getStudContact() + ";"
                    + student.getStudEmail() + ";";
        }
        return studentInfo;
    }
    
    
    @RequestMapping(value = "/searchStudent", method = RequestMethod.GET)
    public @ResponseBody
    String searchStudent(@RequestParam String studentStr) {
        List<com.itcube.hibernate.db.Student> studentList = new ArrayList<Student>();
        studentList = utilInterface.getStudentList(studentStr);
        String studentInfo = "";        
        for (Student s : studentList) {
            studentInfo = studentInfo + ";" + s.getStudID() + ":" + s.getStudName()+ ":"+ s.getStudDOB();
        }
        return studentInfo;
    }
    
    
    @RequestMapping(value = "/getSubject", method = RequestMethod.GET)
    public @ResponseBody
    String getSubject(@RequestParam String classrooID) {
        List<SubjectPOJO> subjectList = new ArrayList<SubjectPOJO>();        
        subjectList = utilInterface.getSubject(Long.parseLong(classrooID));
        String subjectString = "0000:Select";
        for (SubjectPOJO s : subjectList) {
            subjectString = subjectString + ";" + s.getSubjectID() + ":" + s.getSubjectName();
        }
        return subjectString;
    }
    
     @RequestMapping(value = "/getResultPDF", method = RequestMethod.GET)
    public void testReportPDF(@RequestParam String seatNumber) {
        System.out.println("SeatNumber: "+seatNumber);
        
    }
    
    
//    @RequestMapping(value = "/getExamCode", method = RequestMethod.GET)
//    public @ResponseBody
//    String getExamCode(@RequestParam String standardCode, String examCode) {
//        List<Subject> subjectList = new ArrayList<Subject>();
//        System.out.println("standardCode :" + standardCode);
//        subjectList = utilInterface.getExamDetailCode(standardCode, examCode);
//        String subjectString = "0000:Select";
//        for (Subject s : subjectList) {
//            subjectString = subjectString + ";" + s.getSubjectCode() + ":" + s.getSubjectName();
//        }
//        return subjectString;
//    }
    
//    @RequestMapping(value = "/getStudentRollNo", method = RequestMethod.GET)
//    public @ResponseBody
//    String getStudentRollNo(@RequestParam String standardCode) {
//        List<Student> studentList = new ArrayList<Student>();
//        System.out.println("standardCode :" + standardCode);
//        //studentList = utilInterface.getStudentRollNoList(standardCode);
//        String studentString = "0000:Select";
//        for (Student s : studentList) {
//            studentString = studentString + ";" + s.getRollNumber() + ":" + s.getName();
//        }
//        return studentString;
//    }

   
}
