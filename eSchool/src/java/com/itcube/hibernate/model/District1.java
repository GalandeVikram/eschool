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
@Table(name = "DISTRICT")
public class District1 implements Serializable {
    @Id
    @Column(name ="d_code")
    private Long id;
    @Column(name ="d_name")
    private String name;
    @Column(name ="s_code")
    private Long s_code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getS_code() {
        return s_code;
    }

    public void setS_code(Long s_code) {
        this.s_code = s_code;
    }    
}
