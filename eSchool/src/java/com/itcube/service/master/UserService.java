/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.model.UserAuth;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class UserService implements UserInterface {

    private HibernateTemplate hibernateTemplate;
    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//    @Override
//    public void saveUser(User1 user) {
//        hibernateTemplate.saveOrUpdate(user);
//    }
//
//    @Override
//    public List<User1> listUser() {
//        return hibernateTemplate.find("from User");
//    }
//
//    @Override
//    public List<UserAuth> listUserAuth() {
//        return hibernateTemplate.find("from UserAuth");
//    }

    @Override
    public List<UserAuth> listUserAuth() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
