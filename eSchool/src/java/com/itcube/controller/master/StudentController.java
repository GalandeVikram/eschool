/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itcube.controller.master;

import com.itcube.hibernate.db.Taluka;
import com.itcube.pojo.master.Student;
import com.itcube.service.master.StudentInterface;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vikram.galande
 */
@Controller
@RequestMapping("/student.htm")
@SessionAttributes("student")
public class StudentController {

    public static final String STUDENT_IMG_DIRECTORY = "images/student";
    private StudentInterface studentInterface;

    @Autowired
    public void setStudentInterface(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        com.itcube.pojo.master.Student student = new Student();
        student.setGender("M");
        model.addAttribute("countryList", studentInterface.getAllCountries());
        model.addAttribute("student", student);
        return "master/student";
    }

//    @RequestMapping(value = "/time", method = RequestMethod.GET)
//    public @ResponseBody
//    String getTime(@RequestParam String name) {
//        String result = "Time for " + name + " is " + new Date().toString();
//        return result;
//    }
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("student") Student student, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error: " + error.getCode() + " - "
                        + error.getDefaultMessage());
            }
        }

        com.itcube.hibernate.db.Student studentEntity = new com.itcube.hibernate.db.Student();
        String[] dob = null;
        String imgPhotoPath = "";
        String imgSignPath = "";
        int yy = 1978;
        int mm = 0;
        int dd = 1;
        if (null != student.getDateOfBirth() && !"".equals(student.getDateOfBirth())) {
            dob = student.getDateOfBirth().split("-");
            dd = Integer.parseInt(dob[0]);
            mm = Integer.parseInt(dob[1]);
            yy = Integer.parseInt(dob[2]);
        }
        MultipartFile file = student.getPhotoData();
        MultipartFile signFile = student.getSignData();

        String fileName = null;
        String signName = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int studentID = 0;
        if(null != student.getStudentID() && !"".equals(student.getStudentID())){
            studentID = Integer.parseInt(student.getStudentID());
        }else{
            studentID = studentInterface.getMaxStudentCode() + 1;
        }
                
        String studentImgName = "StudentPhoto" + studentID;
        String studentSignName = "StudentSign" + studentID;

        if (file.getSize() > 0) {
            inputStream = file.getInputStream();
            if (file.getSize() > 15000) {
                System.out.println("File Size:::" + file.getSize());
                //return "/uploadfile";
            }
            System.out.println("size::" + file.getSize());

            ServletContext servletContext = request.getSession().getServletContext();
            fileName = servletContext.getRealPath(STUDENT_IMG_DIRECTORY + "/"
                    + studentImgName + ".jpeg");

//            fileName = request.getRealPath("") + "/images/"
//                    + file.getOriginalFilename();

            outputStream = new FileOutputStream(fileName);
            System.out.println("fileName:" + file.getOriginalFilename());

            int readBytes = 0;
            byte[] buffer = new byte[15000];
            while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                outputStream.write(buffer, 0, readBytes);
            }
            outputStream.close();
            inputStream.close();
        }

        if (signFile.getSize() > 0) {
            inputStream = signFile.getInputStream();
            if (signFile.getSize() > 15000) {
                System.out.println("File Size:::" + signFile.getSize());
                //return "/uploadfile";
            }
            System.out.println("size::" + signFile.getSize());

            ServletContext servletContext = request.getSession().getServletContext();
            signName = servletContext.getRealPath(STUDENT_IMG_DIRECTORY + "/"
                    + studentSignName + ".jpeg");

//            fileName = request.getRealPath("") + "/images/"
//                    + file.getOriginalFilename();

            outputStream = new FileOutputStream(signName);
            
            int readBytes = 0;
            byte[] buffer = new byte[15000];
            while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                outputStream.write(buffer, 0, readBytes);
            }
            outputStream.close();
            inputStream.close();
        }

//        File photoDestFile = null;
//        int studentID = studentInterface.getMaxStudentCode() + 1;
//        String studentImgName = "StudentPhoto" + studentID;
//        try {
//            ServletContext servletContext = request.getSession().getServletContext();
//            imgPhotoPath = servletContext.getRealPath(STUDENT_IMG_DIRECTORY + "/"
//                    + studentImgName + ".jpeg");
//
//            //photoDestFile = new File(imgPhotoPath);
//            photoDestFile = new File(imgPhotoPath);
//
//            //FileUtils.copyFile(photoSourceFile, photoDestFile);
//            //FileUtils.copyFile(photoSourceFile, photoDestFile);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        studentEntity.setStudID(studentID);
        studentEntity.setStudName(student.getFname() + " " + student.getMname() + " " + student.getLname());
        studentEntity.setStudAddress1(student.getPermanentAddress());
        studentEntity.setStudAddress2(student.getPresentAddress());
        studentEntity.setStudContact(student.getMobile());
        studentEntity.setStudDOB(new Date(yy - 1900, mm - 1, dd));
        studentEntity.setStudEmail(student.getEmail());
        studentEntity.setStudGender(student.getGender().charAt(0));
        studentEntity.setStudPhotoPath(fileName);
        studentEntity.setStudSignPath(signName);
        Taluka taluka = new Taluka();
        taluka.setTalukaID(Integer.parseInt(student.getTaluka()));
        studentEntity.setTalukaID(taluka);
        studentInterface.add(studentEntity);
        return "master/studentSuccess";
    }
}
