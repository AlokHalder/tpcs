/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tpcs.employeeinfo.dao.impl;

import com.tpcs.employeeinfo.constant.EmployeeInfoConstant;
import com.tpcs.employeeinfo.dao.DBConnectionDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author Administrator
 */
public class DbConnectionDaoImpl implements DBConnectionDao {
    private static final String PROP_DEST="com.tpcs.db.properties.dbproperties";
    ResourceBundle  resourceBundle = ResourceBundle.getBundle(PROP_DEST);

    Connection conn=null;
     public Connection dbConnect(){
         try{
       Class.forName(resourceBundle.getString(EmployeeInfoConstant.DRIVER_CLASS));
       conn = DriverManager.getConnection(resourceBundle.getString(EmployeeInfoConstant.DRIVER_URL));
       }
    catch(Exception e)
       {
        System.out.println("Exception occurs"+e.getMessage());
       }
        return conn;
    }

     }


