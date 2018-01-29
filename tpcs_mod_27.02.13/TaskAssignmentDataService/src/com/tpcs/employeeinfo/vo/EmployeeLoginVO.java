package com.tpcs.employeeinfo.vo;
/*
 * This bean implemented by
 * @TPCP_PL Chandan 109.(14.06.2013)
 */

public class EmployeeLoginVO {

    private String loginPassword;
    private int emploueeId;

    /**
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param loginPassword the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * @return the emploueeId
     */
    public int getEmploueeId() {
        return emploueeId;
    }

    /**
     * @param emploueeId the emploueeId to set
     */
    public void setEmploueeId(int emploueeId) {
        this.emploueeId = emploueeId;
    }
}
