/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.hrmgt.vo;

/**
 *
 * @author ALOK
 */
public class LeaveManagementVO {
    private int associateId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String leaveDuration;
    private String dayNum;
    private String reasonOfLeave;
    
    

    /**
     * @return the leaveType
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType the leaveType to set
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the leaveDuration
     */
    public String getLeaveDuration() {
        return leaveDuration;
    }

    /**
     * @param leaveDuration the leaveDuration to set
     */
    public void setLeaveDuration(String leaveDuration) {
        this.leaveDuration = leaveDuration;
    }

    /**
     * @return the dayNum
     */
    public String getDayNum() {
        return dayNum;
    }

    /**
     * @param dayNum the dayNum to set
     */
    public void setDayNum(String dayNum) {
        this.dayNum = dayNum;
    }

    /**
     * @return the reasonOfLeave
     */
    public String getReasonOfLeave() {
        return reasonOfLeave;
    }

    /**
     * @param reasonOfLeave the reasonOfLeave to set
     */
    public void setReasonOfLeave(String reasonOfLeave) {
        this.reasonOfLeave = reasonOfLeave;
    }

    /**
     * @return the associateId
     */
    public int getAssociateId() {
        return associateId;
    }

    /**
     * @param associateId the associateId to set
     */
    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

 
   
    
    
}
