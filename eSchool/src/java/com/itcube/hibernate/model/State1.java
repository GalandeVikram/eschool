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
@Table(name = "STATE")
public class State1 implements Serializable {

    @Id
    @Column(name = "s_code")
    private Long id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "c_code")
    private Long c_code;

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

    public Long getC_code() {
        return c_code;
    }

    public void setC_code(Long c_code) {
        this.c_code = c_code;
    }
}
