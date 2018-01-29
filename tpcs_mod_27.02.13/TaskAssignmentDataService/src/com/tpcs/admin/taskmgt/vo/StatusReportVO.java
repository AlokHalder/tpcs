/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.vo;

/**
 *
 * @author ALOK
 */
public class StatusReportVO {
    private int statusReportId;
    private String statusReportDescription;
    private String statusReport;
    private String statusReportDate;
    private int resourceId;
    private String billableHours;
    private String nonBillableHours;
    private String officeEntryTime;
    private String officeLeaveTime;
    private String officeTimeSpent;
    private String officeWorkingHourLoss;
     private String[] submitstatusreport;
    private String[] planStatusReport;
    private String status; 
    private String date;
    

    /**
     * @return the statusReport
     */
    public String getStatusReport() {
        return statusReport;
    }

    /**
     * @param statusReport the statusReport to set
     */
    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport;
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
     * @return the statusReportDate
     */
    public String getStatusReportDate() {
        return statusReportDate;
    }

    /**
     * @param statusReportDate the statusReportDate to set
     */
    public void setStatusReportDate(String statusReportDate) {
        this.statusReportDate = statusReportDate;
    }

    /**
     * @return the billableHours
     */
    public String getBillableHours() {
        return billableHours;
    }

    /**
     * @param billableHours the billableHours to set
     */
    public void setBillableHours(String billableHours) {
        this.billableHours = billableHours;
    }

    /**
     * @return the nonBillableHours
     */
    public String getNonBillableHours() {
        return nonBillableHours;
    }

    /**
     * @param nonBillableHours the nonBillableHours to set
     */
    public void setNonBillableHours(String nonBillableHours) {
        this.nonBillableHours = nonBillableHours;
    }

    /**
     * @return the statusReportId
     */
    public int getStatusReportId() {
        return statusReportId;
    }

    /**
     * @param statusReportId the statusReportId to set
     */
    public void setStatusReportId(int statusReportId) {
        this.statusReportId = statusReportId;
    }

    /**
     * @return the statusReportDescription
     */
    public String getStatusReportDescription() {
        return statusReportDescription;
    }

    /**
     * @param statusReportDescription the statusReportDescription to set
     */
    public void setStatusReportDescription(String statusReportDescription) {
        this.statusReportDescription = statusReportDescription;
    }

    /**
     * @return the officeEntryTime
     */
    public String getOfficeEntryTime() {
        return officeEntryTime;
    }

    /**
     * @param officeEntryTime the officeEntryTime to set
     */
    public void setOfficeEntryTime(String officeEntryTime) {
        this.officeEntryTime = officeEntryTime;
    }

    /**
     * @return the officeLeaveTime
     */
    public String getOfficeLeaveTime() {
        return officeLeaveTime;
    }

    /**
     * @param officeLeaveTime the officeLeaveTime to set
     */
    public void setOfficeLeaveTime(String officeLeaveTime) {
        this.officeLeaveTime = officeLeaveTime;
    }

    /**
     * @return the officeTimeSpent
     */
    public String getOfficeTimeSpent() {
        return officeTimeSpent;
    }

    /**
     * @param officeTimeSpent the officeTimeSpent to set
     */
    public void setOfficeTimeSpent(String officeTimeSpent) {
        this.officeTimeSpent = officeTimeSpent;
    }

    /**
     * @return the officeWorkingHourLoss
     */
    public String getOfficeWorkingHourLoss() {
        return officeWorkingHourLoss;
    }

    /**
     * @param officeWorkingHourLoss the officeWorkingHourLoss to set
     */
    public void setOfficeWorkingHourLoss(String officeWorkingHourLoss) {
        this.officeWorkingHourLoss = officeWorkingHourLoss;
    }

    /**
     * @return the submitstatusreport
     */
    public String[] getSubmitstatusreport() {
        return submitstatusreport;
    }

    /**
     * @param submitstatusreport the submitstatusreport to set
     */
    public void setSubmitstatusreport(String[] submitstatusreport) {
        this.submitstatusreport = submitstatusreport;
    }

    /**
     * @return the planStatusReport
     */
    public String[] getPlanStatusReport() {
        return planStatusReport;
    }

    /**
     * @param planStatusReport the planStatusReport to set
     */
    public void setPlanStatusReport(String[] planStatusReport) {
        this.planStatusReport = planStatusReport;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    
}
