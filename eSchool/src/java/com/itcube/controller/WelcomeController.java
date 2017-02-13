/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/index")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {        
        request.getSession().removeAttribute("userid");
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello world");
        return model;
    }
}
