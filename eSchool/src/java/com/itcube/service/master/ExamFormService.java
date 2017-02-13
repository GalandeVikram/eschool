/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.pojo.master.ExamForm;
import com.itcube.service.db.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author vikram.galande
 */
public class ExamFormService implements ExamFormInterface {

    DataSource dataSource;
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ExamFormService() {
        try {
            dataSource = ConnectDB.getSchooldb();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String add(ExamForm examForm) {
        //System.out.println("vk :" + examForm.getSubject());
        String result = "Exam Form not submited";
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            String query1 = "select max(seatNumber) from stud_exam where rollNumber like '"+examForm.getStandard()+"%'";
            
            System.out.println("query1 : " + query1);
            rs = stmt.executeQuery(query1);
            Integer seat_number = 0;
            String seatNumber = "";
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    seat_number = Integer.parseInt(rs.getString(1));
                    seat_number = seat_number + 1;
                    if (seat_number.toString().length() == 1) {
                        seatNumber = "000" + seat_number.toString();
                    } else if (seat_number.toString().length() == 2) {
                        seatNumber = "00" + seat_number.toString();
                    } else if (seat_number.toString().length() == 3) {
                        seatNumber = "0" + seat_number.toString();
                    } else if (seat_number.toString().length() == 4) {
                        seatNumber = seat_number.toString();
                    }
                } else {
                    seatNumber = "0001";
                }
            }

            String[] subjectArr = examForm.getSubject().split(",");
            for (int i = 0; i < subjectArr.length; i++) {
                String query = "insert into stud_exam "
                        + "(rollNumber, examd_code, studexam_marks_obtained, result, seatNumber) "
                        + "values "
                        + "(?, ?, ?, ?, ?)";

                pstmt = con.prepareStatement(query);
                pstmt.setString(1, examForm.getStudent());
                pstmt.setString(2, subjectArr[i]);
                pstmt.setInt(3, 0);
                pstmt.setString(4, "");
                pstmt.setString(5, seatNumber);
                
                int k = pstmt.executeUpdate();
                System.out.println("record inseted "+k);
            }
            
            return "Exam Form submited";
        } catch (SQLException ex) {
            Logger.getLogger(ExamForm.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return result;
        } finally {
            try {
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ExamForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
