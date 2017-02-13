/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcube.service.db;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author vikram.galande
 */
public class ConnectDB {
    
    public static DataSource getSchooldb() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/schooldb");
    }
}
