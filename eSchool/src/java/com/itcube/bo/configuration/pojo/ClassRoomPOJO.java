/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.configuration.pojo;

import java.util.List;

/**
 *
 * @author vikram.galande
 */
public class ClassRoomPOJO {
    public String classRoomID;
    public String classRoomName;
    public List<ClassRoomPOJO> classRoomList;

    public String getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(String classRoomID) {
        this.classRoomID = classRoomID;
    }

    public List<ClassRoomPOJO> getClassRoomList() {
        return classRoomList;
    }

    public void setClassRoomList(List<ClassRoomPOJO> classRoomList) {
        this.classRoomList = classRoomList;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }
}
