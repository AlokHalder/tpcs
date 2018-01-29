/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tpcs.admin.taskmgt.vo;

/**
 *
 * @author Administrator
 */
public class UserProfileVO {
 private String userId;
 private String password;
 private  String userName;
 private String userRoleId;
 private String userRoleName;
    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userRoleId
     */
    public String getUserRoleId() {
        return userRoleId;
    }

    /**
     * @param userRoleId the userRoleId to set
     */
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * @return the userRoleName
     */
    public String getUserRoleName() {
        return userRoleName;
    }

    /**
     * @param userRoleName the userRoleName to set
     */
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }


}
