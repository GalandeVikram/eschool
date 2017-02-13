/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.dto;

import java.io.Serializable;

/**
 *
 * @author vikram.galande
 */
public class ClassRoomDTO implements Serializable{
    private long classRoomID;
    private String classRoomName;

    public long getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(long classRoomID) {
        this.classRoomID = classRoomID;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }
}
