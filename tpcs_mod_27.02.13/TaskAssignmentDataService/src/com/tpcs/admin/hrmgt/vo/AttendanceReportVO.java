/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.hrmgt.vo;

/**
 *
 * @author ALOK
 */
public class AttendanceReportVO {
    private String currentDateValue;
    private String officeEntryTime;
    private String officeLeaveTime;
    private String officeHoursSpent;
    private String officeHoursLoss;

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
     * @return the officeHoursSpent
     */
    public String getOfficeHoursSpent() {
        return officeHoursSpent;
    }

    /**
     * @param officeHoursSpent the officeHoursSpent to set
     */
    public void setOfficeHoursSpent(String officeHoursSpent) {
        this.officeHoursSpent = officeHoursSpent;
    }

    /**
     * @return the currentDateValue
     */
    public String getCurrentDateValue() {
        return currentDateValue;
    }

    /**
     * @param currentDateValue the currentDateValue to set
     */
    public void setCurrentDateValue(String currentDateValue) {
        this.currentDateValue = currentDateValue;
    }

    /**
     * @return the officeHoursLoss
     */
    public String getOfficeHoursLoss() {
        return officeHoursLoss;
    }

    /**
     * @param officeHoursLoss the officeHoursLoss to set
     */
    public void setOfficeHoursLoss(String officeHoursLoss) {
        this.officeHoursLoss = officeHoursLoss;
    }
    
    
    
}
