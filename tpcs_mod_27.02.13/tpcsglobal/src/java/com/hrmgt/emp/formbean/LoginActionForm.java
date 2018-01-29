package com.hrmgt.emp.formbean;

/**
 *
 * @author Administrator
 */
public class LoginActionForm extends org.apache.struts.validator.ValidatorForm {

    private String username;
    private String password;
    private String userid;
    private String loginMsg;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

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
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the loginMsg
     */
    public String getLoginMsg() {
        return loginMsg;
    }

    /**
     * @param loginMsg the loginMsg to set
     */
    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }
}
