/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.ExamTransaction;
import com.itcube.pojo.master.SetExam;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class SetExamService implements SetExamInterface {

    private HibernateTemplate hibernateTemplate;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public String add(SetExam setExam) {
        ExamTransaction examTransaction = new ExamTransaction();
        String msg = "";
        try {
            hibernateTemplate.save(examTransaction);
            msg = "success";
        } catch (Exception e) {
            
        } finally {
            
        }
        return msg;
//        String result = "Exam not set for Subject :";
//        try {
//            con = dataSource.getConnection();
//            stmt1 = con.createStatement();
//            stmt2 = con.createStatement();
//
////            System.out.println("accy :" + setExam.getAcademicYear());
//            String query1 = "select std_subj_teach_code "
//                    + "from std_subj_teach "
//                    + "where stdd_code = '" + setExam.getStandard() + "' "
//                    + "and subjd_code = '" + setExam.getSubject() + "'";
//            System.out.println("query1 :" + query1);
//            rs = stmt1.executeQuery(query1);
//            String std_sub_teach_code = "";
//            if (rs.next()) {
//                std_sub_teach_code = rs.getString(1);
//            }
//            if (!std_sub_teach_code.equals("")) {
//                String query2 = "select max(examd_code) from exam_details "
//                        + "where std_subj_teach_code = '" + std_sub_teach_code + "'";
//                System.out.println("query2 : " + query2);
//                rs = stmt2.executeQuery(query2);
//                Integer examd_code = 0;
//                String examdCodeNumber = "";
//                if (rs.next()) {
//                    if (rs.getString(1) != null) {
//                        examd_code = Integer.parseInt(rs.getString(1));
//                        examd_code = examd_code + 1;
//                        examdCodeNumber = "0" + examd_code.toString();
//                    } else {
//                        examdCodeNumber = std_sub_teach_code + setExam.getExamMaster() + "01";
//                    }
//                }
//
//
//
//                String query = "insert into exam_details "
//                        + "(examd_code, "
//                        + "examd_name, "
//                        + "examd_date, "
//                        + "examd_marks, "
//                        + "examm_code, "
//                        + "std_subj_teach_code, "
//                        + "examd_start_time, "
//                        + "examd_end_time) "
//                        + "values "
//                        + ""
//                        + "(?, ?, ?, ?, ?, ?, ?, ?)";
//
//
//                pstmt = con.prepareStatement(query);
//                pstmt.setString(1, examdCodeNumber);
//                pstmt.setString(2, setExam.getExamName());
//                pstmt.setString(3, setExam.getExamDate());
//                pstmt.setString(4, setExam.getExamMarks());
//                pstmt.setString(5, setExam.getExamMaster());
//                pstmt.setString(6, std_sub_teach_code);
//                pstmt.setString(7, setExam.getExamStartTime());
//                pstmt.setString(8, setExam.getExamEndTime());
//
//
//                int i = pstmt.executeUpdate();
//                System.out.println("XXXXXXXXX:" + i);
//                if (i == 1) {
//                    result = "Exam code created for subject :" + setExam.getExamName() + " with Exam Code :" + examdCodeNumber;
//                }
//            } else {
//                result = "Exam code already created for subject :" + setExam.getExamName();
//            }
//            return result;
//        } catch (SQLException ex) {
//            Logger.getLogger(SetExamService.class.getName()).log(Level.SEVERE, null, ex);
//            return result;
//        } catch (Exception e) {
//            System.out.println(e);
//            return result;
//        } finally {
//            try {
//                rs.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(SetExamService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
}
