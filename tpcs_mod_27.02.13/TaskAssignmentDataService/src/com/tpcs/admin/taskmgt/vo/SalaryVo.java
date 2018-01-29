/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.vo;

/**
 *
 * @author TPCS
 */
public class SalaryVo {
   
    private boolean isFlag;
    private int employeeId;
    private String name;
    private String salary;
    private String startingdate;
    private String endingdate;
    private String paymentdate;
    private String paymenttype;
    private String month;

    /**
     * @return the employeeId
     */
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the startingdate
     */
    public String getStartingdate() {
        return startingdate;
    }

    /**
     * @param startingdate the startingdate to set
     */
    public void setStartingdate(String startingdate) {
        this.startingdate = startingdate;
    }

    /**
     * @return the endingdate
     */
    public String getEndingdate() {
        return endingdate;
    }

    /**
     * @param endingdate the endingdate to set
     */
    public void setEndingdate(String endingdate) {
        this.endingdate = endingdate;
    }

    /**
     * @return the paymentdate
     */
    public String getPaymentdate() {
        return paymentdate;
    }

    /**
     * @param paymentdate the paymentdate to set
     */
    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    /**
     * @return the paymenttype
     */
    public String getPaymenttype() {
        return paymenttype;
    }

    /**
     * @param paymenttype the paymenttype to set
     */
    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the isFlag
     */
    public boolean isIsFlag() {
        return isFlag;
    }

    /**
     * @param isFlag the isFlag to set
     */
    public void setIsFlag(boolean isFlag) {
        this.isFlag = isFlag;
    }
}
