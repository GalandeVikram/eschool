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
@Table(name = "State")
@XmlRootElement
public class State implements Serializable {

    @Id
    @Column(name = "stateID", length = 4, nullable = false)
    private int stateID;
    
    @Column(name = "stateName", length = 50, nullable = true)    
    private String stateName;
    
    @JoinColumn(name = "countryID", referencedColumnName = "countryID")
    @ManyToOne    
    private Country countryID;
    
    @OneToMany(mappedBy = "stateID")
    private Collection<District> districtCollection;
    
    
    public Country getCountryID() {
        return countryID;
    }

    public void setCountryID(Country countryID) {
        this.countryID = countryID;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @XmlTransient
    public Collection<District> getDistrictCollection() {
        return districtCollection;
    }

    public void setDistrictCollection(Collection<District> districtCollection) {
        this.districtCollection = districtCollection;
    }
}
