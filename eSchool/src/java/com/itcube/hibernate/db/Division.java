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
@Table(name = "Division")
@XmlRootElement
public class Division implements Serializable {

    @Id
    @Column(name = "divisionID", length = 2, nullable = false)
    private int divisionID;
    @Column(name = "divisionName", length = 10, nullable = false)
    private String divisionName;
    
    @OneToMany(mappedBy = "divisionID")
    private Collection<ClassRoom> classRoomCollection;

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @XmlTransient
    public Collection<ClassRoom> getClassRoomCollection() {
        return classRoomCollection;
    }

    public void setClassRoomCollection(Collection<ClassRoom> classRoomCollection) {
        this.classRoomCollection = classRoomCollection;
    }
}
