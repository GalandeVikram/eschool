/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "ACC_YEAR")
public class Temp implements Serializable{
    @Id
    @Column(name = "tempCode", nullable = false)
    private Integer tempCode;
    
    @Column(name = "tempName", length = 50)
    private String tempName;

    public Integer getTempCode() {
        return tempCode;
    }

    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }
}
