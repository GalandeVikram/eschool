/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.Country;
import com.itcube.hibernate.db.Student;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface StudentInterface {

    public void add(Student student);

    public int getMaxStudentCode();

    public String update(Student student);

    public String delet(Student student);

    public List<Student> searchStudentList(Student student);

    public Student search(Student student);

    public List<Country> getAllCountries();

    public String getStudentName(String rollNumber);
}
