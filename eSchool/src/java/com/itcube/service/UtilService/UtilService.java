/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.UtilService;

import com.itcube.bo.configuration.pojo.SubjectPOJO;
import com.itcube.hibernate.db.ClassRoom;
import com.itcube.hibernate.db.Country;
import com.itcube.hibernate.db.District;
import com.itcube.hibernate.db.State;
import com.itcube.hibernate.db.Student;
import com.itcube.hibernate.db.SubjectDetail;
import com.itcube.hibernate.db.Taluka;
import com.itcube.hibernate.model.Country1;

import com.itcube.pojo.master.Exam;


import com.itcube.pojo.master.Subject;
import com.itcube.pojo.master.Village;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class UtilService implements UtilInterface {

    private HibernateTemplate hibernateTemplate;
    Session session;
    Session subjectSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
//    DataSource dataSource;
//    Connection con = null;
//    PreparedStatement pstmt = null;
//    Statement stmt = null;
//    ResultSet rs = null;

//    public UtilService() {
//        try {
//            dataSource = ConnectDB.getSchooldb();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    @Override
    public List<Country1> getAllCountries() {
        List<Country1> list = new ArrayList<Country1>();
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select c_code,c_name from country";
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Country1 country = new Country1();
//                country.setCountryCode(rs.getString(1));
//                country.setCountryName(rs.getString(2));
//                list.add(country);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public List<State> getStateList(String countryID) {
        List<State> list = new ArrayList<State>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            State state;
            Criteria c = session.createCriteria(com.itcube.hibernate.db.State.class);
            System.out.println(countryID);
            Country country = new Country();
            country.setCountryID(Integer.parseInt(countryID));
            c.add(Expression.eq("countryID", country));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                state = (State) it.next();
                list.add(state);
            }
            country = null;
            c = null;
            l = null;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    @Override
    public List<District> getDistrictList(int stateID) {
        List<District> list = new ArrayList<District>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            District district;
            Criteria c = session.createCriteria(com.itcube.hibernate.db.District.class);
            State state = new State();
            state.setStateID(stateID);
            c.add(Expression.eq("stateID", state));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                district = (District) it.next();
                list.add(district);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    @Override
    public List<Taluka> getTalukaList(int districtID) {
        List<Taluka> list = new ArrayList<Taluka>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Taluka taluka;
            Criteria c = session.createCriteria(com.itcube.hibernate.db.Taluka.class);
            District district = new District();
            district.setDistrictID(districtID);
            c.add(Expression.eq("districtID", district));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                taluka = (Taluka) it.next();
                list.add(taluka);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select t_code,t_name from taluka where d_code='" + districtCode + "'";
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Taluka1 taluka = new Taluka1();
//                taluka.setTalukaCode(rs.getString(1));
//                taluka.setTalukaName(rs.getString(2));
//                list.add(taluka);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public List<Village> getVillageList(String talukaCode) {
        List<Village> list = new ArrayList<Village>();
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select v_code,v_name from village where t_code='" + talukaCode + "'";
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Village village = new Village();
//                village.setVillageCode(rs.getString(1));
//                village.setVillageName(rs.getString(2));
//                list.add(village);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public Student getStudentInfo(int studentCode) {
        Student student = new Student();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.Student.class);
            c.add(Expression.eq("studID", studentCode));
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                student = (Student) it.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return student;
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select * from student where studentCode='" + studentCode + "'";
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                student.setCode(studentCode);
//                student.setName(rs.getString(5));
//                student.setGender(rs.getString(6));
//                student.setDateOfBirth(rs.getString(7));
//                student.setPresentAddress(rs.getString(8));
//                student.setPermanentAddress(rs.getString(9));
//                student.setCountry(rs.getString(10));
//                student.setState(rs.getString(11));
//                student.setDistrict(rs.getString(12));
//                student.setTaluka(rs.getString(13));
//                student.setPincode(rs.getString(15));
//                student.setLandline(rs.getString(17));
//                student.setMobile(rs.getString(16));
//                student.setEmail(rs.getString(18));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        //return student;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Exam> getMasterExam() {
        List<Exam> list = new ArrayList<Exam>();
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select examm_code,examm_name from exam_master";
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Exam exam = new Exam();
//                exam.setExamCode(rs.getString(1));
//                exam.setExamName(rs.getString(2));
//                list.add(exam);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public List<Student> getStudentRollNoList(String standardCode) {
        List<Student> list = new ArrayList<Student>();
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//
//            String query1 = "select A.rollNumber,B.studentName "
//                    + "from stud_roll_num as A, student as B "
//                    + "where A.studentCode = B.studentCode "
//                    + "and A.stdd_code = '" + standardCode + "'";
//
//            System.out.println("Query1 :" + query1);
//
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Student student = new Student();
//                student.setRollNumber(rs.getString(1));
//                student.setName(rs.getString(2));
//                list.add(student);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public List<Subject> getExamDetailCode(String standardCode, String examCode) {
        List<Subject> list = new ArrayList<Subject>();
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select examd_code, examd_name "
//                    + "from exam_details "
//                    + "where std_subj_teach_code like '"+standardCode+"%' "
//                    + "and examm_code = '"+examCode+"'";
//            
//            
//            System.out.println("Query1 :" + query1);
//
//            rs = stmt.executeQuery(query1);
//            while (rs.next()) {
//                Subject subject = new Subject();
//                subject.setSubjectCode(rs.getString(1));
//                subject.setSubjectName(rs.getString(2));
//                list.add(subject);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//                rs.close();
//                stmt.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return list;
    }

    @Override
    public List<SubjectPOJO> getSubject(long classRoomID) {
        List<SubjectPOJO> subjectList = new ArrayList<SubjectPOJO>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ClassRoom.class);
            
//            c.createCriteria("classRoomID", "classRoom");
//            c.add(Restrictions.eqProperty("classRoom.classRoomID", "classRoomID"));
//            c.createCriteria("subjectDetailID", "subjDtl");
//            c.add(Restrictions.eqProperty("subjDtl.subjectDetailID", "subjectDetailID"));            
            c.add(Expression.eq("classRoomID", classRoomID));
                        
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ClassRoom classRoom = (ClassRoom) it.next();
                Set subjectSet = classRoom.getSubjectDetails();
                subjectList = getSubjectList(subjectSet);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
            
        }
        return subjectList;
    }

    public List<SubjectPOJO> getSubjectList(Set subjectSet) {
        List<SubjectPOJO> subjectList = new ArrayList<SubjectPOJO>();
        try {
            if (null != subjectSet) {
                Iterator subjIt = subjectSet.iterator();
                while (subjIt.hasNext()) {
                    SubjectDetail subjectdetil = (SubjectDetail) subjIt.next();
                    subjectdetil.getSubjectDetailID();  
                    subjectdetil.getSubjectDetailName();
                    SubjectPOJO pojo = new SubjectPOJO();                    
                    pojo.setSubjectID(String.valueOf(subjectdetil.getSubjectDetailID()));
                    pojo.setSubjectName(subjectdetil.getSubjectDetailName());
                    subjectList.add(pojo);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            subjectSet = null;
        }
        return subjectList;
    }

    @Override
    public List<Student> getStudentList(String studName) {
        List<Student> studentList = new ArrayList<Student>();
        Student student = null;
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.Student.class);            
            c.add(Expression.like("studName", studName, MatchMode.START));
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                student = (Student) it.next();
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return studentList;
    }
}
