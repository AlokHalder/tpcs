package com.tpcs.admin.taskmgt.dao.impl;

import com.tpcs.admin.taskmgt.constant.TaskmgtConstant;
import com.tpcs.admin.taskmgt.dao.DBConnectionDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.ResultSet;
/**
 *
 * @author Administrator
 */
public class DbConnectionDaoImpl implements DBConnectionDao {

    private static final String PROP_DEST = "com.tpcs.db.properties.dbproperties";
    ResourceBundle resourceBundle = ResourceBundle.getBundle(PROP_DEST);
    Connection conn = null;

    @Override
    public Connection dbConnect() {
        try {
            Class.forName(resourceBundle.getString(TaskmgtConstant.DRIVER_CLASS));
            conn = DriverManager.getConnection(resourceBundle.getString(TaskmgtConstant.DRIVER_URL));
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }
        return conn;
    }
    /*
     * These following two methods added by
     * @TPCP_PL Chandan 109.(15.06.2013)
     */

    @Override
    public void dbClose(PreparedStatement pstm, Connection con) {
        if (null != pstm) {
            try {
                pstm.close();
                pstm = null;
                con.close();
                con = null;
            } catch (SQLException ex) {
            }
        } else {
        }
    }

    @Override
    public void dbClose(ResultSet rs, PreparedStatement pstm, Connection con) {
        if (null != rs) {
            try {
                rs.close();
                rs = null;
                pstm.close();
                pstm = null;
                con.close();
                con = null;
            } catch (SQLException ex) {
            }
        }
    }
}
