package com.tpcs.admin.taskmgt.dao.impl;

import com.tpcs.admin.hrmgt.vo.ContactNumberVO;
import com.tpcs.admin.hrmgt.vo.ContactVO;
import com.tpcs.admin.hrmgt.vo.IntervieweeVO;
import com.tpcs.admin.hrmgt.vo.RegTraineeVo;
import com.tpcs.admin.taskmgt.dao.TaskAssignmentServicesDao;
import com.tpcs.admin.taskmgt.util.DateConversion;
import com.tpcs.admin.taskmgt.vo.FileUploadVo;
import com.tpcs.admin.taskmgt.vo.NewsEventVO;
import com.tpcs.admin.taskmgt.vo.ResultVO;
import com.tpcs.admin.taskmgt.vo.SalaryVo;
import com.tpcs.admin.taskmgt.vo.StatusReportVO;
import com.tpcs.admin.taskmgt.vo.TaskAssignmentVO;
import com.tpcs.employeeinfo.vo.IntervieweeUtilVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class TaskAssignmentServicesDaoImpl implements TaskAssignmentServicesDao {

    private DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();

    public ResultVO storeTaskAssignment(TaskAssignmentVO taskAssignmentVO) {
        ResultVO resultVO = new ResultVO();
        Statement stmt = null;
        Connection conn = null;
        try {
            if (null != taskAssignmentVO) {
                int resourceId = taskAssignmentVO.getResourceId();
                int assignedByResourceId = taskAssignmentVO.getAssignedByResourceId();
                String categoryId = taskAssignmentVO.getTaskCategoryId();
                String taskDescription = taskAssignmentVO.getTaskDescription();
                String projectId = taskAssignmentVO.getProjectId();
                String targetDate = DateConversion.convertUiDate(taskAssignmentVO.getTaskTargetDate());
                String statusId = taskAssignmentVO.getTaskStatusId();
                conn = dbConnectionDaoImpl.dbConnect();
                stmt = conn.createStatement();

                String sqlQuery = "insert into task_assignment(task_assigned_by,task_resource_id,task_category_id,task_description,task_target_date,task_status_id,task_project_id)values(" + assignedByResourceId + "," + resourceId + ",'" + categoryId + "','" + taskDescription + "','" + targetDate + "','" + statusId + "','" + projectId + "')";
                int rowsAffected = stmt.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {

                    resultVO.setMessage("Value inserted");
                } else {
                    resultVO.setMessage("Value not inserted");
                }
            }
        } catch (Exception exception) {

        } finally {
            try {
                if (null != stmt) {
                    stmt.close();
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

    public ResultVO storeFutureTask(TaskAssignmentVO taskAssignmentVO) {
        ResultVO resultVO = new ResultVO();
        Statement stmt = null;
        Connection conn = null;
        try {
            if (null != taskAssignmentVO) {
                int resourceId = taskAssignmentVO.getResourceId();
                String tasktitle = taskAssignmentVO.getTasktitle();
                String taskdes = taskAssignmentVO.getTaskdes();
                String taskstartdate = DateConversion.convertUiDate(taskAssignmentVO.getTaskstartdate());
                String taskcompdate = DateConversion.convertUiDate(taskAssignmentVO.getTaskcompdate());
                String taskpriority = taskAssignmentVO.getTaskpriority();

                conn = dbConnectionDaoImpl.dbConnect();
                stmt = conn.createStatement();
                String sqlQuery = "insert into future_task(emp_id,task_title,task_des,task_stating_date,task_comp_date,task_priority) values(" + resourceId + ",'" + tasktitle + "','" + taskdes + "','" + taskstartdate + "','" + taskcompdate + "','" + taskpriority + "')";
                System.out.println(" Test Query : " + sqlQuery);
                int rowsAffected = stmt.executeUpdate(sqlQuery);
                if (rowsAffected > 0) {

                    resultVO.setMessage("Value inserted");
                } else {
                    resultVO.setMessage("Value not inserted");
                }
            }
        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());

        } finally {
            try {
                if (null != stmt) {
                    stmt.close();
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

    public ResultVO deleteFutureTask(int futureTaskId, int resourceId) {
        ResultVO resultVO = new ResultVO();
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            stmt = conn.createStatement();
            String sqlQuery = "delete from future_task where future_task_id=" + futureTaskId;
            int rowsAffected = stmt.executeUpdate(sqlQuery);
            if (rowsAffected > 0) {
                resultVO.setMessage("Data Is Deleted");
                TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
                List<TaskAssignmentVO> list = taskAssignmentServicesDaoImpl.populateFutureTaskReports(resourceId);
                resultVO.setList(list);
            } else {
                resultVO.setMessage("Data Is not Deleted");
            }
        } catch (SQLException sqlException) {
        }

        return resultVO;
    }

    public List<TaskAssignmentVO> populateFutureTaskReports(int employeeId) {
        List<TaskAssignmentVO> listOfTaskReport = new ArrayList<TaskAssignmentVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            if (employeeId > 0) {
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "select * from future_task where emp_id = ? ";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, employeeId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();
                    taskAssignmentVO.setFutureTaskId(rs.getInt("future_task_id"));
                    taskAssignmentVO.setTasktitle(rs.getString("task_title"));
                    taskAssignmentVO.setTaskdes(rs.getString("task_des"));
                    taskAssignmentVO.setTaskstartdate(DateConversion.convertDbDate(rs.getString("task_stating_date")));
                    taskAssignmentVO.setTaskcompdate(DateConversion.convertDbDate(rs.getString("task_comp_date")));
                    taskAssignmentVO.setTaskpriority(rs.getString("task_priority"));
                    listOfTaskReport.add(taskAssignmentVO);
                }
            }
        } catch (Exception exception) {
        } finally {
            try {
                if (null != pstmt) {
                    pstmt.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
            }
        }
        return listOfTaskReport;
    }

    public List<TaskAssignmentVO> populateTaskAssignmentList(int resourceId) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        List<TaskAssignmentVO> listOfAssignedTaskList = new ArrayList<TaskAssignmentVO>();
        if (resourceId > 0) {
            try {
                String sqlQuery = "select  ta.task_id, ta.task_assigned_by, ta.task_resource_id,up.user_name ,ta.task_category_id,tc.task_category_name,ta.task_description,ta.task_target_date,ta.task_status_id,ts.task_status_name,ta.task_project_id,tp.task_project_name,ta.task_closing_date from task_assignment  ta ,user_profile up, task_category tc,task_status ts ,task_project tp where ta.task_category_id = tc.task_category_id  and ta.task_status_id =ts.task_status_id and  ta.task_project_id = tp.task_project_id and ta.task_resource_id=up.user_id and  ta.task_resource_id = ?";
                System.out.println(" sqlQuery : --------->  " + sqlQuery);
                conn = dbConnectionDaoImpl.dbConnect();
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, resourceId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();
                    taskAssignmentVO.setTaskId(rs.getString("task_id"));
                    taskAssignmentVO.setResourceId(rs.getInt("task_resource_id"));
                    taskAssignmentVO.setResourceName(rs.getString("user_name"));
                    taskAssignmentVO.setTaskCategoryId(rs.getString("task_category_id"));
                    taskAssignmentVO.setTaskCategoryName(rs.getString("task_category_name"));
                    taskAssignmentVO.setTaskDescription(rs.getString("task_description"));
                    taskAssignmentVO.setTaskTargetDate(DateConversion.convertDbDate(rs.getString("task_target_date")));
                    taskAssignmentVO.setTaskStatusId(rs.getString("task_status_id"));
                    taskAssignmentVO.setStatusName(rs.getString("task_status_name"));
                    taskAssignmentVO.setProjectId(rs.getString("task_project_id"));
                    taskAssignmentVO.setProjectName(rs.getString("task_project_name"));
                    taskAssignmentVO.setClosingDate(rs.getString("task_closing_date"));
                    int assignedBy = rs.getInt("task_assigned_by");
                    System.out.println(" Assigned By :----------> " + assignedBy);
                    String sqlQuery001 = "select user_call_name as assigned_by from user_profile where user_id =?";
                    PreparedStatement ptmt = conn.prepareStatement(sqlQuery001);
                    ptmt.setInt(1, assignedBy);
                    ResultSet rst = ptmt.executeQuery();
                    if (rst.next()) {
                        taskAssignmentVO.setAssignedByResourceName(rst.getString("assigned_by"));
                    }
                    listOfAssignedTaskList.add(taskAssignmentVO);
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
        }
        return listOfAssignedTaskList;
    }

    public ResultVO storeStatusReport(StatusReportVO statusReportVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != statusReportVO) {
                String[] statusReport = statusReportVO.getSubmitstatusreport();
                String billableHours = statusReportVO.getBillableHours();
                String nonBillableHours = statusReportVO.getNonBillableHours();
                int resourceId = statusReportVO.getResourceId();
                for (int i = 0; i < statusReport.length; i++) {

                    System.out.println("statusReport" + statusReport[i]);
                }
                conn = dbConnectionDaoImpl.dbConnect();
                int rowsAffected = 0;
                Statement st = conn.createStatement();
                for (int i = 0; i < statusReport.length; i++) {

                    String sqlQuery = "insert into daily_status_report(status_report_description,status_report_date,user_id,billable_hours,non_billable_hours,status)values(?,curdate(),?,?,?,0)";
                    pstmt = conn.prepareStatement(sqlQuery);
                    pstmt.setString(1, statusReport[i]);
                    pstmt.setInt(2, resourceId);
                    pstmt.setString(3, billableHours);
                    pstmt.setString(4, nonBillableHours);
                    rowsAffected = pstmt.executeUpdate();
                }
                if (rowsAffected > 0) {
                    String associateName = "";
                    resultVO.setMessage("Status Report Submitted.");
                    //CyberMailService cyberMailService = new CyberMailService();
                    //cyberMailService.sendEmail(associateName);
                } else {
                    resultVO.setMessage("Status Report Submission failed. ");
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

    public List<StatusReportVO> populateDailyStatusReports(int employeeId) {
        List<StatusReportVO> listOfStatusReport = new ArrayList<StatusReportVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            if (employeeId > 0) {
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "select daily_status_report_id, status_report_date ,status_report_description from daily_status_report where user_id = ? order by status_report_date desc";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, employeeId);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    StatusReportVO statusReportVO = new StatusReportVO();
                    statusReportVO.setStatusReportId(rs.getInt("daily_status_report_id"));
                    statusReportVO.setStatusReportDescription(rs.getString("status_report_description"));
                    statusReportVO.setStatusReportDate(DateConversion.convertDbDate(rs.getString("status_report_date")));
                    listOfStatusReport.add(statusReportVO);
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
        return listOfStatusReport;
    }

    public ResultVO storeContactNumber(ContactNumberVO contactNumberVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != contactNumberVO) {
                String name = contactNumberVO.getName();
                String category = contactNumberVO.getCategory();
                String contactNumber = contactNumberVO.getContactNumber();
                String nickName = contactNumberVO.getNickName();
                String alternateNumber = contactNumberVO.getAlternateNumber();
                String emailId = contactNumberVO.getEmailId();
                String alternateEmailId = contactNumberVO.getAlternateEmailId();
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "insert into associates_contact_number(asssociate_name,associate_category,associate_contact_number,associate_nick_name,associate_alternate_number,associate_email_id,associate_alternate_email_id)values(?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, category);
                pstmt.setString(3, contactNumber);
                pstmt.setString(4, nickName);
                pstmt.setString(5, alternateNumber);
                pstmt.setString(6, emailId);
                pstmt.setString(7, alternateEmailId);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    resultVO.setMessage("Contact Number Submitted.");
                } else {
                    resultVO.setMessage("Contact Number Submission failed. ");
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
    /*
     * This method implemented by 
     * @TPCS_PL Chandan 109(16.06.2013)
     */

    public ResultVO intervieweeUtils() {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<IntervieweeUtilVO> listOfQualification = new ArrayList<IntervieweeUtilVO>();
        List<IntervieweeUtilVO> listOfUniversity = new ArrayList<IntervieweeUtilVO>();
        List<IntervieweeUtilVO> listOfKeySkills = new ArrayList<IntervieweeUtilVO>();
        List<IntervieweeUtilVO> listOfProfile = new ArrayList<IntervieweeUtilVO>();
        conn = dbConnectionDaoImpl.dbConnect();
        try {
            pstmt = conn.prepareStatement("select ug_qualification_id,ug_qualification from ug_qualification");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                IntervieweeUtilVO intervieweeUtilVO = new IntervieweeUtilVO();
                intervieweeUtilVO.setPrimaryId(resultSet.getString(1));
                intervieweeUtilVO.setAcademicQualification(resultSet.getString(2));
                listOfQualification.add(intervieweeUtilVO);
            }
            resultVO.setListOfQualification(listOfQualification);
            resultSet.close();
            pstmt.close();
            pstmt = conn.prepareStatement("select university_institute_id,university_institute_name from university_institute");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                IntervieweeUtilVO intervieweeUtilVO = new IntervieweeUtilVO();
                intervieweeUtilVO.setPrimaryId(resultSet.getString(1));
                intervieweeUtilVO.setInstituteName(resultSet.getString(2));
                listOfUniversity.add(intervieweeUtilVO);
            }
            resultVO.setListOfUniversity(listOfUniversity);
            resultSet.close();
            pstmt.close();
            pstmt = conn.prepareStatement("select interview_skills_name from interview_key_skills");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                IntervieweeUtilVO intervieweeUtilVO = new IntervieweeUtilVO();
                intervieweeUtilVO.setKeySkills(resultSet.getString(1));
                listOfKeySkills.add(intervieweeUtilVO);
            }
            resultVO.setListOfKeySkills(listOfKeySkills);
            resultSet.close();
            pstmt.close();
            pstmt = conn.prepareStatement("select interview_profile_id,interview_profile_name from interview_applyed_profile");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                IntervieweeUtilVO intervieweeUtilVO = new IntervieweeUtilVO();
                intervieweeUtilVO.setPrimaryId(resultSet.getString(1));
                intervieweeUtilVO.setProfileApplied(resultSet.getString(2));
                listOfProfile.add(intervieweeUtilVO);
            }
            resultVO.setListOfProfile(listOfProfile);
        } catch (SQLException sqle) {
        } finally {
            dbConnectionDaoImpl.dbClose(resultSet, pstmt, conn);
        }
        return resultVO;
    }

    /*
     * These methods implemented by 
     * @TPCS_PL Chandan 109(16.06.2013)
     */
    private int addInstitution(Connection conn, String institution) throws SQLException {
        PreparedStatement pstmt = null;
        int maxUniversityId = 0;
        if (institution.length() > 2) {
            pstmt = conn.prepareStatement("select max(university_institute_id) from university_institute");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                maxUniversityId = 1 + rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("insert into  university_institute(university_institute_id,university_institute_name) values(?,?)");
            pstmt.setInt(1, maxUniversityId);
            pstmt.setString(2, institution);
            pstmt.executeUpdate();
            pstmt.close();
        }
        return maxUniversityId;
    }

    private int addQualification(Connection conn, String qualification) throws SQLException {
        PreparedStatement pstmt = null;
        int maxQualificationId = 0;
        if (qualification.length() > 2) {
            pstmt = conn.prepareStatement("select max(ug_qualification_id) from ug_qualification");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maxQualificationId = 1 + rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("insert into ug_qualification(ug_qualification_id,ug_qualification) values(?,?)");
            pstmt.setInt(1, maxQualificationId);
            pstmt.setString(2, qualification);
            pstmt.executeUpdate();
            pstmt.close();
        }
        return maxQualificationId;
    }

    private int addKeySkills(Connection conn, String keySkills) throws SQLException {
        PreparedStatement pstmt = null;
        int maxKeySkillsId = 0;
        if (keySkills.length() > 2) {
            pstmt = conn.prepareStatement("select max(interview_skills_id) from interview_key_skills");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                maxKeySkillsId = 1 + rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("insert into interview_key_skills(interview_skills_id,interview_skills_name)values(?,?)");
            pstmt.setInt(1, maxKeySkillsId);
            pstmt.setString(2, keySkills);
            pstmt.executeUpdate();
            pstmt.close();
        }
        return maxKeySkillsId;
    }

    private int addProfile(Connection conn, String profile) throws SQLException {
        PreparedStatement pstmt = null;
        int maxProfileId = 0;
        if (profile.length() > 2) {
            pstmt = conn.prepareStatement("select max(interview_profile_id) from interview_applyed_profile");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maxProfileId = 1 + rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            pstmt = conn.prepareStatement("insert into interview_applyed_profile(interview_profile_id,interview_profile_name) values(?,?)");
            pstmt.setInt(1, maxProfileId);
            pstmt.setString(2, profile);
            pstmt.executeUpdate();
            pstmt.close();
        }
        return maxProfileId;
    }

    private String sqlDateFormate(String date) {
        String formateDate = "0000-00-00";
        if (date.length() > 9) {
            StringTokenizer st = new StringTokenizer(date.replace('/', '-'));
            String dd = st.nextToken("-");
            String mm = st.nextToken("-");
            String yy = st.nextToken("-");
            formateDate = (yy + "-" + mm + "-" + dd);
            return formateDate;
        } else {
            return formateDate;
        }
    }
    /*
     * This method modyfied by 
     * @TPCS_PL Chandan 109(16.06.2013)
     */

    public ResultVO storeIntervieweeInfo(IntervieweeVO intervieweeVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            if (null != intervieweeVO) {
                String emailId = intervieweeVO.getEmailId();
                conn = dbConnectionDaoImpl.dbConnect();
                pstmt = conn.prepareStatement("select interviewee_sl_no,interviewee_name from interviewee_info where interviewee_email_id=?");
                pstmt.setString(1, emailId);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    resultVO.setMessage("Interviewee " + rs.getInt(2) + " already exist and id is: " + rs.getInt(1));
                    rs.close();
                    pstmt.close();
                } else {
                    String name = intervieweeVO.getName();
                    String contactNo = intervieweeVO.getContactNo();
                    String alternateEmailIds = intervieweeVO.getAlternateEmailId();
                    String qualification = intervieweeVO.getQualification();
                    String otherQualification = intervieweeVO.getOthersQualification();
                    String profileAppliedFor = intervieweeVO.getProfileApplied();
                    String otherPofileAppliedFor = intervieweeVO.getOtherPofileAppliedFor();
                    String institutename = intervieweeVO.getInstitutename();
                    String otherInstituteName = intervieweeVO.getOtherInstitutename();
                    String remarks = intervieweeVO.getRemarks();
                    String passoutyr = intervieweeVO.getPassoutyr();
                    String intervieweeExperience = intervieweeVO.getInterviewexperience();
                    String keySkills[] = intervieweeVO.getKeySkills();
                    String extraKeySkills = intervieweeVO.getExtraKeySkills();
                    String receiveCvDate = intervieweeVO.getReceiveCvDate();
                    String interviewStatus = intervieweeVO.getInterviewStatus();
                    String interviewStatusDate = intervieweeVO.getInterviewStatusDate();
                    pstmt = conn.prepareStatement("select max(interviewee_sl_no) from interviewee_info");
                    rs = pstmt.executeQuery();
                    int maxIntervieweeId = 0;
                    if (rs.next()) {
                        maxIntervieweeId = 1 + rs.getInt(1);
                    }
                    rs.close();
                    pstmt.close();
                    int insId = Integer.parseInt(institutename);
                    if (institutename.equals("00")) {
                        insId = addInstitution(conn, otherInstituteName);
                    }
                    if (!extraKeySkills.equals("")) {
                        addKeySkills(conn, extraKeySkills);
                    }
                    StringBuilder totalSkills = new StringBuilder();
                    for (String skills : keySkills) {
                        totalSkills.append(skills).append(",");
                    }
                    String skills = totalSkills.append(extraKeySkills).toString();
                    int profileId = Integer.parseInt(profileAppliedFor);
                    if (profileAppliedFor.equals("00")) {
                        profileId = addProfile(conn, otherPofileAppliedFor);
                    }
                    int qualificationId = Integer.parseInt(qualification);
                    if (qualification.equals("00")) {
                        qualificationId = addQualification(conn, otherQualification);
                    }
                    String sqlQuery = "insert into interviewee_info(interviewee_sl_no,interviewee_email_id,interviewee_name,interviewee_contact_no,interviewee_applied_for_id,interviewee_academic_qualification_id,interviewee_key_skils,interviewee_status,interviewee_status_date,intervieweee_remarks,interviewee_alternate_email_id,pass_out_yr,institute_interview_id,interview_exp,cv_receive_date,add_to_our_system_date) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
                    pstmt = conn.prepareStatement(sqlQuery);
                    pstmt.setInt(1, maxIntervieweeId);
                    pstmt.setString(2, emailId);
                    pstmt.setString(3, name);
                    pstmt.setString(4, contactNo);
                    pstmt.setInt(5, profileId);
                    pstmt.setInt(6, qualificationId);
                    pstmt.setString(7, skills);
                    pstmt.setString(8, interviewStatus);
                    pstmt.setString(9, sqlDateFormate(interviewStatusDate));
                    pstmt.setString(10, remarks);
                    pstmt.setString(11, alternateEmailIds);
                    pstmt.setString(12, sqlDateFormate(passoutyr));
                    pstmt.setInt(13, insId);
                    pstmt.setString(14, intervieweeExperience);
                    pstmt.setString(15, sqlDateFormate(receiveCvDate));
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        resultVO.setMessage("Interviewee Profile Submitted.");
                    } else {
                        resultVO.setMessage("Intervieww Profile Submission failed.");
                    }
                }
            } else {
                resultVO.setMessage("Intervieww Profile Submission failed.");
            }
        } catch (SQLException exception) {
        } finally {
            dbConnectionDaoImpl.dbClose(pstmt, conn);
        }
        return resultVO;
    }

    public List<ContactNumberVO> viewContactDetails() {
        List<ContactNumberVO> listOfContactNumberVO = new ArrayList<ContactNumberVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from associates_contact_number";
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ContactNumberVO contactNumberVO = new ContactNumberVO();
                contactNumberVO.setName(rs.getString("asssociate_name"));
                contactNumberVO.setAlternateEmailId(rs.getString("associate_alternate_email_id"));
                contactNumberVO.setAlternateNumber(rs.getString("associate_alternate_number"));
                contactNumberVO.setCategory(rs.getString("associate_category"));
                contactNumberVO.setContactNumber(rs.getString("associate_contact_number"));
                contactNumberVO.setEmailId(rs.getString("associate_email_id"));
                contactNumberVO.setNickName(rs.getString("associate_nick_name"));
                listOfContactNumberVO.add(contactNumberVO);
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
        return listOfContactNumberVO;
    }
    /*
     * This method modyfied by 
     * @TPCS_PL Chandan 109(19.06.2013)
     */

    public List<IntervieweeVO> viewIntervieweeInfo() {
        List<IntervieweeVO> listOfIntervieweeVO = new ArrayList<IntervieweeVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select interviewee_sl_no,interviewee_name,interviewee_contact_no,interviewee_email_id,interviewee_alternate_email_id,ug_qualification,university_institute_name,pass_out_yr,interview_profile_name,cv_receive_date from ug_qualification,university_institute,interviewee_info,interview_applyed_profile where interviewee_applied_for_id=interview_profile_id and institute_interview_id = university_institute_id and interviewee_academic_qualification_id = ug_qualification_id order by cv_receive_date desc";
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                IntervieweeVO intervieweeVO = new IntervieweeVO();
                intervieweeVO.setIntervieweeSlNo(rs.getInt("interviewee_sl_no"));
                intervieweeVO.setName(rs.getString("interviewee_name"));
                intervieweeVO.setContactNo(rs.getString("interviewee_contact_no"));
                intervieweeVO.setEmailId(rs.getString("interviewee_email_id"));
                intervieweeVO.setAlternateEmailId(rs.getString("interviewee_alternate_email_id"));
                intervieweeVO.setQualification(rs.getString("ug_qualification"));
                intervieweeVO.setInterviewUniversity(rs.getString("university_institute_name"));
                intervieweeVO.setPassoutyr(rs.getString("pass_out_yr"));
                intervieweeVO.setProfileAppliedFor(rs.getString("interview_profile_name"));
                intervieweeVO.setReceiveDate(rs.getString("cv_receive_date"));
                listOfIntervieweeVO.add(intervieweeVO);
            }
        } catch (Exception exception) {
        } finally {
            dbConnectionDaoImpl.dbClose(rs, pstmt, conn);
        }
        return listOfIntervieweeVO;
    }

    public StringBuilder viewIntervieweeEmailIds() {
        StringBuilder stringBuilder = new StringBuilder();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select interviewee_email_id from interviewee_info";
            pstmt = conn.prepareStatement(sqlQuery);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                stringBuilder.append(rs.getString("interviewee_email_id"));
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

    public IntervieweeVO viewIndividualIntervieweeInfo(String emailId) {
        IntervieweeVO intervieweeVO = new IntervieweeVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from interviewee_info where interviewee_email_id = ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, emailId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                intervieweeVO.setAlternateEmailId(rs.getString("interviewee_alternate_email_id"));
                intervieweeVO.setCallFollowUp(rs.getString("interviewee_call_followup_status"));
                intervieweeVO.setContactNo(rs.getString("interviewee_contact_no"));
                intervieweeVO.setEmailId(rs.getString("interviewee_email_id"));
                intervieweeVO.setInterviewStatus(rs.getString("interviewee_status"));
                intervieweeVO.setOhterKeySkills(rs.getString("interviewee_key_skils"));
                intervieweeVO.setName(rs.getString("interviewee_name"));
                intervieweeVO.setProfileAppliedFor(rs.getString("interviewee_applied_for"));
                intervieweeVO.setQualification(rs.getString("interviewee_academic_qualification"));
                intervieweeVO.setRemarks(rs.getString("intervieweee_remarks"));
                intervieweeVO.setPassoutyr(rs.getString("pass_out_yr"));
                intervieweeVO.setInstitutename(rs.getString("institute_name"));
                intervieweeVO.setInterviewexperience(rs.getString("interview_exp"));
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
        return intervieweeVO;
    }

    public ResultVO updateIntervieweeInfo(IntervieweeVO intervieweeVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != intervieweeVO) {
                String name = intervieweeVO.getName();
                String callFollowUp = intervieweeVO.getCallFollowUp();
                String contactNo = intervieweeVO.getContactNo();
                String emailId = intervieweeVO.getEmailId();
                String interviewStatus = intervieweeVO.getInterviewStatus();
                String keySkills = intervieweeVO.getOhterKeySkills();
                String profileAppliedFor = intervieweeVO.getProfileAppliedFor();
                String qualification = intervieweeVO.getQualification();
                String remarks = intervieweeVO.getRemarks();
                String alternateEmailIds = intervieweeVO.getAlternateEmailId();
                String passoutyr = intervieweeVO.getPassoutyr();
                String institutename = intervieweeVO.getInstitutename();
                String interviewexperience = intervieweeVO.getInterviewexperience();
                System.out.println("passout yr" + passoutyr + "Institute Name" + institutename);
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "update interviewee_info set interviewee_name=? ,interviewee_contact_no=?, interviewee_applied_for =? , interviewee_academic_qualification=?,interviewee_key_skils = ?, interviewee_status =?,interviewee_call_followup_status =?,intervieweee_remarks=?, interviewee_alternate_email_id=?, pass_out_yr=?, institute_name=?, interview_exp=? where interviewee_email_id = ?";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, contactNo);
                pstmt.setString(3, profileAppliedFor);
                pstmt.setString(4, qualification);
                pstmt.setString(5, keySkills);
                pstmt.setString(6, interviewStatus);
                pstmt.setString(7, callFollowUp);
                pstmt.setString(8, remarks);
                pstmt.setString(9, alternateEmailIds);

                pstmt.setString(10, passoutyr);
                pstmt.setString(11, institutename);
                pstmt.setString(12, interviewexperience);
                pstmt.setString(13, emailId);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    resultVO.setMessage("<font color='green' style='font-weight:bold'>Interviewee Profile Updated.</font>");
                } else {
                    resultVO.setMessage("<font color='red' style='font-weight:bold'>Intervieww Profile Updation failed.</font> ");
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

    public ResultVO submitNewsEvent(NewsEventVO newsEventVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != newsEventVO) {
                int userid = newsEventVO.getUserid();
                String title = newsEventVO.getTitle();
                String date = newsEventVO.getDate();
                date = DateConversion.convertUiDate(date);
                String newsdetails = newsEventVO.getNewsdetails();
                conn = dbConnectionDaoImpl.dbConnect();
                //Statement st = conn.createStatement();
                String sqlquery = "insert into tpcs_news_event(user_id,title,date,newsdetails) values(?,?,?,?)";
                pstmt = conn.prepareStatement(sqlquery);
                pstmt.setInt(1, userid);
                pstmt.setString(2, title);
                pstmt.setString(3, date);
                pstmt.setString(4, newsdetails);
                System.out.println("test query" + sqlquery);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    resultVO.setMessage("Data inserted");
                } else {
                    resultVO.setMessage("data not inserted");
                }
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return resultVO;
    }

    public List<NewsEventVO> populateLimitedNewsEvent() {
        List<NewsEventVO> listOfNewsEventVO = new ArrayList<NewsEventVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlquery = "select * from tpcs_news_event order by date desc limit 5";
            pstmt = conn.prepareStatement(sqlquery);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                NewsEventVO newsEventVO = new NewsEventVO();
                newsEventVO.setTitle(resultSet.getString("title"));
                newsEventVO.setNewsdetails(resultSet.getString("newsdetails"));
                newsEventVO.setDate(DateConversion.convertDbDate(resultSet.getString("date")));
                listOfNewsEventVO.add(newsEventVO);
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return listOfNewsEventVO;
    }
    
     public String populateInterviewScheduleDate() {
        String interviewScheduleDate=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlquery = "select interview_schedule_date from interview_schedule_date";
            pstmt = conn.prepareStatement(sqlquery);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
              interviewScheduleDate = resultSet.getString("interview_schedule_date");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return interviewScheduleDate;
    }

    public ResultVO storeEnquiryInfo(IntervieweeVO intervieweeVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != intervieweeVO) {
                String name = intervieweeVO.getName();
                String contactNo = intervieweeVO.getContactNo();
                String altcontactNo = intervieweeVO.getAltcontactNo();
                String emailId = intervieweeVO.getEmailId();
                String qualification = intervieweeVO.getQualification();
                String remarks = intervieweeVO.getRemarks();
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "insert into tpcs_enquiry_details(name,contactno,altcontactno,emailId,qualification,remarks) values (?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, contactNo);
                pstmt.setString(3, altcontactNo);
                pstmt.setString(4, emailId);
                pstmt.setString(5, qualification);
                pstmt.setString(6, remarks);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    resultVO.setMessage("<font color='green' style='font-weight:bold'>Enquiry  Submitted.</font>");
                } else {
                    resultVO.setMessage("<font color='red' style='font-weight:bold'>Enquiry Submission failed.</font> ");
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

    public List<IntervieweeVO> viewEnquiryReport() {
        List<IntervieweeVO> listOfEnquiry = new ArrayList<IntervieweeVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from tpcs_enquiry_details";
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                IntervieweeVO intervieweeVO = new IntervieweeVO();
                intervieweeVO.setName(rs.getString("name"));
                intervieweeVO.setContactNo(rs.getString("contactno"));
                intervieweeVO.setAltcontactNo(rs.getString("altcontactno"));
                intervieweeVO.setEmailId(rs.getString("emailId"));
                intervieweeVO.setQualification(rs.getString("qualification"));
                intervieweeVO.setRemarks(rs.getString("remarks"));
                listOfEnquiry.add(intervieweeVO);
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
        return listOfEnquiry;
    }

    public ResultVO storeContactUser(ContactVO contactVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;

        if (null != contactVO) {

            String name = contactVO.getNewname();
            String email = contactVO.getNewemail();
            String company = contactVO.getNewcompany();
            String subject = contactVO.getNewsubject();
            String msg = contactVO.getNewmsg();


            try {

                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "insert into tpcs_contact(name,email,company,subject,message) values(?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, company);
                pstmt.setString(4, subject);
                pstmt.setString(5, msg);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {

                    resultVO.setIsFlag(true);
                    resultVO.setMessage("true");
                    System.out.println("Data Inserted");
                } else {
                    resultVO.setIsFlag(false);
                }


            } catch (Exception e) {
            }

        }
        return resultVO;
    }

    public List<NewsEventVO> populateNewsEvent() {
        List<NewsEventVO> listOfNewsEventVO = new ArrayList<NewsEventVO>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlquery = "select * from tpcs_news_event order by date desc";
            pstmt = conn.prepareStatement(sqlquery);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                NewsEventVO newsEventVO = new NewsEventVO();
                newsEventVO.setTitle(resultSet.getString("title"));
                newsEventVO.setNewsdetails(resultSet.getString("newsdetails"));
                newsEventVO.setDate(DateConversion.convertDbDate(resultSet.getString("date")));

                listOfNewsEventVO.add(newsEventVO);

                System.out.println("date is inserteddddddin listtttttttttttttt");
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return listOfNewsEventVO;

    }

    public ResultVO storePlanStatusReport(StatusReportVO statusReportVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            if (null != statusReportVO) {
                String[] planstatusReport = statusReportVO.getPlanStatusReport();



                int resourceId = statusReportVO.getResourceId();
                conn = dbConnectionDaoImpl.dbConnect();
                conn.setAutoCommit(false);

                String sqlQuery = "insert into task_planner(user_id,assign_task_desc,assign_task_date)values(?,?,curdate())";
                pstmt = conn.prepareStatement(sqlQuery);
                for (int i = 0; i < planstatusReport.length; i++) {
                    pstmt.setInt(1, resourceId);
                    pstmt.setString(2, planstatusReport[i]);
                    pstmt.addBatch();
                }


                int[] rowsAffected = pstmt.executeBatch();

                conn.commit();

                if (rowsAffected.length > 0) {
                    resultVO.setMessage("Status Report Submitted.");
                } else {
                    resultVO.setMessage("Status Report Submission failed. ");
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

    public TaskAssignmentVO populateTaskAssignment(String taskId) {
        TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();

        try {
            if (null != taskId) {

                Connection conn = dbConnectionDaoImpl.dbConnect();
                Statement st = conn.createStatement();

                String sqlQuery = "select * from task_assignment where task_id =" + taskId;
                System.out.println(" Test Query : " + sqlQuery);
                ResultSet rs = st.executeQuery(sqlQuery);
                if (rs.next()) {

                    taskAssignmentVO.setTaskId(rs.getString("task_id"));
                    taskAssignmentVO.setResourceId(rs.getInt("task_resource_id"));
                    taskAssignmentVO.setCategoryId(rs.getString("task_category_id"));
                    taskAssignmentVO.setTaskDescription(rs.getString("task_description"));
                    taskAssignmentVO.setTaskStatusId(rs.getString("task_status_id"));
                    taskAssignmentVO.setTaskTargetDate(DateConversion.convertDbDate(rs.getString("task_target_date")));
                }

            }
        } catch (Exception e) {
        }
        return taskAssignmentVO;
    }

    public ResultVO storeSalarySlip(SalaryVo salaryVo) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt_search = null;
        String name = null;

        if (null != salaryVo) {

            int employeeId = salaryVo.getEmployeeId();
            String salary = salaryVo.getSalary();
            String startingdate = salaryVo.getStartingdate();
            String endingdate = salaryVo.getEndingdate();
            String paymentdate = salaryVo.getPaymentdate();
            String paymenttype = salaryVo.getPaymenttype();
            try {
                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuerySearch = "select user_call_name from user_profile where user_id=?";
                pstmt_search = conn.prepareStatement(sqlQuerySearch);
                pstmt_search.setInt(1, employeeId);
                ResultSet rs = pstmt_search.executeQuery();
                if (rs.next()) {
                    name = rs.getString("user_call_name");
                }
                String sqlQuery = "insert into tpcs_salary_slip(employee_id,name,salary,startingdate,endingdate,paymenttype,paymentdate) values(?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setInt(1, employeeId);
                pstmt.setString(2, name);
                pstmt.setString(3, salary);
                pstmt.setString(4, startingdate);
                pstmt.setString(5, endingdate);
                pstmt.setString(6, paymenttype);
                pstmt.setString(7, paymentdate);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {

                    resultVO.setIsFlag(true);
                    resultVO.setMessage("Data Inserted");
                    System.out.println("Data Inserted");
                } else {
                    resultVO.setIsFlag(false);
                }
            } catch (Exception e) {
            }
        }
        return resultVO;
    }

    public SalaryVo populateSalaryInfo(SalaryVo salaryVo) {

        int employeeId = salaryVo.getEmployeeId();
        PreparedStatement pstmt = null;
        String month = "%" + salaryVo.getMonth() + "/%";
        try {
            Connection conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from tpcs_salary_slip where employee_id=? and endingdate like ?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, month);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(" Test Query : " + sqlQuery);
            if (rs.next()) {
                salaryVo.setIsFlag(true);
                salaryVo.setName(rs.getString("name"));
                salaryVo.setSalary(rs.getString("salary"));
                salaryVo.setStartingdate(rs.getString("startingdate"));
                salaryVo.setEndingdate(rs.getString("endingdate"));
                salaryVo.setPaymenttype(rs.getString("paymenttype"));
                salaryVo.setPaymentdate(rs.getString("paymentdate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salaryVo;
    }

    public ResultVO storeTrainee(RegTraineeVo regTraineeVo) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;

        if (null != regTraineeVo) {

            String name = regTraineeVo.getName();
            String email = regTraineeVo.getEmail();
            String altemail = regTraineeVo.getAltemail();
            String phno = regTraineeVo.getPhno();
            String altphno = regTraineeVo.getAltphno();
            String message = regTraineeVo.getMessage();


            try {

                conn = dbConnectionDaoImpl.dbConnect();
                String sqlQuery = "insert into reg_trainee(name,email,altemail,phno,altphno,message) values(?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, altemail);
                pstmt.setString(4, phno);
                pstmt.setString(5, altphno);
                pstmt.setString(6, message);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {

                    resultVO.setIsFlag(true);
                    resultVO.setMessage("true");
                    System.out.println("Data Inserted");
                } else {
                    resultVO.setIsFlag(false);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return resultVO;
    }

    public ResultVO storeUploadCv(FileUploadVo fileUploadVo) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        try {

            conn = dbConnectionDaoImpl.dbConnect();
            String filename = fileUploadVo.getFilename();
            String name = fileUploadVo.getName();
            String email = fileUploadVo.getEmail();
            String phno = fileUploadVo.getPhno();
            String experience = fileUploadVo.getExperience();
            String technology = fileUploadVo.getTechnology();
            System.out.println(filename + "    " + name + "    " + email + "   " + phno + "   " + experience + " " + technology);
            //String sqlQuery1="insert into tpcs-uploadcv(filename,name,email,phone,experience) values('"+filename+"','"+name"','"+email+"','"+phno+"','"+experience+"')";
            String sqlQuery = "insert into tpcs_uploadcv(filename,name,email,phone,experience,technology) values(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(1, filename);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, phno);
            pstmt.setString(5, experience);
            pstmt.setString(6, technology);
            System.out.println("Test Queryyyyy" + sqlQuery);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                resultVO.setIsFlag(true);
                resultVO.setMessage("true");
                System.out.println("Data Inserted");
            } else {
                resultVO.setIsFlag(false);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }



        return resultVO;
    }

    public List<FileUploadVo> downloadCurriculamVitaeService() {
        List<FileUploadVo> listfileUploadVos = new ArrayList<FileUploadVo>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlquery = "select * from tpcs_uploadcv order by uploadcvid desc";
            pstmt = conn.prepareStatement(sqlquery);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                FileUploadVo fileUploadVo = new FileUploadVo();
                fileUploadVo.setName(resultSet.getString("name"));
                fileUploadVo.setEmail(resultSet.getString("email"));
                fileUploadVo.setExperience(resultSet.getString("experience"));
                fileUploadVo.setTechnology(resultSet.getString("technology"));
                fileUploadVo.setFilename("UploadCv" + "//" + resultSet.getString("filename"));
                listfileUploadVos.add(fileUploadVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listfileUploadVos;
    }
    /*
     * This method modyfied by 
     * @TPCS_PL Chandan 109(13.06.2013)
     */

    public IntervieweeVO viewIndividualIntervieweeWorkFlowStatus(int intervieweeSlNo) {
        IntervieweeVO intervieweeVO = new IntervieweeVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select interviewee_name,interviewee_contact_no,interviewee_email_id,interviewee_alternate_email_id,ug_qualification,university_institute_name,pass_out_yr,interview_exp,interviewee_key_skils,interview_profile_name,cv_receive_date,interviewee_status_date,interviewee_status,add_to_our_system_date,intervieweee_remarks from ug_qualification,university_institute,interviewee_info,interview_applyed_profile where interviewee_applied_for_id=interview_profile_id and institute_interview_id = university_institute_id and interviewee_academic_qualification_id = ug_qualification_id and interviewee_sl_no =?";
            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, intervieweeSlNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                intervieweeVO.setIntervieweeSlNo(intervieweeSlNo);
                intervieweeVO.setName(rs.getString("interviewee_name"));
                intervieweeVO.setContactNo(rs.getString("interviewee_contact_no"));
                intervieweeVO.setEmailId(rs.getString("interviewee_email_id"));
                intervieweeVO.setAlternateEmailId(rs.getString("interviewee_alternate_email_id"));
                intervieweeVO.setQualification(rs.getString("ug_qualification"));
                intervieweeVO.setInterviewUniversity(rs.getString("university_institute_name"));
                intervieweeVO.setPassoutyr(rs.getString("pass_out_yr"));
                intervieweeVO.setProfileAppliedFor(rs.getString("interview_profile_name"));
                intervieweeVO.setInterviewStatus(rs.getString("interviewee_status"));
                intervieweeVO.setInterviewStatusDate(rs.getString("interviewee_status_date"));
                intervieweeVO.setReceiveDate(rs.getString("cv_receive_date"));
                intervieweeVO.setOhterKeySkills(rs.getString("interviewee_key_skils"));
                intervieweeVO.setInterviewexperience(rs.getString("interview_exp"));
                intervieweeVO.setIntervieweeStoreDate(rs.getString("add_to_our_system_date"));
                intervieweeVO.setRemarks(rs.getString("intervieweee_remarks"));
            }
            rs.close();
            pstmt.close();
            String sqlQueryWorkFlow = "select employee_id,employee_name,employee_role,employee_action_on,employee_remark,work_flow_status,work_flow_status_date from interviewee_work_flow where work_flow_interviewee_sl_no = ?";
            pstmt = conn.prepareStatement(sqlQueryWorkFlow);
            pstmt.setInt(1, intervieweeSlNo);
            rs = pstmt.executeQuery();
            List<IntervieweeVO> listOfWorkFlow = new ArrayList<IntervieweeVO>();
            while (rs.next()) {
                IntervieweeVO workFlowOfInterviewee = new IntervieweeVO();
                workFlowOfInterviewee.setEmpId(rs.getString("employee_id"));
                workFlowOfInterviewee.setEmpName(rs.getString("employee_name"));
                workFlowOfInterviewee.setEmpRole(rs.getString("employee_role"));
                workFlowOfInterviewee.setEmpAction(rs.getString("employee_action_on"));
                workFlowOfInterviewee.setRemarks(rs.getString("employee_remark"));
                workFlowOfInterviewee.setStatus(rs.getString("work_flow_status"));
                workFlowOfInterviewee.setStatusDate(rs.getString("work_flow_status_date"));
                listOfWorkFlow.add(workFlowOfInterviewee);
            }
            intervieweeVO.setListOfWorkFlow(listOfWorkFlow);
        } catch (SQLException exception) {
        } finally {
            dbConnectionDaoImpl.dbClose(rs, pstmt, conn);
        }
        return intervieweeVO;
    }
    /*
     * This method modyfied by 
     * @TPCS_PL Chandan 109(13.06.2013)
     */

    public ResultVO addCallFollowUpOfInterview(IntervieweeVO intervieweeVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            pstmt = conn.prepareStatement("insert into interviewee_work_flow(work_flow_interviewee_sl_no,employee_id,employee_name,employee_role,employee_action_on,employee_remark,work_flow_status,work_flow_status_date)values(?,?,?,?,?,?,?,now())");
            pstmt.setInt(1, intervieweeVO.getIntervieweeSlNo());
            pstmt.setString(2, intervieweeVO.getEmpId());
            pstmt.setString(3, intervieweeVO.getEmpName());
            pstmt.setString(4, intervieweeVO.getEmpRole());
            pstmt.setString(5, intervieweeVO.getCallFollowUp());
            pstmt.setString(6, intervieweeVO.getRemarks());
            pstmt.setString(7, intervieweeVO.getInterviewStatus());
            int rowEffect = pstmt.executeUpdate();
            if (rowEffect > 0) {
                resultVO.setIsFlag(true);
                resultVO.setMessage("Successfully add");
            }
        } catch (SQLException ex) {
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }
    
    public ResultVO scheduleInterview(String date) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnectionDaoImpl.dbConnect();
            String query = "update interview_schedule_date set interview_schedule_date=?";
            System.out.println(" Query : "+ query);
            System.out.println(" Date : "+ date);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
           
            int rowEffect = pstmt.executeUpdate();
            if (rowEffect > 0) {
                resultVO.setIsFlag(true);
                resultVO.setMessage("Successfully Updated");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }
    
    
}
