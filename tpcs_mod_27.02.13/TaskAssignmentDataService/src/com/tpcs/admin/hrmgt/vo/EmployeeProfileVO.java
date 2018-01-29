

package com.tpcs.admin.hrmgt.vo;

import java.sql.Date;


public class EmployeeProfileVO {
    
   private String userid;
    private int password;
    private String name;
    private Date joiningDate;
    private Date dateOfBirth;
    private String designation;
    private String higherQualification;
    private Date yearOfPassout;
    private String specilization;
    private String address;
    private int zipCode;
    private String contactNumber;
    private String emailId;

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
     * @return the joiningDate
     */
    public Date getJoiningDate() {
        return joiningDate;
    }

    /**
     * @param joiningDate the joiningDate to set
     */
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
     * @return the higherQualification
     */
    public String getHigherQualification() {
        return higherQualification;
    }

    /**
     * @param higherQualification the higherQualification to set
     */
    public void setHigherQualification(String higherQualification) {
        this.higherQualification = higherQualification;
    }

    /**
     * @return the yearOfPassout
     */
    public Date getYearOfPassout() {
        return yearOfPassout;
    }

    /**
     * @param yearOfPassout the yearOfPassout to set
     */
    public void setYearOfPassout(Date yearOfPassout) {
        this.yearOfPassout = yearOfPassout;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    


}
