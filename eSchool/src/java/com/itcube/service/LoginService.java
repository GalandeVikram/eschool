/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service;

import com.itcube.hibernate.db.User;
import com.itcube.pojo.Login;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class LoginService implements LoginInterface {

//    DataSource dataSource;
//    Connection con = null;
//    Statement stmt = null;
//    ResultSet rs = null;
    
    private HibernateTemplate hibernateTemplate;
    //private Session session;
    
//    public LoginService() {
//        session = hibernateTemplate.getSessionFactory().openSession();
//    }
//    public LoginService() {
//        try {
//            dataSource = ConnectDB.getSchooldb();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//    @Override
//    public void add(Login login) {
//        User1 user = new User1();
//        user.setU_code("03");
//        user.setU_name(login.getUsername());
//        user.setU_password(login.getPassword());
//        user.setUa_code("01");
//        saveUser(user);
//        System.out.println("add here");
//    }

    @Override
    public boolean validateLogin(Login login) {
        boolean flag = false;
        for (User u : listUser()) {
            if (u.getUserName().equals(login.getUsername())
                    && u.getUserPass().equals(login.getPassword())) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<User> listUser() {
        return hibernateTemplate.find("from User");
    }

//    public void saveUser(User1 user) throws DataAccessException {
//        try {
//            hibernateTemplate.save(user);
//        } catch (DataAccessException exception) {
//            System.out.println(exception);
//        }
//
//    }

//    public int getMaxUserCode() {
//        session = hibernateTemplate.getSessionFactory().openSession();
//        String maxUserCode = "";
//        Query query = session.createQuery("select max(u.u_code) from User1 u");
//        List l = query.list();
//        Iterator itr = l.iterator();
//        while (itr.hasNext()) {
//            Object max = (Object) itr.next();
//            maxUserCode = max.toString();
//        }        
//        Integer i = Integer.parseInt(maxUserCode);
//        i = i + 1;        
//        System.out.println("maxUserCode :" + i);
//        return i;
//    }
}
