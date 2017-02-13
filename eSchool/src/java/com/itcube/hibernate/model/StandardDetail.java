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
@Table(name = "STD_DETAIL")
public class StandardDetail implements Serializable {

    @Id
    @Column(name = "stdd_code", nullable = false)
    private Integer stddCode;
    
    @JoinColumn(name = "div_code", referencedColumnName = "div_code")
    @ManyToOne
    private Division1 divCode;
    
    @JoinColumn(name = "std_code", referencedColumnName = "std_code")
    @ManyToOne
    private Standard1 stdCode;
    
    @JoinColumn(name = "accy_code", referencedColumnName = "accy_code")
    @ManyToOne
    private AccYear accyCode;
    
    @OneToMany(mappedBy = "stddCode")
    private Collection<Enrollment> enrollmentCollection;
    

    public AccYear getAccyCode() {
        return accyCode;
    }

    public void setAccyCode(AccYear accyCode) {
        this.accyCode = accyCode;
    }

    public Division1 getDivCode() {
        return divCode;
    }

    public void setDivCode(Division1 divCode) {
        this.divCode = divCode;
    }

    public Standard1 getStdCode() {
        return stdCode;
    }

    public void setStdCode(Standard1 stdCode) {
        this.stdCode = stdCode;
    }

    public Integer getStddCode() {
        return stddCode;
    }

    public void setStddCode(Integer stddCode) {
        this.stddCode = stddCode;
    }

    @XmlTransient
    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }
}
