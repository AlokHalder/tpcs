/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tpcs.admin.hrmgt.vo;

/**
 *
 * @author Administrator
 */
public class ResultVO {
    private boolean userFlag;
    private int userId;
    private String userRole;
    private String message;
    

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
     * @return the userFlag
     */
    public boolean isUserFlag() {
        return userFlag;
    }

    /**
     * @param userFlag the userFlag to set
     */
    public void setUserFlag(boolean userFlag) {
        this.userFlag = userFlag;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}
