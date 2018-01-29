/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public interface DBConnectionDao {

    Connection dbConnect();
    /*
     * These following two methods added by
     * @TPCP_PL Chandan 109.(15.06.2013)
     */

    void dbClose(PreparedStatement ps, Connection con);

    void dbClose(ResultSet rs, PreparedStatement ps, Connection con);
}
