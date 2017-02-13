/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

import com.itcube.bo.interfaces.ExamInterface;
import com.itcube.pojo.master.SetExam;
import com.itcube.service.master.AcademicYearInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/setExam.htm")
@SessionAttributes("setExam")
public class SetExamController {

    private ExamInterface examInterface;
    private AcademicYearInterface academicYearInterface;

    @Autowired
    public void setAcademicYearInterface(AcademicYearInterface academicYearInterface) {
        this.academicYearInterface = academicYearInterface;
    }

    @Autowired
    public void setExamInterface(ExamInterface examInterface) {
        this.examInterface = examInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        com.itcube.hibernate.db.AcademicYear academicYearEntity = academicYearInterface.getAcademicYear();
        int currentYear = academicYearEntity.getAcademicYearID();
        SetExam setExam = new SetExam();
        setExam.setClassRoomList(examInterface.getClassRoomList(currentYear));
        setExam.setExamList(examInterface.getExamList(currentYear));
        model.addAttribute("setExam", setExam);
        return "master/setExam";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("setExam") SetExam setExam) {
        examInterface.addExam(setExam);
        //return "master/setExamSuccess";
        return "redirect:setExam.htm";
    }
}
