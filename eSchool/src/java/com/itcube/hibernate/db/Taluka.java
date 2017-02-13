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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "Taluka")
public class Taluka implements Serializable {

    @Id
    @Column(name = "talukaID", length = 8, nullable = false)
    private int talukaID;
    @Column(name = "talukaName", length = 50, nullable = true)
    private String talukaName;
    @JoinColumn(name = "districtID", referencedColumnName = "districtID")
    @ManyToOne
    private District districtID;
    @XmlTransient
    @OneToMany(mappedBy = "studID")
    private Collection<Student> studentCollection;
    
    
    public District getDistrictID() {
        return districtID;
    }

    public void setDistrictID(District districtID) {
        this.districtID = districtID;
    }

    public int getTalukaID() {
        return talukaID;
    }

    public void setTalukaID(int talukaID) {
        this.talukaID = talukaID;
    }

    public String getTalukaName() {
        return talukaName;
    }

    public void setTalukaName(String talukaName) {
        this.talukaName = talukaName;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }
}
