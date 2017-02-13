/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.result.deligates;

import com.itcube.bo.configuration.pojo.SubjectPOJO;
import com.itcube.bo.exam.pojo.ExamFormPOJO;
import com.itcube.bo.interfaces.ResultInterface;
import com.itcube.bo.result.pojo.ResultPOJO;
import com.itcube.hibernate.db.Admission;
import com.itcube.hibernate.db.ClassRoom;
import com.itcube.hibernate.db.Division;
import com.itcube.hibernate.db.ExamDetail;
import com.itcube.hibernate.db.ExamForm;
import com.itcube.hibernate.db.ExamResult;
import com.itcube.hibernate.db.ExamTransaction;
import com.itcube.hibernate.db.Standard;
import com.itcube.hibernate.db.Student;
import com.itcube.hibernate.db.SubjectDetail;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ResultDeligates implements ResultInterface {

    private HibernateTemplate hibernateTemplate;
    private Session session = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public ResultPOJO getResult(int seatNumber) {
        ResultPOJO resultPOJO = new ResultPOJO();
        double totalMarksObtained = 0;
        double totalMarks = 0;
        String resultFlag = "PASS";
        List<SubjectPOJO> subjectList = new ArrayList<SubjectPOJO>();
        //1.
        resultPOJO.setSeatNumber(String.valueOf(seatNumber));
        //2. get subject code list        
        subjectList = getResultSubjectList(seatNumber);
        resultPOJO.setSubjectList(subjectList);
        for (SubjectPOJO subjectPOJO : subjectList) {
            double marks = Double.parseDouble(subjectPOJO.getMarksObtained());
            double tmarks = Double.parseDouble(subjectPOJO.getSubjectMaxMarks());
            totalMarksObtained = totalMarksObtained + marks;
            totalMarks = totalMarks + tmarks;
            if ("Fail".equals(subjectPOJO.getSubjectResultFlag())) {
                resultFlag = "FAIL";
            }
        }


        double per = (totalMarksObtained / totalMarks) * 100.00;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        resultPOJO.setTotalMarksObtained(String.valueOf(totalMarksObtained));
        resultPOJO.setPercentage(nf.format(Double.parseDouble(String.valueOf(per))));
        ExamFormPOJO examPOJO = getExamFormDetails(seatNumber);
        resultPOJO.setExamName(examPOJO.getExamName());
        resultPOJO.setRollNumber(examPOJO.getRollNumber());
        resultPOJO.setStandardName(examPOJO.getStandardName());
        resultPOJO.setDivision(examPOJO.getDivision());
        resultPOJO.setStudentName(examPOJO.getStudentName());
        resultPOJO.setResult(resultFlag);
        resultPOJO.setResultDate(new SimpleDateFormat("dd-mmm-yyyy").format(new Date()));
        return resultPOJO;
    }

    public List<SubjectPOJO> getResultSubjectList(int seatNumber) {
        List<SubjectPOJO> subjectList = new ArrayList<SubjectPOJO>();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ExamResult.class);

            c.createCriteria("examTxnID", "examTXN");
            c.add(Restrictions.eqProperty("examTXN.examTxnID", "examTxnID"));
            
            c.createCriteria("seatNumber", "examForm");
            c.add(Restrictions.eqProperty("examForm.seatNumber", "seatNumber"));

            c.add(Expression.eq("examForm.seatNumber", seatNumber));

            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                SubjectPOJO pojo = new SubjectPOJO();
                ExamTransaction exmTXN = new ExamTransaction();
                SubjectDetail subjectDetail = new SubjectDetail();

                ExamResult examResult = (ExamResult) it.next();
                exmTXN = examResult.getExamTxnID();

                exmTXN.getExamTxnMinMarks();
                subjectDetail = exmTXN.getSubjectDetailID();
                pojo.setMarksObtained(String.valueOf(examResult.getMarksObtained()));
                pojo.setSubjectID(String.valueOf(subjectDetail.getSubjectDetailID()));
                pojo.setSubjectName(subjectDetail.getSubjectDetailName());
                pojo.setSubjectMaxMarks(String.valueOf(exmTXN.getExamTxnMaxMarks()));
                pojo.setSubjectMinMarks(String.valueOf(exmTXN.getExamTxnMinMarks()));
                pojo.setExamTXNID(String.valueOf(exmTXN.getExamTxnID()));
                int requiredMarks = exmTXN.getExamTxnMinMarks();
                int obtainedMarks = examResult.getMarksObtained();
                if (obtainedMarks < requiredMarks) {
                    pojo.setSubjectResultFlag("Fail");
                } else {
                    pojo.setSubjectResultFlag("Pass");
                }
                subjectList.add(pojo);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return subjectList;
    }

    public ExamFormPOJO getExamFormDetails(int seatNumber) {
        ExamFormPOJO pojo = new ExamFormPOJO();
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ExamForm.class);

//            c.createCriteria("examDetailID", "exam");
//            c.add(Restrictions.eqProperty("exam.examDetailID", "examDetailID"));
//            
//            c.createCriteria("rollNumber", "roll");
//            c.add(Restrictions.eqProperty("roll.rollNumber", "rollNumber"));

            c.add(Expression.eq("seatNumber", seatNumber));
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ExamForm examForm = (ExamForm) it.next();
                ExamDetail examDetail = examForm.getExamDetailID();
                Admission admission = examForm.getRollNumber();
                Student student = admission.getStudID();
                ClassRoom classRoom = admission.getClassRoomID();
                Division division = classRoom.getDivisionID();
                Standard standard = classRoom.getStdID();
                pojo.setRollNumber(String.valueOf(admission.getRollNumber()));
                pojo.setStudentName(student.getStudName());
                pojo.setStandardName(standard.getStdName());
                pojo.setDivision(division.getDivisionName());
                pojo.setExamName(examDetail.getExamDetailName());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return pojo;
    }

    @Override
    public void updateResult(ResultPOJO pojo) {
        ExamResult examResult = new ExamResult();
        ExamForm examForm = new ExamForm();
        examForm.setSeatNumber(Integer.parseInt(pojo.getSeatNumber()));
        List<SubjectPOJO> subjectList = pojo.getSubjectList();
        for (SubjectPOJO subjectPOJO : subjectList) {
            examResult = getExamResult(examForm.getSeatNumber(), Integer.parseInt(subjectPOJO.getExamTXNID()));            
            examResult.setMarksObtained(Integer.parseInt(subjectPOJO.getMarksObtained()));            
            hibernateTemplate.update(examResult);
        }
    }

    public ExamResult getExamResult(int seatNumber, int exmTXNID) {
        ExamResult examResult = new ExamResult();
        
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ExamResult.class);

            c.createCriteria("examTxnID", "examTXN");
            c.add(Restrictions.eqProperty("examTXN.examTxnID", "examTxnID"));
            
            c.createCriteria("seatNumber", "seatNo");
            c.add(Restrictions.eqProperty("seatNo.seatNumber", "seatNumber"));

            c.add(Expression.eq("examTXN.examTxnID", exmTXNID));
            c.add(Expression.eq("seatNo.seatNumber", seatNumber));
            
            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                examResult = (ExamResult) it.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        
        return examResult;
    }
}
