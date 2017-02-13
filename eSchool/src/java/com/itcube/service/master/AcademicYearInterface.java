/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.AcademicYear;

/**
 *
 * @author vikram.galande
 */
public interface AcademicYearInterface {

    public AcademicYear getAcademicYear();
    
    public int getCurrentAcademicYearID();
}
