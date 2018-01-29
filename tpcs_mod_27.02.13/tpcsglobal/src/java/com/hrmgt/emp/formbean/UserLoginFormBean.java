

package com.hrmgt.emp.formbean;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class UserLoginFormBean extends org.apache.struts.action.ActionForm {
    
    private String userid;
    private int password;
    private String name;
    private Date joiningdate;
    private Date dateofbirth;
    private String designation;
    private String higherqualification;
    private Date yearofpassout;
    private String specilization;
    private String empaddress;
    private int empzipcode;
    private String empcontactnumber;
    private String empemailid;

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
     * @return the password
     */
    public int getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(int password) {
        this.password = password;
    }

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
     * @return the dateofbirth
     */
    public Date getDateofbirth() {
        return dateofbirth;
    }

    /**
     * @param dateofbirth the dateofbirth to set
     */
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the higherqualification
     */
    public String getHigherqualification() {
        return higherqualification;
    }

    /**
     * @param higherqualification the higherqualification to set
     */
    public void setHigherqualification(String higherqualification) {
        this.higherqualification = higherqualification;
    }

    /**
     * @return the yearofpassout
     */
    public Date getYearofpassout() {
        return yearofpassout;
    }

    /**
     * @param yearofpassout the yearofpassout to set
     */
    public void setYearofpassout(Date yearofpassout) {
        this.yearofpassout = yearofpassout;
    }

    /**
     * @return the specilization
     */
    public String getSpecilization() {
        return specilization;
    }

    /**
     * @param specilization the specilization to set
     */
    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    /**
     * @return the empaddress
     */
    public String getEmpaddress() {
        return empaddress;
    }

    /**
     * @param empaddress the empaddress to set
     */
    public void setEmpaddress(String empaddress) {
        this.empaddress = empaddress;
    }

    /**
     * @return the empzipcode
     */
    public int getEmpzipcode() {
        return empzipcode;
    }

    /**
     * @param empzipcode the empzipcode to set
     */
    public void setEmpzipcode(int empzipcode) {
        this.empzipcode = empzipcode;
    }

    /**
     * @return the empcontactnumber
     */
    public String getEmpcontactnumber() {
        return empcontactnumber;
    }

    /**
     * @param empcontactnumber the empcontactnumber to set
     */
    public void setEmpcontactnumber(String empcontactnumber) {
        this.empcontactnumber = empcontactnumber;
    }

    /**
     * @return the empemailid
     */
    public String getEmpemailid() {
        return empemailid;
    }

    /**
     * @param empemailid the empemailid to set
     */
    public void setEmpemailid(String empemailid) {
        this.empemailid = empemailid;
    }

    /**
     * @return the joiningdate
     */
    public Date getJoiningdate() {
        return joiningdate;
    }

    /**
     * @param joiningdate the joiningdate to set
     */
    public void setJoiningdate(Date joiningdate) {
        this.joiningdate = joiningdate;
    }

    /**
     * @return the joiningdate
     */
    
   

    
}
