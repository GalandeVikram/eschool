/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

import com.itcube.pojo.master.Admission;
import com.itcube.service.master.AcademicYearInterface;
import com.itcube.service.master.AdmissionInterface;
import com.itcube.service.master.StandardInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/admission.htm")
@SessionAttributes("admission")
public class AdmissionController {

    private StandardInterface standardInterface;
    private AcademicYearInterface academicYearInterface;
    private AdmissionInterface admissionInterface;

    @Autowired
    public void setAcademicYearInterface(AcademicYearInterface academicYearInterface) {
        this.academicYearInterface = academicYearInterface;
    }

    @Autowired
    public void setStandardInterface(StandardInterface standardInterface) {
        this.standardInterface = standardInterface;
    }

    @Autowired
    public void setAdmissionInterface(AdmissionInterface admissionInterface) {
        this.admissionInterface = admissionInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Admission admission = new Admission();
        admission.setAdmDate(dateFormat.format(date));
        admission.setAccYearList(academicYearInterface.getAcademicYear());
        admission.setStdDetailsList(standardInterface.getCurrentYearStandard(academicYearInterface.getCurrentAcademicYearID()));
        model.addAttribute("admission", admission);
        return "master/admission";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("admission") Admission admission) {
        admissionInterface.add(admission);
        return "master/admissionSuccess";
    }
}
