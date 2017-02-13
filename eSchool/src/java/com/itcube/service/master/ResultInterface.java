/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.master;

import com.itcube.pojo.master.Result;
import java.util.List;

/**
 *
 * @author vikram.galande
 */
public interface ResultInterface {
    public List<Result> getResult(String standard);
    public Result getResult(String standard,String seatNumber);
}
