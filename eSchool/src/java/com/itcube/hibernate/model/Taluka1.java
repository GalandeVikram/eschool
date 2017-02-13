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
@Table(name = "Taluka")
public class Taluka1 implements Serializable {
    @Id
    @Column(name="t_code")
    private Long id;
    @Column(name="t_name")
    private String name;
    @Column(name="d_code")
    private Long d_code;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getD_code() {
        return d_code;
    }

    public void setD_code(Long d_code) {
        this.d_code = d_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
