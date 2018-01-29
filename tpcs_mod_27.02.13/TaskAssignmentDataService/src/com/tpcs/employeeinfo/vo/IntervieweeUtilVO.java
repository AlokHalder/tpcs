package com.tpcs.employeeinfo.vo;

/*
 * This Bean class implemented by 
 * @TPCS_PL Chandan 109(16.06.2013)
 */
public class IntervieweeUtilVO {

    private String instituteName;
    private String academicQualification;
    private String keySkills;
    private String profileApplied;
    private String primaryId;

    /**
     * @return the instituteName
     */
    public String getInstituteName() {
        return instituteName;
    }

    /**
     * @param instituteName the instituteName to set
     */
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    /**
     * @return the keySkills
     */
    public String getKeySkills() {
        return keySkills;
    }

    /**
     * @param keySkills the keySkills to set
     */
    public void setKeySkills(String keySkills) {
        this.keySkills = keySkills;
    }

    /**
     * @return the academicQualification
     */
    public String getAcademicQualification() {
        return academicQualification;
    }

    /**
     * @param academicQualification the academicQualification to set
     */
    public void setAcademicQualification(String academicQualification) {
        this.academicQualification = academicQualification;
    }

    /**
     * @return the profileApplied
     */
    public String getProfileApplied() {
        return profileApplied;
    }

    /**
     * @param profileApplied the profileApplied to set
     */
    public void setProfileApplied(String profileApplied) {
        this.profileApplied = profileApplied;
    }

    /**
     * @return the primaryId
     */
    public String getPrimaryId() {
        return primaryId;
    }

    /**
     * @param primaryId the primaryId to set
     */
    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }
}
