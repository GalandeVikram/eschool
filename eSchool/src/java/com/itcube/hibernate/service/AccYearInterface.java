/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.hibernate.service;

import com.itcube.hibernate.model.AccYear;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface AccYearInterface {

    void create(AccYear accYear);

    void edit(AccYear accYear);

    void remove(AccYear accYear);

    AccYear find(Object id);

    List<AccYear> findAll();

    List<AccYear> findRange(int[] range);

    int count();
}
