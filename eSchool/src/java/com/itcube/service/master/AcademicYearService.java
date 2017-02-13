/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.AcademicYear;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class AcademicYearService implements AcademicYearInterface {

    private HibernateTemplate hibernateTemplate;
    private Session session = null;
    private Session session1 = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public int getCurrentAcademicYearID() {
        int academicYearID = Integer.parseInt("1");
        //        hibernateTemplate.find("from acc_year");
        try {
            session1 = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session1.createCriteria(com.itcube.hibernate.db.AcademicYear.class);
            c.setProjection(Projections.max("academicYearID"));
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                academicYearID = (Integer) it.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session1.flush();
            session1.close();
        }
        return academicYearID;
    }

    @Override
    public AcademicYear getAcademicYear() {
        AcademicYear academicYear = new AcademicYear();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.AcademicYear.class);
            c.add(Expression.eq("academicYearID", getCurrentAcademicYearID()));
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                academicYear = (AcademicYear) it.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return academicYear;
    }
}