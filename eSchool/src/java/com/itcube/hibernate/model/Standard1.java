/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.model;


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
@Table(name = "STD")
@XmlRootElement
public class Standard1 implements Serializable {

    @Id    
    @Column(name = "std_code", nullable = false)
    private Integer stdCode;
    
    @Column(name = "std_name")
    private String stdName;
    
    @Column(name = "std_strength")
    private Integer stdStrength;
    
    @OneToMany(mappedBy = "stdCode")
    private Collection<StandardDetail> stdDetailCollection;

    public Integer getStdCode() {
        return stdCode;
    }

    public void setStdCode(Integer stdCode) {
        this.stdCode = stdCode;
    }

    @XmlTransient
    public Collection<StandardDetail> getStdDetailCollection() {
        return stdDetailCollection;
    }

    public void setStdDetailCollection(Collection<StandardDetail> stdDetailCollection) {
        this.stdDetailCollection = stdDetailCollection;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public Integer getStdStrength() {
        return stdStrength;
    }

    public void setStdStrength(Integer stdStrength) {
        this.stdStrength = stdStrength;
    }
}
