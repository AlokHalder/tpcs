package com.tpcs.admin.taskmgt.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author TPCS 10
 */
public class JobpoolVO implements Serializable {

    private String jobId = null;
    private String jobDescription = null;
    private String empId = null;
    private String empName = null;
    private String empRole = null;
    private String jobCreationDate = null;
    private String jobStatus = null;
    private String jobUrgency = null;
    private String projectId = null;
    private String taskTargetDate=null;
    private String taskStatusId=null;
    private String taskCategoryId=null;
    private int assignedByResourceId=0;
    private List<JobpoolVO> jobpoolVO;

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * @return the job_description
     */
    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the empRole
     */
    public String getEmpRole() {
        return empRole;
    }

    /**
     * @param empRole the empRole to set
     */
    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    /**
     * @return the jobCreationDate
     */
    public String getJobCreationDate() {
        return jobCreationDate;
    }

    /**
     * @param jobCreationDate the jobCreationDate to set
     */
    public void setJobCreationDate(String jobCreationDate) {
        this.jobCreationDate = jobCreationDate;
    }

    /**
     * @return the jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the jobUrgency
     */
    public String getJobUrgency() {
        return jobUrgency;
    }

    /**
     * @param jobUrgency the jobUrgency to set
     */
    public void setJobUrgency(String jobUrgency) {
        this.jobUrgency = jobUrgency;
    }

    /**
     * @return the jobpoolVO
     */
    public List<JobpoolVO> getJobpoolVO() {
        return jobpoolVO;
    }

    /**
     * @param jobpoolVO the jobpoolVO to set
     */
    public void setJobpoolVO(List<JobpoolVO> jobpoolVO) {
        this.jobpoolVO = jobpoolVO;
    }

    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the taskTargetDate
     */
    public String getTaskTargetDate() {
        return taskTargetDate;
    }

    /**
     * @param taskTargetDate the taskTargetDate to set
     */
    public void setTaskTargetDate(String taskTargetDate) {
        this.taskTargetDate = taskTargetDate;
    }

    /**
     * @return the taskStatusId
     */
    public String getTaskStatusId() {
        return taskStatusId;
    }

    /**
     * @param taskStatusId the taskStatusId to set
     */
    public void setTaskStatusId(String taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    /**
     * @return the taskCategoryId
     */
    public String getTaskCategoryId() {
        return taskCategoryId;
    }

    /**
     * @param taskCategoryId the taskCategoryId to set
     */
    public void setTaskCategoryId(String taskCategoryId) {
        this.taskCategoryId = taskCategoryId;
    }

    /**
     * @return the assignedByResourceId
     */
    public int getAssignedByResourceId() {
        return assignedByResourceId;
    }

    /**
     * @param assignedByResourceId the assignedByResourceId to set
     */
    public void setAssignedByResourceId(int assignedByResourceId) {
        this.assignedByResourceId = assignedByResourceId;
    }
}
