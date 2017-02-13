/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

import com.itcube.pojo.master.Teacher;
import com.itcube.service.master.TeacherInterface;
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
@RequestMapping("/teacher.htm")
@SessionAttributes("teacher")
public class TeacherController {

    TeacherInterface teacherInterface;

    @Autowired
    public void setTeacherInterface(TeacherInterface teacherInterface) {
        this.teacherInterface = teacherInterface;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "master/teacher";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("teacher") Teacher teacher) {
        String msg = teacherInterface.add(teacher);
        return "teacher";
    }
    
    
}
