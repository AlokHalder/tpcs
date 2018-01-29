/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.dao;

import com.tpcs.admin.taskmgt.vo.ListOfValuesVO;
import java.util.List;


public interface LovServicesDao {

    public List<ListOfValuesVO> populateTaskCategoryList();

    public List<ListOfValuesVO> populateTaskList();

    public List<ListOfValuesVO> populateUserProfileList();

    public List<ListOfValuesVO> populateTaskStatusList();

    public List<ListOfValuesVO> populateLocationList();

    public List<ListOfValuesVO> populateGradeList();

    public List<ListOfValuesVO> populateDesignationList();

    public List<ListOfValuesVO> populateCountryList();

    public List<ListOfValuesVO> populateTpcsLocationList();

    public List<ListOfValuesVO> populateTpcsUgQualification();

    public List<ListOfValuesVO> populateTpcsPgQualification();

    public List<ListOfValuesVO> populateTpcsUgSpecialization();

    public List<ListOfValuesVO> populateTpcsUgUniversity();

    public List<ListOfValuesVO> populateTpcsPgSpecialization();

    public List<ListOfValuesVO> populateTpcsPgUniversity();

    public List<ListOfValuesVO> populateTpcsLocationId();
    
    public List<ListOfValuesVO> populateTpcsGradeId();
    
    
    
}
