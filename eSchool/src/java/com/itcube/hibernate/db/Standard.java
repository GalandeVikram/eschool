/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Standard")
@XmlRootElement
public class Standard implements Serializable {

    @Id
    @Column(name = "stdID", length = 2, nullable = false)
    private int stdID;
    
    @Column(name = "stdName", length = 15, nullable = false)
    private String stdName;
    
    @Column(name = "stdStrength", length = 2, nullable = false)
    private int stdStrength;
    
    @OneToMany(mappedBy = "stdID")
    private Collection<ClassRoom> classRoomCollection;

    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdStrength() {
        return stdStrength;
    }

    public void setStdStrength(int stdStrength) {
        this.stdStrength = stdStrength;
    }

    @XmlTransient
    public Collection<ClassRoom> getClassRoomCollection() {
        return classRoomCollection;
    }

    public void setClassRoomCollection(Collection<ClassRoom> classRoomCollection) {
        this.classRoomCollection = classRoomCollection;
    }
}
