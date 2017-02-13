/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "COUNTRY")
public class Country1 implements Serializable {

    private Long id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "c_code")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "c_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
