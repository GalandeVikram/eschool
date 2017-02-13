/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.service;

import com.itcube.hibernate.model.UserAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class UserAuthService implements UserAuthInterface {

    private HibernateTemplate hibernateTemplate;
    Session session=null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<UserAuth> listUserAuth() {
        session = hibernateTemplate.getSessionFactory().openSession();
        UserAuth userAuth;
        List<UserAuth> userAuthList = new ArrayList();
        Criteria c = session.createCriteria(com.itcube.hibernate.model.UserAuth.class);
        List list = c.list();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            userAuth = (UserAuth) iterator.next();
            userAuthList.add(userAuth);
        }
        //return hibernateTemplate.find("from User");
        return userAuthList;
    }
}
