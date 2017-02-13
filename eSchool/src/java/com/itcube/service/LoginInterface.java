/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service;

import com.itcube.hibernate.db.User;
import com.itcube.pojo.Login;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface LoginInterface {
    public List<User> listUser() ;        
    public boolean validateLogin(Login login);
}
