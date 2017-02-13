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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vikram.galande
 */
@Entity
@Table(name = "Subject")
@XmlRootElement
public class Subject implements Serializable{
    
    @Id
    @Column(name="subjectID", length=4, nullable=false)
    private int subjectID;
    
    @Column(name="subjectName", length=50, nullable=false)
    private String subjectName;

    @OneToMany(mappedBy="subjectID")
    private Collection<SubjectDetail> subjDetailCollection;
    
    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @XmlTransient
    public Collection<SubjectDetail> getSubjDetailCollection() {
        return subjDetailCollection;
    }

    public void setSubjDetailCollection(Collection<SubjectDetail> subjDetailCollection) {
        this.subjDetailCollection = subjDetailCollection;
    }
}
