/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.Country;
import com.itcube.hibernate.db.Student;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class StudentService implements StudentInterface {

    private HibernateTemplate hibernateTemplate;
    private Session session = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//    DataSource dataSource;
//    Connection con = null;
//    PreparedStatement pstmt = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//
//    public StudentService() {
////        try {
////            dataSource = ConnectDB.getSchooldb();
////        } catch (Exception e) {
////            System.out.println(e);
////        }
//    }
    @Override
    public void add(Student student) {
        hibernateTemplate.saveOrUpdate(student);
//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            String query1 = "select count(*) from student";
//            rs = stmt.executeQuery(query1);
//            Integer studCode = 0;
//            if (rs.next()) {
//                studCode = Integer.parseInt(rs.getString(1));
//                studCode = studCode + 1;
//            }
//
//
//
//            String query = "insert into `school`.`student`"
//                    + "(studentCode, "
//                    + "studentFname, "
//                    + "studentMname, "
//                    + "studentLname,"
//                    + "studentName, "
//                    + "studentGender, "
//                    + "studentDOB, "
//                    + "studentPresentAdd,"
//                    + "studentPermanetAdd, "
//                    + "studentCountry, "
//                    + "studentState,"
//                    + "studentDistrict, "
//                    + "studentTaluka, "
//                    + "studentVillage,"
//                    + "studentPin, "
//                    + "teahcerMobile, "
//                    + "studentPhone, "
//                    + "studentEmail"
//                    + ")"
//                    + "values"
//                    + "(?, "
//                    + "?, "
//                    + "?, "
//                    + "?,"
//                    + "?, "
//                    + "?, "
//                    + "?, "
//                    + "?,"
//                    + "?, "
//                    + "?, "
//                    + "?,"
//                    + "?, "
//                    + "?, "
//                    + "?,"
//                    + "?,"
//                    + "?, "
//                    + "?, "
//                    + "?"
//                    + ")";
//
//
//            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, studCode.toString());
//            pstmt.setString(2, student.getFname());
//            pstmt.setString(3, student.getMname());
//            pstmt.setString(4, student.getLname());
//            pstmt.setString(5, student.getFname() + " " + student.getMname() + " " + student.getLname());
//            pstmt.setString(6, student.getGender());
//            pstmt.setString(7, student.getDateOfBirth());
//            pstmt.setString(8, student.getPresentAddress());
//            pstmt.setString(9, student.getPermanentAddress());
//            pstmt.setString(10, student.getCountry());
//            pstmt.setString(11, student.getState());
//            pstmt.setString(12, student.getDistrict());
//            pstmt.setString(13, student.getTaluka());
//            pstmt.setString(14, "01152506029");
//            pstmt.setString(15, student.getPincode());
//            pstmt.setString(16, student.getMobile());
//            pstmt.setString(17, student.getLandline());
//            pstmt.setString(18, student.getEmail());
//
//            int i = pstmt.executeUpdate();
//            System.out.println("XXXXXXXXX:" + i);
//            if (i == 1) {
//                result = "PASS";
//            }
//
//            return result;
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
//            return result;
//        } catch (Exception e) {
//            System.out.println(e);
//            return result;
//        } finally {
//            try {
//                rs.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        //return result;
    }

    @Override
    public String update(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String delet(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Student> searchStudentList(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student search(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Country> getAllCountries() {
        return hibernateTemplate.find("from Country");
//        List<Country> list = new ArrayList<Country>();        
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
//            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getStudentName(String rollNumber) {
        String result = "";
        String query = "select studentName "
                + "from student as A,stud_roll_num as B "
                + "where A.studentCode = B.studentCode "
                + "and B.rollNumber = '" + rollNumber + "'";

//        try {
//            con = dataSource.getConnection();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                result = rs.getString(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return result;
    }

    @Override
    public int getMaxStudentCode() {
        int studentCode= Integer.parseInt("1");
        try {
            session = hibernateTemplate.getSessionFactory().openSession();                        
            Criteria c = session.createCriteria(com.itcube.hibernate.db.Student.class);                        
            c.setProjection(Projections.max("studID"));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
            studentCode = (Integer) it.next();
                System.out.println("studentCode :" + studentCode);                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return studentCode;
    }
}
