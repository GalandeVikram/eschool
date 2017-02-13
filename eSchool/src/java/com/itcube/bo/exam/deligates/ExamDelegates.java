/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.exam.deligates;

import com.itcube.bo.configuration.pojo.ClassRoomPOJO;
import com.itcube.bo.exam.builder.ExamBuilder;
import com.itcube.bo.exam.pojo.ExamPOJO;
import com.itcube.bo.interfaces.ExamInterface;
import com.itcube.hibernate.db.AcademicYear;
import com.itcube.hibernate.db.Admission;
import com.itcube.hibernate.db.ClassRoom;
import com.itcube.hibernate.db.Division;
import com.itcube.hibernate.db.ExamDetail;
import com.itcube.hibernate.db.ExamForm;
import com.itcube.hibernate.db.ExamResult;
import com.itcube.hibernate.db.ExamTransaction;
import com.itcube.hibernate.db.Standard;
import com.itcube.hibernate.db.SubjectDetail;
import com.itcube.hibernate.dto.ClassRoomDTO;
import com.itcube.hibernate.dto.ExamDTO;
import com.itcube.pojo.master.SetExam;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author vikram.galande
 */
public class ExamDelegates implements ExamInterface {

    private HibernateTemplate hibernateTemplate;
    private Session session = null;
    private Session session1 = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//    @Override
//    public String createAdmission(AdmissionPOJO pojo) {
//        return "TEST";
//    }
    @Override
    public List<ClassRoomPOJO> getClassRoomList(int currentYear) {
        List<ClassRoomDTO> list = new ArrayList<ClassRoomDTO>();
        List<ClassRoomPOJO> classRoomList = null;
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ClassRoom.class);
            AcademicYear academicYear = new AcademicYear();
            academicYear.setAcademicYearID(currentYear);

            c.createCriteria("roomID", "room");
            c.add(Restrictions.eqProperty("room.roomID", "roomID"));
            c.createCriteria("divisionID", "div");
            c.add(Restrictions.eqProperty("div.divisionID", "divisionID"));
            c.createCriteria("academicYearID", "accy");
            c.add(Restrictions.eqProperty("accy.academicYearID", "academicYearID"));
            c.add(Expression.eq("accy.academicYearID", currentYear));

            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ClassRoomDTO dTO = new ClassRoomDTO();
                Standard standard = new Standard();
                Division division = new Division();
                ClassRoom classRoom = (ClassRoom) it.next();
                standard = classRoom.getStdID();
                division = classRoom.getDivisionID();
                dTO.setClassRoomID(classRoom.getClassRoomID());
                dTO.setClassRoomName(standard.getStdName() + "- " + division.getDivisionName());
                list.add(dTO);
                dTO = null;
                standard = null;
                division = null;
                classRoom = null;
            }
            classRoomList = ExamBuilder.convertClassRoomDtoToPojo(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return classRoomList;
    }

    @Override
    public void addExam(SetExam setExam) {

        String classRoomID = setExam.getClassRoomCode();
        String examID = setExam.getExamCode();
        String examDate = setExam.getExamDate();
        String examEndTime = setExam.getExamEndTime();
        String examStartTime = setExam.getExamStartTime();
        String subjectID = setExam.getSubjectCode();
        String examMaxMarks = setExam.getExamMaxMarks();
        String examMinMarks = setExam.getExamMinMarks();


        ExamTransaction examTransaction = new ExamTransaction();
        ClassRoom classRoom = new ClassRoom();
        ExamDetail examDetail = new ExamDetail();
        SubjectDetail subjectDetail = new SubjectDetail();


        classRoom.setClassRoomID(Long.parseLong(classRoomID));
        examDetail.setExamDetailID(Integer.parseInt(examID));
        subjectDetail.setSubjectDetailID(Integer.parseInt(subjectID));

        String[] examDateArr = examDate.split("-");
        int dd = Integer.parseInt(examDateArr[0]);
        int mm = Integer.parseInt(examDateArr[1]);
        int yy = Integer.parseInt(examDateArr[2]);

        try {
            examTransaction.setExamTxnID(getMaxExamTXNCode());
            examTransaction.setClassRoomID(classRoom);
            examTransaction.setExamDetailID(examDetail);
            examTransaction.setSubjectDetailID(subjectDetail);

            examTransaction.setExamTxnDate(new Date(yy - 1900, mm, dd));

            String[] examStartTimeArr = examStartTime.split(":");
            int hh = Integer.parseInt(examStartTimeArr[0]);
            int min = Integer.parseInt(examStartTimeArr[1]);
            int sec = Integer.parseInt(examStartTimeArr[2]);
            Time startTime = new Time(hh, min, sec);
            examTransaction.setExamTxnStartTime(startTime);

            String[] examEntTimeArr = examEndTime.split(":");
            hh = Integer.parseInt(examEntTimeArr[0]);
            min = Integer.parseInt(examEntTimeArr[1]);
            sec = Integer.parseInt(examEntTimeArr[2]);
            Time endTime = new Time(hh, min, sec);
            examTransaction.setExamTxnEndTime(endTime);

            examTransaction.setExamTxnMaxMarks(Integer.parseInt(examMaxMarks));
            examTransaction.setExamTxnMinMarks(Integer.parseInt(examMinMarks));
            hibernateTemplate.save(examTransaction);
        } catch (Exception e) {
        } finally {
            classRoom = null;
            examDetail = null;
            subjectDetail = null;
            examTransaction = null;
        }



    }

    public int getMaxExamTXNCode() {
        int code = Integer.parseInt("0");
        try {
            session1 = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session1.createCriteria(com.itcube.hibernate.db.ExamTransaction.class);
            c.setProjection(Projections.max("examTxnID"));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                code = (Integer) it.next();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session1.flush();
            session1.close();
        }
        return code + 1;
    }

    @Override
    public List<ExamPOJO> getExamList(int currentYear) {
        List<ExamDTO> list = new ArrayList<ExamDTO>();
        List<ExamPOJO> examList = null;
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ExamDetail.class);

            c.createCriteria("examID", "exam");
            c.add(Restrictions.eqProperty("exam.examID", "examID"));

            c.createCriteria("academicYearID", "accy");
            c.add(Restrictions.eqProperty("accy.academicYearID", "academicYearID"));

            c.add(Expression.eq("accy.academicYearID", currentYear));

            List l = c.list();
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ExamDTO dTO = new ExamDTO();
                ExamDetail examDetail = (ExamDetail) it.next();
                dTO.setExamDetailID(examDetail.getExamDetailID());
                dTO.setExamDetailName(examDetail.getExamDetailName());
                list.add(dTO);
                dTO = null;
            }
            examList = ExamBuilder.convertExamDetailDtoToPojo(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return examList;
    }

    @Override
    public void addExamForm(SetExam setExam) {
        ExamForm examForm = new ExamForm();
        ExamResult examResult = new ExamResult();
        int rollNumber = 0;        
        int classRoomID = Integer.parseInt(setExam.getClassRoomCode());
        int examID = Integer.parseInt(setExam.getExamCode());
        ExamDetail examDetail = new ExamDetail();
        examDetail.setExamDetailID(examID);
        List<Admission> rollNumberList = getRollNumber(classRoomID);
        for (Admission admission : rollNumberList) {
            rollNumber = admission.getRollNumber();
            examForm.setSeatNumber(generateSeatNo(rollNumber, examID));
            examForm.setExamDetailID(examDetail);
            examForm.setRollNumber(admission);
            hibernateTemplate.save(examForm);

            List<ExamTransaction> etsList = getExamTransactions(examDetail.getExamDetailID(), rollNumber);
            for (ExamTransaction et : etsList) {
                examResult.setSeatNumber(examForm);
                examResult.setExamTxnID(et);
                hibernateTemplate.save(examResult);
            }
        }
    }

    public List<Admission> getRollNumber(int classRoomID) {
        List<Admission> list = new ArrayList<Admission>();
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassRoomID(Long.parseLong(String.valueOf(classRoomID)));
        try {
            session1 = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session1.createCriteria(com.itcube.hibernate.db.Admission.class);
            c.add(Expression.eq("classRoomID", classRoom));
            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                Admission admission = (Admission) it.next();
                list.add(admission);
            }

        } catch (Exception e) {
            System.out.println("getRollNumber(int classRoomID):" + e);
        } finally {
            session1.flush();
            session1.close();
        }
        return list;
    }

    public int generateSeatNo(int rollNumber, int examId) {
        String strRollNum = String.valueOf(rollNumber);
        String strExamID = String.valueOf(examId).substring(2, 4);
        int seatNumber = Integer.parseInt(strExamID + strRollNum);
        return seatNumber;
    }

    public List<ExamTransaction> getExamTransactions(int examID, int rollNumber) {
        List<ExamTransaction> txnList = new ArrayList<ExamTransaction>();
        String strRollNumber = String.valueOf(rollNumber).substring(0, 4);
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassRoomID(Long.parseLong(strRollNumber));
        ExamDetail examDetail = new ExamDetail();
        examDetail.setExamDetailID(examID);
        try {
            session = hibernateTemplate.getSessionFactory().openSession();
            Criteria c = session.createCriteria(com.itcube.hibernate.db.ExamTransaction.class);

            c.createCriteria("classRoomID", "room");
            c.add(Restrictions.eqProperty("room.classRoomID", "classRoomID"));
            
            c.createCriteria("examDetailID", "exam");
            c.add(Restrictions.eqProperty("exam.examDetailID", "examDetailID"));
            
            c.createCriteria("subjectDetailID", "subject");
            c.add(Restrictions.eqProperty("subject.subjectDetailID", "subjectDetailID"));
            
            c.add(Expression.eq("examDetailID", examDetail));
            c.add(Expression.eq("classRoomID", classRoom));

            //c.add(Expression.eq("academicYearID", academicYearID));

            List l = c.list();
            System.out.println(l.size());
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ExamTransaction examTxn = (ExamTransaction) it.next();
                txnList.add(examTxn);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.flush();
            session.close();
        }
        return txnList;
    }
}
