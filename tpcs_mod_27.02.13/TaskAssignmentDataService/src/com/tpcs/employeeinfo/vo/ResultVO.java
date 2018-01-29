package com.tpcs.employeeinfo.vo;


/**
 *
 * @author Administrator
 */
public class ResultVO {

    private String message;
    private String employeeId;
    
    private boolean isflag;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the isflag
     */
    public boolean isIsflag() {
        return isflag;
    }

    /**
     * @param isflag the isflag to set
     */
    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
