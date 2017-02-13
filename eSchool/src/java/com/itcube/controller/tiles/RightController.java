/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/dashboard")
public class RightController {
@RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView("dashboard");
        //model.addObject("msg", "hello world");
        return model;
    }    
}
