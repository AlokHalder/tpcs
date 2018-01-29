/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employeeinfo.dao.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tpcs.admin.taskmgt.util.DateConversion;
import com.tpcs.admin.taskmgt.util.EmailService;
import com.tpcs.admin.taskmgt.vo.StatusReportVO;
import com.tpcs.employeeinfo.dao.EmployeeInformationServicesDao;
import com.tpcs.employeeinfo.vo.EmployeeInfoVO;
import com.tpcs.employeeinfo.vo.ResultVO;
import com.tpcs.employeeinfo.vo.UserProfileVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class EmployeeInformationServicesDaoImpl implements EmployeeInformationServicesDao {

    DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();

    @Override
    public ResultVO storeEmployeeInfo(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            if (null != employeeInfoVO) {
                String name = employeeInfoVO.getName();
                String address = employeeInfoVO.getAddress();
                String dateofbirth = employeeInfoVO.getDateofbirth();
                String maritalstatus = employeeInfoVO.getMaritalstatus();
                String dateofjoining = employeeInfoVO.getDateofjoining();
                String grade = employeeInfoVO.getGrade();
                String deputedlocation = employeeInfoVO.getDeputedlocation();
                String employeetype = employeeInfoVO.getEmployeetype();
                String gender = employeeInfoVO.getGender();
                String nationality = employeeInfoVO.getNationality();
                String designation = employeeInfoVO.getDesignation();
                String employmentstatus = employeeInfoVO.getEmploymentstatus();
                String emailid = employeeInfoVO.getEmailid();
                String city = employeeInfoVO.getCity();
                String phone = employeeInfoVO.getPhone();
                String pin = employeeInfoVO.getPin();

                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();

                String sqlQuery = "insert into employee(name,address,date_of_birth,marital_status,date_of_joining,grade,deputed_location,employee_type,gender,nationality,designation,employment_status,email_id,city,pin,phone) values('" + name + "','" + address + "','" + dateofbirth + "','" + maritalstatus + "','" + dateofjoining + "','" + grade + "','" + deputedlocation + "','" + employeetype + "','" + gender + "','" + nationality + "','" + designation + "','" + employmentstatus + "','" + emailid + "','" + city + "','" + pin + "','" + phone + "')";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {

                    resultVO.setIsflag(true);
                    String sqlquery_employee = "select employee_id from employee where  email_id=? ";

                    pstmt = (PreparedStatement) conn.prepareStatement(sqlquery_employee);
                    pstmt.setString(1, emailid);
                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        resultVO.setEmployeeId(rs.getString("employee_id"));
                    } else {
                        resultVO.setIsflag(false);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultVO;
    }

    @Override
    public EmployeeInfoVO populateEmployeeInfo(String employeeId) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        String designation = null;
        String status = null;

        try {
            if (null != employeeId) {

                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                int empId = Integer.parseInt(employeeId);

                String sqlQuery = "select up.user_id,up.user_call_name,td.designation,tl.location_name,tl1.location_name,epd.address,ld.location_name,epd.pin,epd.phone,epd.email_id,eod.supervisor_id,up1.user_call_name,tpi.parent_iou_name,up3.user_call_name,eod.date_of_joining,eod.employee_status,eod.employee_type from user_profile up,user_profile up1,tpcs_parent_iou tpi,user_profile up3,employee_office_details eod,tpcs_location tl,tpcs_location tl1,location_details ld,employee_personal_details epd,tpcs_designation td where up.user_id=" + empId + " and eod.employee_id=up.user_id and epd.employee_id=up.user_id and epd.location_id=ld.location_id and tl.location_id=eod.base_branch_id and tl1.location_id=eod.deputed_location_id and up1.user_id=eod.supervisor_id and tpi.parent_iou_id=eod.parent_iou_id and up3.user_id=eod.sub_iou_id and up.user_role=td.designation_id;";
                System.out.println(" Test Query : " + sqlQuery);
                ResultSet rs = st.executeQuery(sqlQuery);

                if (rs.next()) {
                    if (rs.getString(16).equals("1")) {
                        status = "Actve";
                    } else {
                        status = "Not Actve";
                    }

                    //System.out.println("employeeeeeeeeeeeeeeeeeeee Iddddddddd" + rs.getString("employee_id"));
                    employeeInfoVO.setEmployeeId(rs.getString(1));
                    employeeInfoVO.setName(rs.getString(2));
                    employeeInfoVO.setDesignation(rs.getString(3));
                    employeeInfoVO.setBaselocation(rs.getString(4));
                    employeeInfoVO.setDeputedlocation(rs.getString(5));
                    employeeInfoVO.setAddress(rs.getString(6));
                    employeeInfoVO.setCity(rs.getString(7));
                    employeeInfoVO.setPin(rs.getString(8));
                    employeeInfoVO.setPhone(rs.getString(9));
                    employeeInfoVO.setEmailid(rs.getString(10));
                    employeeInfoVO.setSupervisorId(rs.getString(11));
                    employeeInfoVO.setSupervisorName(rs.getString(12));
                    employeeInfoVO.setParentIouName(rs.getString(13));
                    employeeInfoVO.setSubIouName(rs.getString(14));
                    employeeInfoVO.setDateofjoining(DateConversion.convertDbDate(rs.getString(15)));
                    employeeInfoVO.setProfileStatus(status);;
                    employeeInfoVO.setEmployeetype(rs.getString(17));

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeInfoVO;
    }

    public List<EmployeeInfoVO> viewEmployeeInfoByName(String name1) {
        List<EmployeeInfoVO> listOfEmployee = new ArrayList<EmployeeInfoVO>();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select up.user_id,up.user_call_name,td.designation, ld.location_name,epd.pin,epd.phone,epd.email_id from user_profile up,location_details ld,employee_personal_details epd,tpcs_designation td where  epd.employee_id=up.user_id and epd.location_id=ld.location_id and up.user_role=td.designation_id and up.user_call_name like'" + name1 + "%' ";
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);
            EmployeeInfoVO employeeInfoVO = null;
            while (rs.next()) {
                employeeInfoVO = new EmployeeInfoVO();
                employeeInfoVO.setEmployeeId(rs.getString(1));
                employeeInfoVO.setName(rs.getString(2));
                employeeInfoVO.setDesignation(rs.getString(3));
                employeeInfoVO.setCity(rs.getString(4));
                employeeInfoVO.setPin(rs.getString(5));
                employeeInfoVO.setPhone(rs.getString(6));
                employeeInfoVO.setEmailid(rs.getString(7));
                listOfEmployee.add(employeeInfoVO);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listOfEmployee;
    }

    public EmployeeInfoVO populateMyEmployeeInfo(int employeeId) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        String designation = null;
        String status = null;

        try {


            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();


            String sqlQuery = "select up.user_id,up.user_call_name,td.designation,tl.location_name,tl1.location_name,epd.address,ld.location_name,epd.pin,epd.phone,epd.email_id,eod.supervisor_id,up1.user_call_name,tpi.parent_iou_name,up3.user_call_name,eod.date_of_joining,eod.employee_status,eod.employee_type from user_profile up,user_profile up1,tpcs_parent_iou tpi,user_profile up3,employee_office_details eod,tpcs_location tl,tpcs_location tl1,location_details ld,employee_personal_details epd,tpcs_designation td where up.user_id=" + employeeId + " and eod.employee_id=up.user_id and epd.employee_id=up.user_id and epd.location_id=ld.location_id and tl.location_id=eod.base_branch_id and tl1.location_id=eod.deputed_location_id and up1.user_id=eod.supervisor_id and tpi.parent_iou_id=eod.parent_iou_id and up3.user_id=eod.sub_iou_id and up.user_role=td.designation_id;";
            System.out.println(" Test Query : " + sqlQuery);
            ResultSet rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                if (rs.getString(16).equals("1")) {
                    status = "Actve";
                } else {
                    status = "Not Actve";
                }

                //System.out.println("employeeeeeeeeeeeeeeeeeeee Iddddddddd" + rs.getString("employee_id"));
                employeeInfoVO.setEmployeeId(rs.getString(1));
                employeeInfoVO.setName(rs.getString(2));
                employeeInfoVO.setDesignation(rs.getString(3));
                employeeInfoVO.setBaselocation(rs.getString(4));
                employeeInfoVO.setDeputedlocation(rs.getString(5));
                employeeInfoVO.setAddress(rs.getString(6));
                employeeInfoVO.setCity(rs.getString(7));
                employeeInfoVO.setPin(rs.getString(8));
                employeeInfoVO.setPhone(rs.getString(9));
                employeeInfoVO.setEmailid(rs.getString(10));
                employeeInfoVO.setSupervisorId(rs.getString(11));
                employeeInfoVO.setSupervisorName(rs.getString(12));
                employeeInfoVO.setParentIouName(rs.getString(13));
                employeeInfoVO.setSubIouName(rs.getString(14));
                employeeInfoVO.setDateofjoining(DateConversion.convertDbDate(rs.getString(15)));
                employeeInfoVO.setProfileStatus(status);;
                employeeInfoVO.setEmployeetype(rs.getString(17));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeInfoVO;
    }

    @Override
    public ResultVO deleteEmployeeInfo(String employeeIds) {
        ResultVO resultVO = new ResultVO();
        int rowsAffected = 0;
        try {
            if (null != employeeIds) {
                DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
                DbConnectionDaoImpl dbConnectionDaoImpl1 = new DbConnectionDaoImpl();
                DbConnectionDaoImpl dbConnectionDaoImpl2 = new DbConnectionDaoImpl();
                Connection conn1 = dbConnectionDaoImpl.dbConnect();
                Connection conn2 = dbConnectionDaoImpl1.dbConnect();
                Connection conn3 = dbConnectionDaoImpl2.dbConnect();
                /*Connection conn4 = dbConnectionDaoImpl.dbConnect();
                 Connection conn5 = dbConnectionDaoImpl.dbConnect();
                 Connection conn6 = dbConnectionDaoImpl.dbConnect();*/
                int employeeId = Integer.parseInt(employeeIds);



                Statement st_General = conn1.createStatement();
                Statement st_Professional = conn2.createStatement();
                Statement st_UserProfile = conn3.createStatement();
                /* Statement st_EducationQuery = conn4.createStatement();
                 Statement st_PersonalQuery = conn5.createStatement();
                 Statement st_UserProfQuery = conn6.createStatement();*/
                String sqlGeneral = "delete epd,ead,eed,eod from employee_personal_details as epd JOIN employee_account_details as ead on ead.employee_id=epd.employee_id JOIN employee_education_details as eed on eed.employee_id=ead.employee_id JOIN employee_office_details as eod on eod.employee_id=eed.employee_id WHERE epd.employee_id = " + employeeId;
                String sqlProfessional = "delete from employee_professional_details where employee_id=" + employeeId;
                String sqlUserProfile = "delete from user_profile where user_id=" + employeeId;
                /*String sqlEducationQuery="delete from employee_education_details where employee_id=" + employeeId;
                 String sqlPersonalQuery="delete from employee_personal_details where employee_id=" + employeeId;
                 String sqlUserProfQuery="delete from user_profile where  user_id=" + employeeId;*/

                System.out.println(" Test Query : " + sqlGeneral);
                System.out.println(" Test Query : " + sqlProfessional);
                System.out.println(" Test Query : " + sqlUserProfile);

                System.out.println("One Row Deleted");

                rowsAffected = st_General.executeUpdate(sqlGeneral);
                if (rowsAffected > 0) {
                    st_Professional.executeUpdate(sqlProfessional);
                    st_UserProfile.executeUpdate(sqlUserProfile);

                    System.out.println("One Row Deleted");

                    resultVO.setMessage("One row deleted");
                } else {
                    System.out.println("No Row Deleted");
                    resultVO.setMessage("No row deleted");
                }
            }


        } catch (Exception e) {
            System.out.println("Exception:" + e);
            e.getMessage();
        }
        return resultVO;
    }

    @Override
    public EmployeeInfoVO modifyEmployeeInfo(EmployeeInfoVO employeeInfoVO) {
        if (null != employeeInfoVO) {
            String employeeId = employeeInfoVO.getEmployeeId();
            String name = employeeInfoVO.getName();
            String address = employeeInfoVO.getAddress();
            String city = employeeInfoVO.getCity();
            String phone = employeeInfoVO.getPhone();
            String pin = address = employeeInfoVO.getPin();
            try {
                DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String updateQuery = "update employee set name='" + name + "',address='" + address + "', city='" + city + "',pin='" + pin + "',phone='" + phone + "' where employee_id=" + employeeId;
                System.out.println(" updateQuery : " + updateQuery);
                int rowsAffected = st.executeUpdate(updateQuery);
                if (rowsAffected > 0) {
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return employeeInfoVO;
    }

    @Override
    public ResultVO searchEmployeeInfo(String employeeId) {
        ResultVO resultVO = new ResultVO();
        try {
            if (null != employeeId) {
                DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "select * from employee where ";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {

                    resultVO.setMessage("");
                } else {
                    resultVO.setMessage("");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return resultVO;
    }

    @Override
    public boolean userValidation(UserProfileVO userProfileVO) {
        String dbUser = null;
        String dbPassword = null;
        String user = userProfileVO.getUser();
        String password = userProfileVO.getPassword();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        try {
            Connection conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from login where user ='" + user + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                dbUser = rs.getString("user");
                dbPassword = rs.getString("password");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (user.equals(dbUser) && password.equals(dbPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<EmployeeInfoVO> viewAllEmployeeInfo() {
        List<EmployeeInfoVO> listOfEmployee = new ArrayList<EmployeeInfoVO>();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select up.user_id,up.user_call_name,td.designation, ld.location_name,epd.pin,epd.phone,epd.email_id from user_profile up,location_details ld,employee_personal_details epd,tpcs_designation td where  epd.employee_id=up.user_id and epd.location_id=ld.location_id and up.user_role=td.designation_id;";
            ResultSet rs = st.executeQuery(sqlQuery);
            EmployeeInfoVO employeeInfoVO = null;
            while (rs.next()) {
                employeeInfoVO = new EmployeeInfoVO();
                employeeInfoVO.setEmployeeId(rs.getString(1));
                employeeInfoVO.setName(rs.getString(2));
                employeeInfoVO.setDesignation(rs.getString(3));
                employeeInfoVO.setCity(rs.getString(4));
                employeeInfoVO.setPin(rs.getString(5));
                employeeInfoVO.setPhone(rs.getString(6));
                employeeInfoVO.setEmailid(rs.getString(7));
                listOfEmployee.add(employeeInfoVO);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listOfEmployee;
    }

    public ResultVO insertUserProfileAction(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String employeeid = null;
        try {
            if (null != employeeInfoVO) {
                String name = employeeInfoVO.getName();
                String designation = employeeInfoVO.getDesignation();
                String password = employeeInfoVO.getPassword();
                //int employeeid;
                int empid = Integer.parseInt(employeeInfoVO.getEmployeeId());
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "insert into user_profile(user_id,user_call_name,user_password,user_role) values(" + empid + ",'" + name + "','" + password + "','" + designation + "')";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);

                } else {
                    resultVO.setMessage("Emp Id is Duplicate");
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            resultVO.setMessage("Emp Id is Duplicate");
            resultVO.setIsflag(false);

            e.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO insertUserPersonalService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String employeeid = null;
        try {
            if (null != employeeInfoVO) {
                String address = employeeInfoVO.getAddress();
                String dateofbirth = DateConversion.convertUiDate(employeeInfoVO.getDateofbirth());
                String phone = employeeInfoVO.getPhone();
                String altphone = employeeInfoVO.getAltphone();
                String maritalstatus = employeeInfoVO.getMaritalstatus();
                int location_id = Integer.parseInt(employeeInfoVO.getLocation_id());
                int country_id = Integer.parseInt(employeeInfoVO.getCountry_id());
                String gender = employeeInfoVO.getGender();
                String nationality = employeeInfoVO.getNationality();
                String emailid = employeeInfoVO.getEmailid();
                int pin = Integer.parseInt(employeeInfoVO.getPin());
                int employee_id = Integer.parseInt(employeeInfoVO.getEmployeeId());
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "insert into employee_personal_details(employee_id,address,location_id,pin,phone,alternate_phone,gender,country_id,email_id,date_of_birth,marital_status,nationality) values(" + employee_id + ",'" + address + "'," + location_id + "," + pin + ",'" + phone + "','" + altphone + "','" + gender + "'," + country_id + ",'" + emailid + "','" + dateofbirth + "','" + maritalstatus + "','" + nationality + "')";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO postGrievance(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        String emailid = null;
        String emailMessage = "";
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            EmailService emailService = new EmailService();
            if (null != employeeInfoVO) {
                String grievance = employeeInfoVO.getGrievance();
                int employeeId = employeeInfoVO.getUserid();
                String sqlQuery = "insert into tpcs_grivences (employee_id,grivence,grivence_time,grivence_date) values(" + employeeId + ",'" + grievance + "',current_time(),curdate())";
                Statement stmt = conn.createStatement();
                System.out.println("sqlQuery" + sqlQuery);
                int rowsAffected = stmt.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    String sqlquerymail = "SELECT email_id from employee_personal_details where employee_id=" + employeeId;
                    ResultSet rs = stmt.executeQuery(sqlquerymail);
                    if (rs.next()) {
                        emailMessage = "Mail Try To Send";

                        emailid = rs.getString(1);
                        emailMessage = emailService.sendEmailGriveance(employeeId, grievance, emailid);
                    }
                    java.util.Date d1 = new java.util.Date();
                    Calendar cl = Calendar.getInstance();
                    cl.setTime(d1);
                    resultVO.setMessage("Your Grievance Time : " + d1.toString() + " saved successfully . Dont Worry,We Take step in sortly !!" + emailMessage);

                } else {
                    System.out.println("Connection not found ");
                }
            }
        } catch (Exception exception) {
            System.out.println("exception" + exception.getMessage());
        }
        return resultVO;
    }

    public ResultVO insertUserEduService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String employeeid = null;
        int pg_qualification = 0;
        int pg_specialization = 0;
        int pg_university = 0;
        try {
            if (null != employeeInfoVO) {
                int ug_qualification = Integer.parseInt(employeeInfoVO.getUg_qualification());
                int ug_specialization = Integer.parseInt(employeeInfoVO.getUg_specialization());
                String ug_passout = employeeInfoVO.getUg_passout();
                int ug_university = Integer.parseInt(employeeInfoVO.getUg_university());
                pg_qualification = Integer.parseInt(employeeInfoVO.getPg_qualification());
                pg_specialization = Integer.parseInt(employeeInfoVO.getPg_specialization());
                pg_university = Integer.parseInt(employeeInfoVO.getPg_university());
                String pg_passout = employeeInfoVO.getPg_passout();
                int employee_id = Integer.parseInt(employeeInfoVO.getEmployeeId());
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "insert into employee_education_details(employee_id,ug_qualification,ug_specialization,ug_year_of_passout,ug_university,pg_qualification,pg_specialization,pg_year_of_passout,pg_university) values(" + employee_id + "," + ug_qualification + "," + ug_specialization + ",'" + ug_passout + "'," + ug_university + "," + pg_qualification + "," + pg_specialization + ",'" + pg_passout + "'," + pg_university + ")";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO insertUserProfService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != employeeInfoVO) {
                String[] employmentname = employeeInfoVO.getEmploymentname();
                String[] empduration = employeeInfoVO.getEmpduration();
                String[] pastdatejoining = employeeInfoVO.getPastdatejoining();
                String[] dateofrealise = employeeInfoVO.getDateofrealise();



                int employee_id = Integer.parseInt(employeeInfoVO.getEmployeeId());
                conn = dbConnectionDaoImpl.dbConnect();
                conn.setAutoCommit(false);

                String sqlQuery = "insert into employee_professional_details(employee_id,employment_name,employment_duration,joining_date,release_date)values(?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                for (int i = 0; i < employmentname.length; i++) {
                    pstmt.setInt(1, employee_id);
                    pstmt.setString(2, employmentname[i]);
                    pstmt.setString(3, empduration[i]);
                    if (pastdatejoining[i] == "Date Of Joining") {
                        pstmt.setString(4, "Null");
                    } else {
                        pstmt.setString(4, DateConversion.convertUiDate(pastdatejoining[i]));
                    }
                    if (pastdatejoining[i] == "Release Date") {
                        pstmt.setString(5, "Null");
                    } else {
                        pstmt.setString(5, DateConversion.convertUiDate(dateofrealise[i]));
                    }

                    pstmt.addBatch();
                }


                int[] rowsAffected = pstmt.executeBatch();

                conn.commit();

                if (rowsAffected.length > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
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

    public ResultVO insertUserOffiService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;


        try {
            if (null != employeeInfoVO) {
                String dateofjoining = DateConversion.convertUiDate(employeeInfoVO.getDateofjoining());
                int status = Integer.parseInt(employeeInfoVO.getStatus());
                String employeetype = employeeInfoVO.getEmployeetype();
                int grade = Integer.parseInt(employeeInfoVO.getGrade());
                int deputedlocation = Integer.parseInt(employeeInfoVO.getDeputedlocation());
                int baselocation = Integer.parseInt(employeeInfoVO.getBaselocation());
                int supervisorId = Integer.parseInt(employeeInfoVO.getSupervisorId());
                int parentIouId = Integer.parseInt(employeeInfoVO.getParentIouId());
                int subIouId = Integer.parseInt(employeeInfoVO.getSubIouId());
                int employee_id = Integer.parseInt(employeeInfoVO.getEmployeeId());
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "insert into employee_office_details values(" + employee_id + ",'" + dateofjoining + "'," + status + "," + grade + ",'" + employeetype + "'," + deputedlocation + "," + baselocation + "," + supervisorId + "," + parentIouId + "," + subIouId + ")";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO insertUserFinanService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;


        try {
            if (null != employeeInfoVO) {
                String pannumber = employeeInfoVO.getPannumber();
                String primarybankacc = employeeInfoVO.getPrimarybankacc();
                String secondarybankacc = employeeInfoVO.getSecondarybankacc();
                int employee_id = Integer.parseInt(employeeInfoVO.getEmployeeId());
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "insert into employee_account_details values(" + employee_id + ",'" + pannumber + "','" + primarybankacc + "','" + secondarybankacc + "')";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO passwordManageService(EmployeeInfoVO employeeInfoVO) {
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn = dbConnectionDaoImpl.dbConnect();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt_update = null;
        ResultVO resultVO = new ResultVO();
        try {
            String curpass = employeeInfoVO.getCurpass();
            String newpass = employeeInfoVO.getNewpass();
            String retypepass = employeeInfoVO.getRetypepass();
            if (newpass.equals(retypepass)) {
                int userid = employeeInfoVO.getUserid();
                String sqlQuery = "select user_password from user_profile where user_id=?";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, userid);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    if (curpass.equals(rs.getString(1))) {
                        String sqlQuery_update = "update user_profile set user_password=? where user_id=?";
                        pstmt_update = conn.prepareStatement(sqlQuery_update);
                        pstmt_update.setString(1, newpass);
                        pstmt_update.setInt(2, userid);
                        int rows = pstmt_update.executeUpdate();
                        if (rows > 0) {
                            resultVO.setMessage("Your Password Update Successful");
                        }
                    } else {
                        resultVO.setMessage("Your Current Password Not Match With Your Password ");
                    }

                }
            } else {
                resultVO.setMessage("Your New Password Not Match With Retype Password ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public StringBuilder viewEmployeeEmailIds() {
        StringBuilder stringBuilder = new StringBuilder();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select email_id from employee_personal_details";
            pstmt = conn.prepareStatement(sqlQuery);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                stringBuilder.append(rs.getString("email_id"));
                stringBuilder.append(",");
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
                if (null != rs) {
                    rs.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(" Message : " + sqlException.getMessage());
            }
        }
        return stringBuilder;
        //return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public EmployeeInfoVO viewEmployeeAccountInfo(int id) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select * from employee_account_details where employee_id=" + id;
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);

            while (rs.next()) {

                employeeInfoVO.setPannumber(rs.getString(2));
                employeeInfoVO.setPrimarybankacc(rs.getString(3));
                employeeInfoVO.setSecondarybankacc(rs.getString(4));

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return employeeInfoVO;
    }

    public ResultVO UpdateEmployeeAccountInfo(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();

        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            int id = employeeInfoVO.getUserid();
            String pannumber = employeeInfoVO.getPannumber();
            String primAccDetails = employeeInfoVO.getPrimarybankacc();
            String seconAccDetails = employeeInfoVO.getSecondarybankacc();
            String sqlQuery = "update employee_account_details set pan_number='" + pannumber + "',primary_bank_accout_no='" + primAccDetails + "',secondary_bank_account_no='" + seconAccDetails + "' where employee_id=" + id;
            int rowsEffected = st.executeUpdate(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);

            if (rowsEffected > 0) {
                resultVO.setMessage("Data Update Sucesfully");
                resultVO.setIsflag(true);
            } else {
                resultVO.setMessage("Data Is Not Update");
                resultVO.setIsflag(false);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return resultVO;
    }

    public EmployeeInfoVO viewEmpPersDet(int id) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select epd.address,epd.location_id,epd.pin,epd.phone,epd.alternate_phone,epd.marital_status,epd.country_id,epd.email_id,epd.date_of_birth,epd.gender from employee_personal_details epd,location_details ld,country_details cd where ld.location_id=epd.location_id and cd.country_code=epd.country_id and epd.employee_id=" + id;
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);

            while (rs.next()) {

                employeeInfoVO.setAddress(rs.getString(1));
                employeeInfoVO.setLocation_id(rs.getString(2));
                employeeInfoVO.setPin(rs.getString(3));
                employeeInfoVO.setPhone(rs.getString(4));
                employeeInfoVO.setAltphone(rs.getString(5));
                employeeInfoVO.setMaritalstatus(rs.getString(6));
                employeeInfoVO.setCountry_id(rs.getString(7));
                employeeInfoVO.setEmailid(rs.getString(8));
                employeeInfoVO.setDateofbirth(DateConversion.convertDbDate(rs.getString(9)));
                employeeInfoVO.setGender(rs.getString(10));

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return employeeInfoVO;
    }

    public ResultVO UpdateEmployeePersInfo(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        //Pattern pattern = Pattern.compile("[a-zA-Z]");


        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            int id = employeeInfoVO.getUserid();
            String address = employeeInfoVO.getAddress();
            String location_id = employeeInfoVO.getLocation_id();
            String pin = employeeInfoVO.getPin();
            String phone = employeeInfoVO.getPhone();
            String altnumber = employeeInfoVO.getAltphone();
            String maritalstatus = employeeInfoVO.getMaritalstatus();
            String country_id = employeeInfoVO.getCountry_id();
            //  Matcher matcher = pattern.matcher(location_id);
            //Matcher matcher_country = pattern.matcher(country_id);
            String email_id = employeeInfoVO.getEmailid();
            String dateofbirth = DateConversion.convertUiDate(employeeInfoVO.getDateofbirth());
            String gender = employeeInfoVO.getGender();
            //  System.out.println("Location"+matcher.find()+"   country"+matcher_country.find());
           /* if (!matcher.find() && !matcher_country.find()) {
             String sqlQuery = "update employee_personal_details set address='" + address + "',pin='" + pin + "',phone='" + phone + "',alternate_phone='" + altnumber + "',marital_status='" + maritalstatus + "',location_id='" + location_id + "',country_id='" + country_id + "',email_id='" + email_id + "' where employee_id=" + id;
               
             System.out.println(" Test Query : " + sqlQuery);
             int rowsEffected = st.executeUpdate(sqlQuery);
             //System.out.println(" Test Query : " + sqlQuery);

             if (rowsEffected > 0) {
             resultVO.setMessage("Data Update Sucesfully");
             resultVO.setIsflag(true);
             } else {
             resultVO.setMessage("Data Is Not Update");
             resultVO.setIsflag(false);
             }

             } else if (!matcher.find()) {
             String sqlQuery = "update employee_personal_details set address='" + address + "',pin='" + pin + "',phone='" + phone + "',alternate_phone='" + altnumber + "',marital_status='" + maritalstatus + "',location_id='" + location_id + "',email_id='" + email_id + "' where employee_id=" + id;
             System.out.println(" Test Query : " + sqlQuery);
             int rowsEffected = st.executeUpdate(sqlQuery);
             //System.out.println(" Test Query : " + sqlQuery);

             if (rowsEffected > 0) {
             resultVO.setMessage("Data Update Sucesfully");
             resultVO.setIsflag(true);
             } else {
             resultVO.setMessage("Data Is Not Update");
             resultVO.setIsflag(false);
             }

             } else if (!matcher_country.find()) {
             String sqlQuery = "update employee_personal_details set address='" + address + "',pin='" + pin + "',phone='" + phone + "',alternate_phone='" + altnumber + "',marital_status='" + maritalstatus + "',country_id='" + country_id + "',email_id='" + email_id + "' where employee_id=" + id;
             System.out.println(" Test Query : " + sqlQuery);
             int rowsEffected = st.executeUpdate(sqlQuery);
             //System.out.println(" Test Query : " + sqlQuery);

             if (rowsEffected > 0) {
             resultVO.setMessage("Data Update Sucesfully");
             resultVO.setIsflag(true);
             } else {
             resultVO.setMessage("Data Is Not Update");
             resultVO.setIsflag(false);
             }

             } */
            String sqlQuery = "update employee_personal_details set address='" + address + "',pin='" + pin + "',phone='" + phone + "',alternate_phone='" + altnumber + "',marital_status='" + maritalstatus + "',email_id='" + email_id + "',location_id='" + location_id + "',country_id='" + country_id + "',date_of_birth='" + dateofbirth + "',gender='" + gender + "' where employee_id=" + id;
            System.out.println(" Test Query : " + sqlQuery);
            int rowsEffected = st.executeUpdate(sqlQuery);
            //System.out.println(" Test Query : " + sqlQuery);

            if (rowsEffected > 0) {
                resultVO.setMessage("Data Update Sucesfully");
                resultVO.setIsflag(true);
            } else {
                resultVO.setMessage("Data Is Not Update");
                resultVO.setIsflag(false);
            }


        } catch (Exception e) {
            e.getMessage();
        }
        return resultVO;
    }

    public EmployeeInfoVO viewEmpEduDet(int id) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select * from employee_education_details where employee_id=" + id;
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);

            while (rs.next()) {
                employeeInfoVO.setUg_qualification(rs.getString(2));
                employeeInfoVO.setUg_specialization(rs.getString(3));
                employeeInfoVO.setUg_passout(rs.getString(4));
                employeeInfoVO.setUg_university(rs.getString(5));
                //if(!rs.getString(5).equals("1")){
                employeeInfoVO.setPg_qualification(rs.getString(6));
                // }

                //if(!rs.getString(7).equals("1")){
                employeeInfoVO.setPg_specialization(rs.getString(7));
                //}

                employeeInfoVO.setPg_passout(rs.getString(8));
                employeeInfoVO.setPg_university(rs.getString(9));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return employeeInfoVO;
    }

    public ResultVO updateEmpEduService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String employeeid = null;
        int pg_qualification = 0;
        int pg_specialization = 0;
        int pg_university = 0;
        try {
            if (null != employeeInfoVO) {
                int ug_qualification = Integer.parseInt(employeeInfoVO.getUg_qualification());
                System.out.println("ug university" + ug_qualification);
                int ug_specialization = Integer.parseInt(employeeInfoVO.getUg_specialization());
                System.out.println("ug university" + ug_specialization);
                String ug_passout = employeeInfoVO.getUg_passout();
                int ug_university = Integer.parseInt(employeeInfoVO.getUg_university());
                System.out.println("ug university" + ug_university);
                pg_qualification = Integer.parseInt(employeeInfoVO.getPg_qualification());
                pg_specialization = Integer.parseInt(employeeInfoVO.getPg_specialization());
                pg_university = Integer.parseInt(employeeInfoVO.getPg_university());
                String pg_passout = employeeInfoVO.getPg_passout();
                int employee_id = employeeInfoVO.getUserid();
                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "update employee_education_details set ug_qualification=" + ug_qualification + ",ug_specialization=" + ug_specialization + ",ug_year_of_passout='" + ug_passout + "',ug_university=" + ug_university + ",pg_qualification=" + pg_qualification + ",pg_specialization=" + pg_specialization + ",pg_year_of_passout='" + pg_passout + "',pg_university=" + pg_university + " where employee_id=" + employee_id;
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data inserted");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public EmployeeInfoVO viewEmpOffDet(int id) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        try {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn = dbConnectionDaoImpl.dbConnect();
            Statement st = conn.createStatement();
            String sqlQuery = "select * from employee_office_details where employee_id=" + id;
            ResultSet rs = st.executeQuery(sqlQuery);
            System.out.println(" Test Query : " + sqlQuery);

            while (rs.next()) {
                employeeInfoVO.setDateofjoining(DateConversion.convertDbDate(rs.getString(2)));
                employeeInfoVO.setStatus(rs.getString(3));
                employeeInfoVO.setGrade(rs.getString(4));
                employeeInfoVO.setEmployeetype(rs.getString(5));
                employeeInfoVO.setDeputedlocation(rs.getString(6));
                employeeInfoVO.setBaselocation(rs.getString(7));
                employeeInfoVO.setSupervisorId(rs.getString(8));
                employeeInfoVO.setParentIouId(rs.getString(9));
                employeeInfoVO.setSubIouId(rs.getString(10));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return employeeInfoVO;
    }

    public ResultVO updateEmpOffiService(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;


        try {
            if (null != employeeInfoVO) {
                String dateofjoining = DateConversion.convertUiDate(employeeInfoVO.getDateofjoining());
                int status = Integer.parseInt(employeeInfoVO.getStatus());
                int employee_id = employeeInfoVO.getUserid();
                int grade = Integer.parseInt(employeeInfoVO.getGrade());
                int deputedlocation = Integer.parseInt(employeeInfoVO.getDeputedlocation());
                int baselocation = Integer.parseInt(employeeInfoVO.getBaselocation());
                int supervisorId = Integer.parseInt(employeeInfoVO.getSupervisorId());
                int parentIouId = Integer.parseInt(employeeInfoVO.getParentIouId());
                int subIouId = Integer.parseInt(employeeInfoVO.getSubIouId());
                String employeetype = employeeInfoVO.getEmployeetype();

                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();
                String sqlQuery = "update employee_office_details set date_of_joining='" + dateofjoining + "',employee_status=" + status + ",grade_id=" + grade + ",employee_type='" + employeetype + "',deputed_location_id=" + deputedlocation + ",base_branch_id=" + baselocation + ",supervisor_id=" + supervisorId + ",parent_iou_id=" + parentIouId + ",sub_iou_id=" + subIouId + " where employee_id=" + employee_id;
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = st.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {
                    resultVO.setIsflag(true);
                    System.out.println("Data Update Successfully");
                } else {
                    resultVO.setIsflag(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    public List<StatusReportVO> viewEmpStatusReport(String date, String emloyeeId) {
        List<StatusReportVO> list = new ArrayList<StatusReportVO>();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn = dbConnectionDaoImpl.dbConnect();



        try {

            String dateStatus = DateConversion.convertUiDate(date);
            int empId = Integer.parseInt(emloyeeId);
            String sqlQuery = "select * from daily_status_report where status_report_date=? and user_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, dateStatus);
            pstmt.setInt(2, empId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (0 == rs.getInt("status")) {
                    StatusReportVO statusReportVO = new StatusReportVO();
                    statusReportVO.setStatusReportId(rs.getInt("daily_status_report_id"));
                    statusReportVO.setResourceId(rs.getInt("user_id"));
                    statusReportVO.setStatusReportDescription(rs.getString("status_report_description"));
                    statusReportVO.setBillableHours(rs.getString("billable_hours"));
                    statusReportVO.setNonBillableHours(rs.getString("non_billable_hours"));
                    list.add(statusReportVO);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<StatusReportVO> viewMyStatusReport(String date, int emloyeeId) {
        List<StatusReportVO> list = new ArrayList<StatusReportVO>();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn = dbConnectionDaoImpl.dbConnect();



        try {

            String dateStatus = DateConversion.convertUiDate(date);

            String sqlQuery = "select * from daily_status_report where status_report_date=? and user_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, dateStatus);
            pstmt.setInt(2, emloyeeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StatusReportVO statusReportVO = new StatusReportVO();
                statusReportVO.setResourceId(rs.getInt("user_id"));
                statusReportVO.setStatusReportDescription(rs.getString("status_report_description"));
                statusReportVO.setBillableHours(rs.getString("billable_hours"));
                statusReportVO.setNonBillableHours(rs.getString("non_billable_hours"));
                if (0 == rs.getInt("status")) {
                    statusReportVO.setStatus("Pending");
                } else if (1 == rs.getInt("status")) {
                    statusReportVO.setStatus("Active");
                } else {
                    statusReportVO.setStatus("Rejected");
                }

                list.add(statusReportVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<StatusReportVO> activateEmpStatusReport(StatusReportVO reportVO) {
        List<StatusReportVO> list = new ArrayList<StatusReportVO>();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn = dbConnectionDaoImpl.dbConnect();
        int empId = reportVO.getResourceId();
        String employeeId = (String.valueOf(empId));
        int statusReportId = reportVO.getStatusReportId();
        String date = reportVO.getDate();



        try {

            String sqlQuery = "UPDATE daily_status_report SET status=1 WHERE daily_status_report_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, statusReportId);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
                list = employeeInformationServicesDaoImpl.viewEmpStatusReport(date, employeeId);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<StatusReportVO> rejectEmpStatusReport(StatusReportVO reportVO) {
        List<StatusReportVO> list = new ArrayList<StatusReportVO>();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn = dbConnectionDaoImpl.dbConnect();
        int empId = reportVO.getResourceId();
        String employeeId = (String.valueOf(empId));
        int statusReportId = reportVO.getStatusReportId();
        String date = reportVO.getDate();



        try {

            String sqlQuery = "UPDATE daily_status_report SET status=-1 WHERE daily_status_report_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, statusReportId);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
                list = employeeInformationServicesDaoImpl.viewEmpStatusReport(date, employeeId);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
