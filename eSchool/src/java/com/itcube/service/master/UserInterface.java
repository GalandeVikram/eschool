/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.model.UserAuth;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface UserInterface {
    //public List<User1> listUser();
    //public void saveUser(User1 user) ;
    public List<UserAuth> listUserAuth();
}
