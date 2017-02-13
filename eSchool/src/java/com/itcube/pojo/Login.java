/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.pojo;

/**
 *
 * @author vikram.galande
 */
public class Login {

    private String username;
    private String password;    
    private String msg;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
