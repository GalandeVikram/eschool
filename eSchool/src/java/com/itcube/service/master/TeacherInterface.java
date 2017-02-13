/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.pojo.master.Student;
import com.itcube.pojo.master.Teacher;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface TeacherInterface {

    public String add(Teacher teacher);

    public String update(Teacher teacher);

    public String delet(Teacher teacher);

    public List<Teacher> searchStudentList(Teacher teacher);

    public Teacher search(Teacher teacher);
}
