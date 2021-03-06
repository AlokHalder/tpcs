/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.dao.impl;

import com.tpcs.admin.hrmgt.vo.LeaveManagementVO;
import com.tpcs.admin.hrmgt.vo.ResultVO;
import com.tpcs.admin.taskmgt.util.DateConversion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ALOK
 */
public class LeaveManagementDaoImpl {

    DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();

    public ResultVO storeLeave(LeaveManagementVO leaveManagementVO) {
        ResultVO resultVO = new ResultVO();
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            if (null != leaveManagementVO) {


                int associateId = leaveManagementVO.getAssociateId();
                String leaveType = leaveManagementVO.getLeaveType();
                String startDate = leaveManagementVO.getStartDate();
                String endDate = leaveManagementVO.getEndDate();
                String leaveDuration = leaveManagementVO.getLeaveDuration();
                String dayNum = leaveManagementVO.getDayNum();
                String reasonOfLeave = leaveManagementVO.getReasonOfLeave();
                conn = dbConnectionDaoImpl.dbConnect();
            

                String sqlQuery = "insert into emp_leave_register (emp_id,emp_leave_type,emp_leave_start_date,emp_leave_end_date,emp_leave_duration,emp_leave_days_count,emp_leave_reason,emp_leave_apply_date) values(?,?,?,?,?,?,?,curdate())";
                System.out.println(" Test Query : " + sqlQuery);
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, associateId);
                pstmt.setString(2, leaveType);
                pstmt.setString(3, DateConversion.convertDbDate(startDate));
                pstmt.setString(4, DateConversion.convertDbDate(endDate));
                pstmt.setString(5, leaveDuration);
                pstmt.setDouble(6, Double.valueOf(dayNum));
                pstmt.setString(7, reasonOfLeave);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {

                    resultVO.setMessage("<font style=color:green;font-weight: bold>Leave Submitted Successfully</font>");
                } else {
                    resultVO.setMessage("<font style=color:green;font-weight: bold>Leave Submission Failed</font>");
                }

            }
        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());

        } finally {
            try {

                if (null != pstmt) {
                    pstmt.close();
                }
                if (null != conn) {
                    conn.close();
                }

            } catch (SQLException sqlException) {
                System.out.println(" Message : " + sqlException.getMessage());
            }
        }
        return resultVO;
    }
}
