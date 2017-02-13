/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.login;

import com.itcube.pojo.Login;
import com.itcube.service.LoginInterface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/login.htm")
//@SessionAttributes("login")
public class LoginController {

    private LoginInterface loginInterface;

    @Autowired
    public void setLoginInterface(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String showUserForm(ModelMap model) {
//        Login login = new Login();
//        model.addAttribute("login", login);
//        return "loginForm";
//    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("login") Login login, HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = null;
        if(loginInterface.validateLogin(login)){
            httpSession = request.getSession();
            httpSession.setAttribute("userid", login.getUsername());
            return "home";
        }else{
            return "index";
        }
        
    }
}
