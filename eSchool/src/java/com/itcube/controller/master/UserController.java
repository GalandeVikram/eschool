/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.controller.master;

//import com.itcube.dto.User1;
import com.itcube.service.master.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/user.htm")
@SessionAttributes("user")
public class UserController {
    
    private UserInterface userInterface;
    
    @Autowired
    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
//        User1 user = new User1();
        model.addAttribute("userAuthList",userInterface.listUserAuth());
      //  model.addAttribute("userList", userInterface.listUser());
      //  model.addAttribute("user", user);
        return "master/userForm";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String onSubmit(@ModelAttribute("user") User1 user) {          
//        userInterface.saveUser(user);        
//        return "redirect:user.htm";
//    }
}
