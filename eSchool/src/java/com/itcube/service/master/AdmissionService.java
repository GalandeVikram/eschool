/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.ClassRoom;
import com.itcube.hibernate.db.Student;
import com.itcube.pojo.master.Admission;
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
public class AdmissionService implements AdmissionInterface {

    private HibernateTemplate hibernateTemplate;
    //private Session session = null;
    private Session sessionRoll = null;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void add(Admission admission) {
        String year = admission.getAcademicYear();
        String std = admission.getStandard();
        String studId = admission.getStudentId();
        if(Integer.parseInt(std) < 10){
            std = "0"+std;
        }
        long claaRoomID = Long.parseLong(year+std+"1");
        com.itcube.hibernate.db.Admission admissionEntity = new com.itcube.hibernate.db.Admission();
        ClassRoom classRoom = new ClassRoom();
        Student student = new Student();
        student.setStudID(Integer.parseInt(studId));
        classRoom.setClassRoomID(claaRoomID);
        admissionEntity.setClassRoomID(classRoom);
        admissionEntity.setStudID(student);
        int rollNumber=0;
        if(getRollNumber(classRoom) == 1){
            rollNumber = Integer.parseInt(year+std+"1"+"001");
        }else{
         rollNumber = getRollNumber(classRoom);   
        }
        admissionEntity.setRollNumber(rollNumber);
        
        hibernateTemplate.save(admissionEntity);
    }
    
    public int getRollNumber(ClassRoom classRoom){
        int rollNumber= 0;
        try {
            sessionRoll = hibernateTemplate.getSessionFactory().openSession();                        
            Criteria c = sessionRoll.createCriteria(com.itcube.hibernate.db.Admission.class);                        
            c.setProjection(Projections.max("rollNumber"));
            c.add(Expression.eq("classRoomID", classRoom));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
            rollNumber = (Integer) it.next();                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            sessionRoll.flush();
            sessionRoll.close();
        }
        return rollNumber+1;
    }
}
