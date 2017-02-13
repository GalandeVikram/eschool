/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.pojo.master.Result;
import com.itcube.pojo.master.ResultDetails;
import com.itcube.service.db.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author vikram.galande
 */
public class ResultService implements ResultInterface {

    DataSource dataSource;
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ResultService() {
        try {
            dataSource = ConnectDB.getSchooldb();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Result> getResult(String standard) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Result getResult(String standard, String seatNumber) {
        Result result = new Result();
        List<ResultDetails> list = new ArrayList<ResultDetails>();
        String query1 = "select A.rollNumber,A.examd_code,B.examd_name,A.studexam_marks_obtained,A.result "
                + "from stud_exam as A, exam_details as B "
                + "where A.examd_code = B.examd_code "
                + "and A.seatNumber = '" + seatNumber + "' "
                + "and A.rollNumber like '" + standard + "%'";
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            System.out.println("query1 : " + query1);
            rs = stmt.executeQuery(query1);
            String rollNumber = "";
            while (rs.next()) {
                rollNumber = rs.getString(1);
                ResultDetails details = new ResultDetails();
                details.setExamCode(rs.getString(2));
                details.setExamName(rs.getString(3));
                details.setMarks(rs.getString(4));
                details.setResult(rs.getString(5));
                list.add(details);
            }
            result.setRollNumber(rollNumber);
            result.setResultDetails(list);
            result.setSeatNumber(seatNumber);
            result.setTotoalMarks(calculateTotal(list));
        } catch (SQLException sqle) {
            System.out.println("Result Service : " + sqle);
        }
        return result;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    private String calculateTotal(List<ResultDetails> list) {
        Integer i = 0;
        for (ResultDetails rd : list) {
            i = i + Integer.parseInt(rd.getMarks());
        }
        return i.toString();
    }
}
