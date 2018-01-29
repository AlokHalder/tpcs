/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.vo;

import java.io.File;


/**
 *
 * @author ALOK
 */
public class TaskAssignmentVO {
    private String taskId;
    private int assignedByResourceId;
    private String assignedByResourceName;
    private int resourceId;
    private String resourceName;
    private String taskCategoryId;
    private String taskCategoryName;
    private String taskDescription;
    private String taskTargetDate;
    private String taskStatusId;
    private String statusName;
    private String projectId;
    private String projectName;
    private String closingDate;
    private File taskAttachment;
    private String remarks;
    private String categoryId;
     private String tasktitle;
    private String taskdes;
    private String taskstartdate;
    private String taskcompdate;
    private String taskpriority;
    private int futureTaskId;
    
     
    
    /**
     * @return the taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    /**
     * @return the resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName the resourceName to set
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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
     * @return the taskCategoryName
     */
    public String getTaskCategoryName() {
        return taskCategoryName;
    }

    /**
     * @param taskCategoryName the taskCategoryName to set
     */
    public void setTaskCategoryName(String taskCategoryName) {
        this.taskCategoryName = taskCategoryName;
    }

    /**
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @param taskDescription the taskDescription to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the closingDate
     */
    public String getClosingDate() {
        return closingDate;
    }

    /**
     * @param closingDate the closingDate to set
     */
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * @return the taskAttachment
     */
    public File getTaskAttachment() {
        return taskAttachment;
    }

    /**
     * @param taskAttachment the taskAttachment to set
     */
    public void setTaskAttachment(File taskAttachment) {
        this.taskAttachment = taskAttachment;
    }

    /**
     * @return the resourceId
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
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

    /**
     * @return the assignedByResourceName
     */
    public String getAssignedByResourceName() {
        return assignedByResourceName;
    }

    /**
     * @param assignedByResourceName the assignedByResourceName to set
     */
    public void setAssignedByResourceName(String assignedByResourceName) {
        this.assignedByResourceName = assignedByResourceName;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the tasktitle
     */
    public String getTasktitle() {
        return tasktitle;
    }

    /**
     * @param tasktitle the tasktitle to set
     */
    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    /**
     * @return the taskdes
     */
    public String getTaskdes() {
        return taskdes;
    }

    /**
     * @param taskdes the taskdes to set
     */
    public void setTaskdes(String taskdes) {
        this.taskdes = taskdes;
    }

    /**
     * @return the taskstartdate
     */
    public String getTaskstartdate() {
        return taskstartdate;
    }

    /**
     * @param taskstartdate the taskstartdate to set
     */
    public void setTaskstartdate(String taskstartdate) {
        this.taskstartdate = taskstartdate;
    }

    /**
     * @return the taskcompdate
     */
    public String getTaskcompdate() {
        return taskcompdate;
    }

    /**
     * @param taskcompdate the taskcompdate to set
     */
    public void setTaskcompdate(String taskcompdate) {
        this.taskcompdate = taskcompdate;
    }

    /**
     * @return the taskpriority
     */
    public String getTaskpriority() {
        return taskpriority;
    }

    /**
     * @param taskpriority the taskpriority to set
     */
    public void setTaskpriority(String taskpriority) {
        this.taskpriority = taskpriority;
    }

    /**
     * @return the futureTaskId
     */
    public int getFutureTaskId() {
        return futureTaskId;
    }

    /**
     * @param futureTaskId the futureTaskId to set
     */
    public void setFutureTaskId(int futureTaskId) {
        this.futureTaskId = futureTaskId;
    }

    
}
   