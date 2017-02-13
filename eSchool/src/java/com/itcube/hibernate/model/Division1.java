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

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "DIVISION")
public class Division1 implements Serializable {
    @Id    
    @Column(name = "div_code", nullable = false)
    private Integer divCode;
    
    
    @Column(name = "div_name", length = 50)
    private String divName;
    
    @OneToMany(mappedBy = "divCode")
    private Collection<StandardDetail> stdDetailCollection;

    public Integer getDivCode() {
        return divCode;
    }

    public void setDivCode(Integer divCode) {
        this.divCode = divCode;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    public Collection<StandardDetail> getStdDetailCollection() {
        return stdDetailCollection;
    }

    public void setStdDetailCollection(Collection<StandardDetail> stdDetailCollection) {
        this.stdDetailCollection = stdDetailCollection;
    }
}
