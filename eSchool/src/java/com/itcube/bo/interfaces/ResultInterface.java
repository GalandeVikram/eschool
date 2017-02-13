/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.bo.interfaces;

import com.itcube.bo.result.pojo.ResultPOJO;

/**
 *
 * @author vikram.galande
 */
public interface ResultInterface {

    public ResultPOJO getResult(int seatNumber);
    public void updateResult(ResultPOJO pOJO);
}
