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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */

@Entity
@Table(name = "District")
@XmlRootElement
public class District implements Serializable{
    @Id
    @Column(name="districtID", length=6, nullable=false)
    private int districtID;
    @Column(name = "districtName", length = 50, nullable = true)
    private String districtName;
    
    @JoinColumn(name = "stateID", referencedColumnName = "stateID")
    @ManyToOne
    private State stateID;
    
    @OneToMany(mappedBy = "districtID")
    private Collection<Taluka> talukaCollection;

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public State getStateID() {
        return stateID;
    }

    public void setStateID(State stateID) {
        this.stateID = stateID;
    }

    @XmlTransient
    public Collection<Taluka> getTalukaCollection() {
        return talukaCollection;
    }

    public void setTalukaCollection(Collection<Taluka> talukaCollection) {
        this.talukaCollection = talukaCollection;
    }    
}
