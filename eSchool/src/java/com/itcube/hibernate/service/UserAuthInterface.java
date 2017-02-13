/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.service;

import com.itcube.hibernate.model.UserAuth;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface UserAuthInterface {
    public List<UserAuth> listUserAuth();
}
