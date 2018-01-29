/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employee.formbean;

import com.tpcs.employeeinfo.vo.EmployeeInfoVO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class EmployeeActionFormBean extends org.apache.struts.validator.ValidatorForm {

    private String employeeId;
    private String user;
    private String password;
    private String name;
    private String address;
    private String dateofbirth;
    private String maritalstatus;
    private String dateofjoining;
    private String grade;
    private String deputedlocation;
    private String employeetype;
    private String nationality;
    private String gender;
    private String designation;
    private String employmentstatus;
    private String emailid;
    private String city;
    private String pin;
    private String phone;
    private List<EmployeeInfoVO> listOfEmployee;
    private String callingperson;
    private String phoneno;
    private String callingpurpose;
    private String followuplevel;
    private String status;
     private String supervisorId;
    private String supervisorName;
    private String parentIouName;
    private String parentIouId;
    private String subIouName;
    private String subIouId;
     private String releaseDate;
    private String profileStatus;
    private String salary;
    private String startingdate;
    private String endingdate;
    private String paymentdate;
    private String paymenttype;
    private String month;
    private String altphone;
    private String location_id;
    private String country_id;
    private String grievance;
    private String ug_qualification;
    private String ug_specialization;
    private String ug_passout;
    private String ug_university;
    private String pg_qualification;
    private String pg_specialization;
    private String pg_passout;
    private String pg_university;
    private String[] empduration;
    private String[] pastdatejoining;
    private String[] dateofrealise;
    private String[] employmentname;
    private String baselocation;
    private String pannumber;
    private String primarybankacc;
    private String secondarybankacc;
    private String curpass;
    private String newpass;
    private String retypepass;
    private String data;
    private String tasktitle;
    private String taskdes;
    private String taskstartdate;
    private String taskcompdate;
    private String taskpriority;
    private int futureTaskId;
    
    
    
    
    
    

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

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
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
     * @return the empname
     */
    public String getName() {
        return name;
    }

    /**
     * @param empname the empname to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return the employmentstatus
     */
    public String getEmploymentstatus() {
        return employmentstatus;
    }

    /**
     * @param employmentstatus the employmentstatus to set
     */
    public void setEmploymentstatus(String employmentstatus) {
        this.employmentstatus = employmentstatus;
    }

    /**
     * @return the emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * @param emailid the emailid to set
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the listOfEmployee
     */
    public List<EmployeeInfoVO> getListOfEmployee() {
        return listOfEmployee;
    }

    /**
     * @param listOfEmployee the listOfEmployee to set
     */
    public void setListOfEmployee(List<EmployeeInfoVO> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the dateofbirth
     */
    public String getDateofbirth() {
        return dateofbirth;
    }

    /**
     * @param dateofbirth the dateofbirth to set
     */
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    /**
     * @return the maritalstatus
     */
    public String getMaritalstatus() {
        return maritalstatus;
    }

    /**
     * @param maritalstatus the maritalstatus to set
     */
    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    /**
     * @return the dateofjoining
     */
    public String getDateofjoining() {
        return dateofjoining;
    }

    /**
     * @param dateofjoining the dateofjoining to set
     */
    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the deputedlocation
     */
    public String getDeputedlocation() {
        return deputedlocation;
    }

    /**
     * @param deputedlocation the deputedlocation to set
     */
    public void setDeputedlocation(String deputedlocation) {
        this.deputedlocation = deputedlocation;
    }

    /**
     * @return the employeetype
     */
    public String getEmployeetype() {
        return employeetype;
    }

    /**
     * @param employeetype the employeetype to set
     */
    public void setEmployeetype(String employeetype) {
        this.employeetype = employeetype;
    }

    /**
     * @return the callingperson
     */
    public String getCallingperson() {
        return callingperson;
    }

    /**
     * @param callingperson the callingperson to set
     */
    public void setCallingperson(String callingperson) {
        this.callingperson = callingperson;
    }

    /**
     * @return the phoneno
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * @param phoneno the phoneno to set
     */
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    /**
     * @return the callingpurpose
     */
    public String getCallingpurpose() {
        return callingpurpose;
    }

    /**
     * @param callingpurpose the callingpurpose to set
     */
    public void setCallingpurpose(String callingpurpose) {
        this.callingpurpose = callingpurpose;
    }

    /**
     * @return the followuplevel
     */
    public String getFollowuplevel() {
        return followuplevel;
    }

    /**
     * @param followuplevel the followuplevel to set
     */
    public void setFollowuplevel(String followuplevel) {
        this.followuplevel = followuplevel;
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
     * @return the supervisorId
     */
    public String getSupervisorId() {
        return supervisorId;
    }

    /**
     * @param supervisorId the supervisorId to set
     */
    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     * @return the supervisorName
     */
    public String getSupervisorName() {
        return supervisorName;
    }

    /**
     * @param supervisorName the supervisorName to set
     */
    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    /**
     * @return the parentIouName
     */
    public String getParentIouName() {
        return parentIouName;
    }

    /**
     * @param parentIouName the parentIouName to set
     */
    public void setParentIouName(String parentIouName) {
        this.parentIouName = parentIouName;
    }

    /**
     * @return the subIouName
     */
    public String getSubIouName() {
        return subIouName;
    }

    /**
     * @param subIouName the subIouName to set
     */
    public void setSubIouName(String subIouName) {
        this.subIouName = subIouName;
    }

    /**
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the profileStatus
     */
    public String getProfileStatus() {
        return profileStatus;
    }

    /**
     * @param profileStatus the profileStatus to set
     */
    public void setProfileStatus(String profileStatus) {
        this.profileStatus = profileStatus;
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
     * @return the altphone
     */
    public String getAltphone() {
        return altphone;
    }

    /**
     * @param altphone the altphone to set
     */
    public void setAltphone(String altphone) {
        this.altphone = altphone;
    }

    /**
     * @return the location_id
     */
    public String getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the country_id
     */
    public String getCountry_id() {
        return country_id;
    }

    /**
     * @param country_id the country_id to set
     */
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    /**
     * @return the grievance
     */
    public String getGrievance() {
        return grievance;
    }

    /**
     * @param grievance the grievance to set
     */
    public void setGrievance(String grievance) {
        this.grievance = grievance;
    }

    /**
     * @return the ug_qualification
     */
    public String getUg_qualification() {
        return ug_qualification;
    }

    /**
     * @param ug_qualification the ug_qualification to set
     */
    public void setUg_qualification(String ug_qualification) {
        this.ug_qualification = ug_qualification;
    }

    /**
     * @return the ug_specialization
     */
    public String getUg_specialization() {
        return ug_specialization;
    }

    /**
     * @param ug_specialization the ug_specialization to set
     */
    public void setUg_specialization(String ug_specialization) {
        this.ug_specialization = ug_specialization;
    }

    /**
     * @return the ug_passout
     */
    public String getUg_passout() {
        return ug_passout;
    }

    /**
     * @param ug_passout the ug_passout to set
     */
    public void setUg_passout(String ug_passout) {
        this.ug_passout = ug_passout;
    }

    /**
     * @return the ug_university
     */
    public String getUg_university() {
        return ug_university;
    }

    /**
     * @param ug_university the ug_university to set
     */
    public void setUg_university(String ug_university) {
        this.ug_university = ug_university;
    }

    /**
     * @return the pg_qualification
     */
    public String getPg_qualification() {
        return pg_qualification;
    }

    /**
     * @param pg_qualification the pg_qualification to set
     */
    public void setPg_qualification(String pg_qualification) {
        this.pg_qualification = pg_qualification;
    }

    /**
     * @return the pg_specialization
     */
    public String getPg_specialization() {
        return pg_specialization;
    }

    /**
     * @param pg_specialization the pg_specialization to set
     */
    public void setPg_specialization(String pg_specialization) {
        this.pg_specialization = pg_specialization;
    }

    /**
     * @return the pg_passout
     */
    public String getPg_passout() {
        return pg_passout;
    }

    /**
     * @param pg_passout the pg_passout to set
     */
    public void setPg_passout(String pg_passout) {
        this.pg_passout = pg_passout;
    }

    /**
     * @return the pg_university
     */
    public String getPg_university() {
        return pg_university;
    }

    /**
     * @param pg_university the pg_university to set
     */
    public void setPg_university(String pg_university) {
        this.pg_university = pg_university;
    }

    /**
     * @return the empduration
     */
    public String[] getEmpduration() {
        return empduration;
    }

    /**
     * @param empduration the empduration to set
     */
    public void setEmpduration(String[] empduration) {
        this.empduration = empduration;
    }

    /**
     * @return the pastdatejoining
     */
    public String[] getPastdatejoining() {
        return pastdatejoining;
    }

    /**
     * @param pastdatejoining the pastdatejoining to set
     */
    public void setPastdatejoining(String[] pastdatejoining) {
        this.pastdatejoining = pastdatejoining;
    }

    /**
     * @return the dateofrealise
     */
    public String[] getDateofrealise() {
        return dateofrealise;
    }

    /**
     * @param dateofrealise the dateofrealise to set
     */
    public void setDateofrealise(String[] dateofrealise) {
        this.dateofrealise = dateofrealise;
    }

    /**
     * @return the employmentname
     */
    public String[] getEmploymentname() {
        return employmentname;
    }

    /**
     * @param employmentname the employmentname to set
     */
    public void setEmploymentname(String[] employmentname) {
        this.employmentname = employmentname;
    }

    /**
     * @return the baselocation
     */
    public String getBaselocation() {
        return baselocation;
    }

    /**
     * @param baselocation the baselocation to set
     */
    public void setBaselocation(String baselocation) {
        this.baselocation = baselocation;
    }

    /**
     * @return the parentIouId
     */
    public String getParentIouId() {
        return parentIouId;
    }

    /**
     * @param parentIouId the parentIouId to set
     */
    public void setParentIouId(String parentIouId) {
        this.parentIouId = parentIouId;
    }

    /**
     * @return the subIouId
     */
    public String getSubIouId() {
        return subIouId;
    }

    /**
     * @param subIouId the subIouId to set
     */
    public void setSubIouId(String subIouId) {
        this.subIouId = subIouId;
    }

    /**
     * @return the pannumber
     */
    public String getPannumber() {
        return pannumber;
    }

    /**
     * @param pannumber the pannumber to set
     */
    public void setPannumber(String pannumber) {
        this.pannumber = pannumber;
    }

    /**
     * @return the primarybankacc
     */
    public String getPrimarybankacc() {
        return primarybankacc;
    }

    /**
     * @param primarybankacc the primarybankacc to set
     */
    public void setPrimarybankacc(String primarybankacc) {
        this.primarybankacc = primarybankacc;
    }

    /**
     * @return the secondarybankacc
     */
    public String getSecondarybankacc() {
        return secondarybankacc;
    }

    /**
     * @param secondarybankacc the secondarybankacc to set
     */
    public void setSecondarybankacc(String secondarybankacc) {
        this.secondarybankacc = secondarybankacc;
    }

    /**
     * @return the curpass
     */
    public String getCurpass() {
        return curpass;
    }

    /**
     * @param curpass the curpass to set
     */
    public void setCurpass(String curpass) {
        this.curpass = curpass;
    }

    /**
     * @return the newpass
     */
    public String getNewpass() {
        return newpass;
    }

    /**
     * @param newpass the newpass to set
     */
    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    /**
     * @return the retypepass
     */
    public String getRetypepass() {
        return retypepass;
    }

    /**
     * @param retypepass the retypepass to set
     */
    public void setRetypepass(String retypepass) {
        this.retypepass = retypepass;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the tasktitle
     */
    public String getTasktitle() {
        return tasktitle;
    }

    /**
     * @param tasktitle the tasktitle to set
     */
    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    /**
     * @return the taskdes
     */
    public String getTaskdes() {
        return taskdes;
    }

    /**
     * @param taskdes the taskdes to set
     */
    public void setTaskdes(String taskdes) {
        this.taskdes = taskdes;
    }

    /**
     * @return the taskstartdate
     */
    public String getTaskstartdate() {
        return taskstartdate;
    }

    /**
     * @param taskstartdate the taskstartdate to set
     */
    public void setTaskstartdate(String taskstartdate) {
        this.taskstartdate = taskstartdate;
    }

    /**
     * @return the taskcompdate
     */
    public String getTaskcompdate() {
        return taskcompdate;
    }

    /**
     * @param taskcompdate the taskcompdate to set
     */
    public void setTaskcompdate(String taskcompdate) {
        this.taskcompdate = taskcompdate;
    }

    /**
     * @return the taskpriority
     */
    public String getTaskpriority() {
        return taskpriority;
    }

    /**
     * @param taskpriority the taskpriority to set
     */
    public void setTaskpriority(String taskpriority) {
        this.taskpriority = taskpriority;
    }

    /**
     * @return the futureTaskId
     */
    public int getFutureTaskId() {
        return futureTaskId;
    }

    /**
     * @param futureTaskId the futureTaskId to set
     */
    public void setFutureTaskId(int futureTaskId) {
        this.futureTaskId = futureTaskId;
    }
 
    
}
