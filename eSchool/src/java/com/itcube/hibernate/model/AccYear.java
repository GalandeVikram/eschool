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
@Table(name = "ACC_YEAR")
public class AccYear implements Serializable {

    @Id
    @Column(name = "accy_code", nullable = false)
    private Integer accyCode;
    @Column(name = "accy_name", length = 50)
    private String accyName;
    @OneToMany(mappedBy = "accyCode")
    private Collection<StandardDetail> stdDetailCollection;

    public Integer getAccyCode() {
        return accyCode;
    }

    public void setAccyCode(Integer accyCode) {
        this.accyCode = accyCode;
    }

    public String getAccyName() {
        return accyName;
    }

    public void setAccyName(String accyName) {
        this.accyName = accyName;
    }

    public Collection<StandardDetail> getStdDetailCollection() {
        return stdDetailCollection;
    }

    public void setStdDetailCollection(Collection<StandardDetail> stdDetailCollection) {
        this.stdDetailCollection = stdDetailCollection;
    }
}
