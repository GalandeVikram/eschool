/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.attendance;

import com.itcube.pojo.attendance.StudentAttendance;
import com.itcube.service.attendance.StudentAttendanceInterface;
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
@RequestMapping("/studentAttendance.htm")
@SessionAttributes("studentAttendance")
public class StudentAttendanceController {
    
    private StudentAttendanceInterface attendanceInterface;

    public void setAttendanceInterface(StudentAttendanceInterface attendanceInterface) {
        this.attendanceInterface = attendanceInterface;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        StudentAttendance studentAttendance = new StudentAttendance();
        model.addAttribute("studentAttendance", studentAttendance);
        return "attendance/studentAttendance";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("studentAttendance") StudentAttendance studentAttendance) {
        String msg = attendanceInterface.add(studentAttendance);
        return "attendance/studentAttendance";
    }
}
