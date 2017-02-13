/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/testResult.htm")
public class TestResult {

//    @RequestMapping(method = RequestMethod.GET)
//    public String showUserForm(ModelMap model) {
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Admission admission = new Admission();
//        admission.setAdmDate(dateFormat.format(date));
//        admission.setAccYearList(academicYearInterface.getAcademicYear());
//        admission.setStdDetailsList(standardInterface.getCurrentYearStandard(academicYearInterface.getCurrentAcademicYearID()));
//        model.addAttribute("admission", admission);
//        return "master/admission";
//    }
}
