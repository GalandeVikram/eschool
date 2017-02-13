/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.AcademicYear;
import com.itcube.hibernate.db.ClassRoom;
import com.itcube.hibernate.db.Standard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class StandardService implements StandardInterface {

    private HibernateTemplate hibernateTemplate;
    private Session session = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<Standard> getCurrentYearStandard(int academicYearID) {
        List<Standard> list = new ArrayList<Standard>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ClassRoom.class);
            AcademicYear academicYear = new AcademicYear();
            academicYear.setAcademicYearID(academicYearID);
            
            c.createCriteria("roomID", "room");
            c.add(Restrictions.eqProperty("room.roomID", "roomID"));
            c.createCriteria("divisionID", "div");
            c.add(Restrictions.eqProperty("div.divisionID", "divisionID"));
            c.createCriteria("academicYearID", "accy");
            c.add(Restrictions.eqProperty("accy.academicYearID", "academicYearID"));
            
            c.add(Expression.eq("accy.academicYearID", academicYearID));
            
            //c.add(Expression.eq("academicYearID", academicYearID));

            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                Standard standard = new Standard();
                ClassRoom classRoom = (ClassRoom) it.next();
                standard = classRoom.getStdID();
                list.add(standard);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }
}
