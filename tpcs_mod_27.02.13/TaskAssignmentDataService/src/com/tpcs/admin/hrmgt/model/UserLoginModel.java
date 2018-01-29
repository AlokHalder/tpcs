package com.tpcs.admin.hrmgt.model;

import com.tpcs.admin.hrmgt.vo.AttendanceReportVO;
import com.tpcs.admin.hrmgt.vo.ResultVO;
import com.tpcs.admin.hrmgt.vo.EmployeeProfileVO;
import com.tpcs.admin.hrmgt.vo.UserProfileVO;
import com.tpcs.admin.taskmgt.dao.impl.DbConnectionDaoImpl;
import com.tpcs.admin.taskmgt.util.DateConversion;
import com.tpcs.admin.taskmgt.util.EmailService;
import com.tpcs.employeeinfo.vo.EmployeeLoginVO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserLoginModel {
    /*
     * The method(userCredential) modyfied by
     * @TPCP_PL Chandan 109.(15.06.2013)
     */

    public UserProfileVO userCredential(EmployeeLoginVO loginVO) {
        UserProfileVO userProfileVO = new UserProfileVO();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection con = dbConnectionDaoImpl.dbConnect();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            pstmt = con.prepareStatement("select user_id,user_password,user_call_name,user_role from user_profile where user_id=? and user_password =?");
            pstmt.setInt(1, loginVO.getEmploueeId());
            pstmt.setString(2, loginVO.getLoginPassword());
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString(2);
                if (storedPassword.equals(loginVO.getLoginPassword())) {
                    userProfileVO.setUserId(resultSet.getInt(1));
                    userProfileVO.setPassword(storedPassword);
                    userProfileVO.setUserName(resultSet.getString(3));
                    userProfileVO.setUserRoleName(resultSet.getString(4));
                    userProfileVO.setUserFlag(true);
                } else {
                    userProfileVO.setUserFlag(false);
                    userProfileVO.setMessage("Login Failed...");
                }
            } else {
                userProfileVO.setUserFlag(false);
                userProfileVO.setMessage("Login Failed...");
            }
        } catch (SQLException sqle) {
        }finally{
            dbConnectionDaoImpl.dbClose(resultSet, pstmt, con);
        }
        return userProfileVO;
    }

    public ResultVO postTime(int resourceId) {

        ResultVO resultVO = new ResultVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            if (resourceId > 0) {

                String sqlQuery = "insert into emp_attendance_register (emp_id,emp_office_entry_time,current_date_value) values(" + resourceId + ",current_time(),curdate())";
                Statement stmt = conn.createStatement();
                System.out.println("sqlQuery" + sqlQuery);
                int rowsAffected = stmt.executeUpdate(sqlQuery);

                if (rowsAffected > 0) {

                    Date d1 = new Date();
                    Calendar cl = Calendar.getInstance();
                    cl.setTime(d1);
                    EmailService emailService = new EmailService();
                    String sendEmail = emailService.sendEmail(resourceId, d1.toString());
                    resultVO.setMessage("Your Office Entry Time : " + d1.toString() + " saved successfully . Have a good day !!");

                } else {
                    System.out.println("Connection not found ");
                }
            }
        } catch (Exception exception) {
            System.out.println("exception" + exception.getMessage());
            resultVO.setMessage("Sorry,You Have Already Enter In The Office");

        }
        return resultVO;
    }

    public ResultVO closeTime(int empId) {
        Statement stmt = null;
        Statement stmt_search = null;
        int rowsAffected = 0;

        ResultVO resultVO = new ResultVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            if (empId > 0) {
                //String joiningDate= userLoginVO.getJoiningdate();
                String sqlQuery_search = "select * from emp_attendance_register where current_date_value=curdate() and emp_id =" + empId;
                System.out.println(" Query : ");
                stmt = conn.createStatement();
                System.out.println("sqlQuery" + sqlQuery_search);
                ResultSet rs = stmt.executeQuery(sqlQuery_search);

                if (rs.next()) {
                    if (null != rs.getString("emp_office_leave_time")) {
                        resultVO.setMessage("You Have already leave The Office");
                    } else {
                        String sqlQuery = "update emp_attendance_register set emp_office_leave_time = current_time() where current_date_value=curdate() and emp_id =" + empId;
                        System.out.println(" Query : ");
                        stmt = conn.createStatement();
                        System.out.println("sqlQuery" + sqlQuery);
                        rowsAffected = stmt.executeUpdate(sqlQuery);
                        if (rowsAffected > 0) {
                            System.out.println("rowAffected" + rowsAffected);
                            java.util.Date utilDate = new Date();
                            java.sql.Time time = new java.sql.Time(utilDate.getTime());
                            resultVO.setMessage(" Your Office Leave time : " + time + " saved successfully . ");
                        }
                    }
                }
            } else {
            }
        } catch (Exception exception) {
        }
        String message = resultVO.getMessage();
        System.out.println("Message:" + message);

        return resultVO;
    }

    public ResultVO userentry(EmployeeProfileVO employeeProfileVO) {


        ResultVO resultVO = new ResultVO();
        //CategoryVO categoryVO = new CategoryVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            if (null != conn) {
                String userid = employeeProfileVO.getUserid();
                Integer password = employeeProfileVO.getPassword();
                String name = employeeProfileVO.getName();
                Date joiningdate = employeeProfileVO.getJoiningDate();
                Date dateofbirth = employeeProfileVO.getDateOfBirth();
                String designation = employeeProfileVO.getDesignation();
                String qualificaton = employeeProfileVO.getHigherQualification();
                //Date yearofpassout = userLoginVO.getYearofpassout();
                String specialization = employeeProfileVO.getSpecilization();
                String empaddress = employeeProfileVO.getAddress();
                Integer zipcode = employeeProfileVO.getZipCode();
                String contactnumber = employeeProfileVO.getContactNumber();
                String emialid = employeeProfileVO.getEmailId();


                //String joiningDate= userLoginVO.getJoiningdate();
                //String sqlQuery = "insert into emp_table (user_id,user_password,name,designation,highest_qualification,specilization,emp_address,emp_pin_zipcode,emp_contact_number,emp_email_id) values('"+userid+"',"+password+",'"+name+"',"+designation+"','"+qualificaton+"','"+specialization+"','"+empaddress+"',"+zipcode+",'"+contactnumber+"','"+emialid+"')";
                String sqlQuery = "insert into  emp_table (user_id,user_password,name,designation,highest_qualification,specilization,emp_address,emp_pin_zipcode,emp_contact_number,emp_email_id,joining_date,date_of_birth) values('" + userid + "'," + password + ",'" + name + "','" + designation + "','" + qualificaton + "','" + specialization + "','" + empaddress + "'," + zipcode + ",'" + contactnumber + "','" + emialid + "',curdate(),curdate())";
                Statement stmt = conn.createStatement();
                System.out.println("sqlQuery" + sqlQuery);
                int rowsAffected = stmt.executeUpdate(sqlQuery);

                if (rowsAffected > 0) {
                    System.out.println("rowAffected" + rowsAffected);
                }
            } else {
                System.out.println("Connection not found ");
            }
        } catch (Exception exception) {
            System.out.println("exception" + exception.getMessage());
        }


        return resultVO;
    }

    public List<AttendanceReportVO> officeAttendanceReport(int empId) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<AttendanceReportVO> listOfAttendanceReport = new ArrayList<AttendanceReportVO>();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            conn = dbConnectionDaoImpl.dbConnect();
            if (empId > 0) {

                String sqlQuery = "select current_date_value,emp_office_entry_time, emp_office_leave_time, timediff(emp_office_leave_time,emp_office_entry_time) as office_hours ,timediff('09:00:00',timediff(emp_office_leave_time,emp_office_entry_time)) as office_hour_loss from emp_attendance_register where emp_id =? order by current_date_value desc";

                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, empId);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    AttendanceReportVO attendanceReportVO = new AttendanceReportVO();
                    attendanceReportVO.setCurrentDateValue(DateConversion.convertDbDate(rs.getString("current_date_value")));
                    attendanceReportVO.setOfficeEntryTime(rs.getString("emp_office_entry_time"));
                    attendanceReportVO.setOfficeLeaveTime(rs.getString("emp_office_leave_time"));
                    attendanceReportVO.setOfficeHoursSpent(rs.getString("office_hours"));
                    attendanceReportVO.setOfficeHoursLoss(rs.getString("office_hour_loss"));
                    listOfAttendanceReport.add(attendanceReportVO);
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
        return listOfAttendanceReport;

    }
}
