package com.tpcs.admin.taskmgt.dao.impl;

import com.tpcs.admin.taskmgt.util.DateConversion;
import com.tpcs.admin.taskmgt.vo.JobpoolVO;
import com.tpcs.admin.taskmgt.vo.ResultVO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TPCS_SD Sameep 134 
 * @author TPCS_PL Chandan 109
 */
public class EssentialUtilityService {

    private DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();

    public ResultVO addJob(JobpoolVO jobpoolVO) {
        ResultVO resultVO = new ResultVO();
        Connection con = null;
        PreparedStatement pstmt = null;
        if (null != jobpoolVO) {
            try {
                con = dbConnectionDaoImpl.dbConnect();
                pstmt = con.prepareStatement("select max(job_id) from new_job_details");
                ResultSet resultSet = pstmt.executeQuery();
                int jobId = 0;
                if (resultSet.next()) {
                    jobId = 1 + resultSet.getInt(1);
                }
                resultSet.close();
                pstmt.close();
                pstmt = null;
                String query = "insert into new_job_details (job_id,job_description,job_created_by_emp_id,job_status,job_urgency,job_creation_date) values(?,?,?,?,?,now())";
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, jobId);
                pstmt.setString(2, jobpoolVO.getJobDescription());
                pstmt.setInt(3, Integer.parseInt(jobpoolVO.getEmpId()));
                pstmt.setString(4, jobpoolVO.getJobStatus());
                pstmt.setString(5, jobpoolVO.getJobUrgency());

                int count = pstmt.executeUpdate();
                if (count > 0) {
                    resultVO.setMessage("Successfully added");

                } else {
                    resultVO.setMessage("insertion failed");
                }
            } catch (Exception e) {
            } finally {
                dbConnectionDaoImpl.dbClose(pstmt, con);
            }
        }

        return resultVO;
    }

    public ResultVO ListOfJob() {

        ResultVO resultVO = new ResultVO();

        List<JobpoolVO> jobList = new ArrayList<JobpoolVO>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = dbConnectionDaoImpl.dbConnect();
            String query = "select job_id,job_description,job_created_by_emp_id,user_call_name,job_creation_date,job_status,job_urgency from new_job_details,user_profile where user_id=job_created_by_emp_id";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobpoolVO jobpollvo = new JobpoolVO();
                jobpollvo.setJobId(rs.getString("job_id"));
                jobpollvo.setJobDescription(rs.getString("job_description"));
                jobpollvo.setEmpId(rs.getString("job_created_by_emp_id"));
                jobpollvo.setEmpName(rs.getString("user_call_name"));
                jobpollvo.setJobCreationDate(rs.getString("job_creation_date"));
                jobpollvo.setJobStatus(rs.getString("job_status"));
                jobpollvo.setJobUrgency(rs.getString("job_urgency"));
                jobList.add(jobpollvo);
            }
            resultVO.setJobList(jobList);

        } catch (Exception e) {
        } finally {
            dbConnectionDaoImpl.dbClose(rs, pstmt, con);
        }
        return resultVO;
    }

    public JobpoolVO jobSearch(JobpoolVO jobpoolVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JobpoolVO jobDetails = new JobpoolVO();
        try {
            con = dbConnectionDaoImpl.dbConnect();
            String query = "select job_description,job_created_by_emp_id,job_status,job_urgency,job_creation_date from new_job_details where job_id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(jobpoolVO.getJobId()));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                jobDetails.setJobId(jobpoolVO.getJobId());
                jobDetails.setJobDescription(rs.getString(1));
                jobDetails.setEmpId(rs.getString(2));
                jobDetails.setJobStatus(rs.getString(3));
                jobDetails.setJobUrgency(rs.getString(4));
                jobDetails.setJobCreationDate(rs.getString(5));
            }
        } catch (Exception e) {
        } finally {
            dbConnectionDaoImpl.dbClose(rs, pstmt, con);
        }
        return jobDetails;
    }

    public ResultVO jobAssignTo(JobpoolVO jobpoolVO) {
        ResultVO resultVO = new ResultVO();
        Connection con = null;
        Statement stmt = null;
        int jobId = Integer.parseInt(jobpoolVO.getJobId());
        try {
            con = dbConnectionDaoImpl.dbConnect();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String newJobDetailsQuery = "update new_job_details set job_status='A' where job_id=" + jobId;
            stmt.addBatch(newJobDetailsQuery);
            String assignJobDetailsQuery = "insert into assign_job_details(assign_job_id,assign_to_emp_id,assign_job_status,assign_job_urgency,assign_date) values (" + jobId + ",'" + jobpoolVO.getEmpId() + "','" + jobpoolVO.getJobStatus() + "','" + jobpoolVO.getJobUrgency() + "',now())";
            stmt.addBatch(assignJobDetailsQuery);

            int resourceId = Integer.parseInt(jobpoolVO.getEmpId());
            int assignedByResourceId = jobpoolVO.getAssignedByResourceId();
            String categoryId = jobpoolVO.getTaskCategoryId();
            String taskDescription = jobpoolVO.getJobDescription();
            String projectId = jobpoolVO.getProjectId();
            String targetDate = DateConversion.convertUiDate(jobpoolVO.getTaskTargetDate());
            String statusId = jobpoolVO.getTaskStatusId();

            String taskAssignmentQuery = "insert into task_assignment(task_assigned_by,task_resource_id,task_category_id,task_description,task_target_date,task_status_id,task_project_id)values(" + assignedByResourceId + "," + resourceId + ",'" + categoryId + "','" + taskDescription + "','" + targetDate + "','" + statusId + "','" + projectId + "')";
            stmt.addBatch(taskAssignmentQuery);
            int rowAffected[] = stmt.executeBatch();
            if (rowAffected.length > 0) {
                resultVO.setMessage("Assigned successfully");
            } else {
                resultVO.setMessage("Assigned Failed");
            }
        } catch (Exception e) {
        } finally {
            try {
                stmt.close();
                con.commit();
                con.close();
            } catch (Exception e) {
            }
        }
        return resultVO;
    }

    public JobpoolVO searchAssingDetails(JobpoolVO jobpoolVO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JobpoolVO jobDetails = new JobpoolVO();
        try {
            con = dbConnectionDaoImpl.dbConnect();
            String query = "select user_call_name,job_urgency,assign_date from user_profile,new_job_details,assign_job_details where user_id = assign_to_emp_id and assign_job_id=job_id and job_id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(jobpoolVO.getJobId()));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                jobDetails.setEmpName(rs.getString(1));
                jobDetails.setJobUrgency(rs.getString(2));
                jobDetails.setJobCreationDate(rs.getString(3));
            }
        } catch (Exception e) {
        } finally {
            dbConnectionDaoImpl.dbClose(rs, pstmt, con);
        }
        return jobDetails;
    }
}
