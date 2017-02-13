/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.hibernate.db.Standard;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface StandardInterface {
    public List<Standard> getCurrentYearStandard(int accy_code);
}
