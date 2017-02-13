/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "Room")
@XmlRootElement
public class Room implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "roomID", nullable = false)
    private int roomID;
    @Column(name = "roomName", length=50)
    private String roomName;
    @Column(name = "roomStrength", length=2)
    private int roomStrength;
    
    @OneToMany(mappedBy = "roomID")
    private Collection<ClassRoom> classRoomCollection;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomStrength() {
        return roomStrength;
    }

    public void setRoomStrength(int roomStrength) {
        this.roomStrength = roomStrength;
    }

    @XmlTransient
    public Collection<ClassRoom> getClassRoomCollection() {
        return classRoomCollection;
    }

    public void setClassRoomCollection(Collection<ClassRoom> classRoomCollection) {
        this.classRoomCollection = classRoomCollection;
    }
}
