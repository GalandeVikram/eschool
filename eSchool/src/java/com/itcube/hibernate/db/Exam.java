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
@Table(name = "Exam")
@XmlRootElement
public class Exam implements Serializable{
    @Id
    @Column(name="examID", length=4, nullable=false)
    private int examID;
    
    @Column(name="examName", length=50, nullable=false)
    private String examName;
    
    @XmlTransient
    @OneToMany(mappedBy="examID")
    private Collection<ExamDetail> examDetailCollection;

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Collection<ExamDetail> getExamDetailCollection() {
        return examDetailCollection;
    }

    public void setExamDetailCollection(Collection<ExamDetail> examDetailCollection) {
        this.examDetailCollection = examDetailCollection;
    }
}
