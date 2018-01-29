/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.vo;

import com.tpcs.employeeinfo.vo.IntervieweeUtilVO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ResultVO {

    private String message;
    private int id;
    private boolean isFlag;
    private List<TaskAssignmentVO> list;
    private List<IntervieweeUtilVO> listOfQualification;
    private List<IntervieweeUtilVO> listOfUniversity;
    private List<IntervieweeUtilVO> listOfKeySkills;
    private List<IntervieweeUtilVO> listOfProfile;
    private List<JobpoolVO> jobList;
    private List<JobpoolVO> listOfId;

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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the list
     */
    public List<TaskAssignmentVO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TaskAssignmentVO> list) {
        this.list = list;
    }

    /**
     * @return the listOfQualification
     */
    public List<IntervieweeUtilVO> getListOfQualification() {
        return listOfQualification;
    }

    /**
     * @param listOfQualification the listOfQualification to set
     */
    public void setListOfQualification(List<IntervieweeUtilVO> listOfQualification) {
        this.listOfQualification = listOfQualification;
    }

    /**
     * @return the listOfUniversity
     */
    public List<IntervieweeUtilVO> getListOfUniversity() {
        return listOfUniversity;
    }

    /**
     * @param listOfUniversity the listOfUniversity to set
     */
    public void setListOfUniversity(List<IntervieweeUtilVO> listOfUniversity) {
        this.listOfUniversity = listOfUniversity;
    }

    /**
     * @return the listOfKeySkills
     */
    public List<IntervieweeUtilVO> getListOfKeySkills() {
        return listOfKeySkills;
    }

    /**
     * @param listOfKeySkills the listOfKeySkills to set
     */
    public void setListOfKeySkills(List<IntervieweeUtilVO> listOfKeySkills) {
        this.listOfKeySkills = listOfKeySkills;
    }

    /**
     * @return the listOfProfile
     */
    public List<IntervieweeUtilVO> getListOfProfile() {
        return listOfProfile;
    }

    /**
     * @param listOfProfile the listOfProfile to set
     */
    public void setListOfProfile(List<IntervieweeUtilVO> listOfProfile) {
        this.listOfProfile = listOfProfile;
    }

    /**
     * @return the jobList
     */
    public List<JobpoolVO> getJobList() {
        return jobList;
    }

    /**
     * @param jobList the jobList to set
     */
    public void setJobList(List<JobpoolVO> jobList) {
        this.jobList = jobList;
    }

    /**
     * @return the listOfId
     */
    public List<JobpoolVO> getListOfId() {
        return listOfId;
    }

    /**
     * @param listOfId the listOfId to set
     */
    public void setListOfId(List<JobpoolVO> listOfId) {
        this.listOfId = listOfId;
    }
}
