/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

import com.itcube.bo.interfaces.ResultInterface;
import com.itcube.bo.result.pojo.ResultPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/createResult.htm")
public class CreateResultController {
    private ResultInterface resultInterface;
    

    @Autowired
    public void setResultInterface(ResultInterface resultInterface) {
        this.resultInterface = resultInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        ResultPOJO result = new ResultPOJO();
        model.addAttribute("createResult", result);
        return "master/createResult";
    }

    @RequestMapping(method = RequestMethod.POST)    
    public String onSubmit(@ModelAttribute("setResult") ResultPOJO result) {
        ResultPOJO pojo = new ResultPOJO();        
        pojo = resultInterface.getResult(Integer.parseInt(result.getSeatNumber()));
        result.setStudentName(pojo.getStudentName());
        result.setExamName(pojo.getExamName());
        result.setStandardName(pojo.getStandardName());
        result.setRollNumber(pojo.getRollNumber());
        result.setDivision(pojo.getDivision());
        result.setSeatNumber(pojo.getSeatNumber());
        result.setSubjectList(pojo.getSubjectList());
        result.setResult(pojo.getResult());
        result.setPercentage(pojo.getPercentage() + " %");
        result.setResultDate(pojo.getResultDate());
        result.setPlace("PUNE");                
        //model.addAttribute("setResult", result); 
        return "master/setResult";
        //return "redirect:setResult.htm";
    }
}
