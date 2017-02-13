/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.utility;

import com.itcube.bo.ExamBO;

/**
 *
 * @author vikram.galande
 */
public class Test {
    public static void main(String[] args){
        ExamBO bO = new ExamBO();
        System.out.println(bO.createAdmission(null));
    }
}
