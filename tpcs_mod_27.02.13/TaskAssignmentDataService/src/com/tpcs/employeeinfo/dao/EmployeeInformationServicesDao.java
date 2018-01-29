/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employeeinfo.dao;

import com.tpcs.employeeinfo.vo.EmployeeInfoVO;
import com.tpcs.employeeinfo.vo.ResultVO;
import com.tpcs.employeeinfo.vo.UserProfileVO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface EmployeeInformationServicesDao {

    public ResultVO storeEmployeeInfo(EmployeeInfoVO employeeInfoVO);

    public EmployeeInfoVO populateEmployeeInfo(String employeeId);

    public ResultVO deleteEmployeeInfo(String employeeId);

    public EmployeeInfoVO modifyEmployeeInfo(EmployeeInfoVO employeeInfoVO);

    public ResultVO searchEmployeeInfo(String employeeId);

    public boolean userValidation(UserProfileVO userProfileVO);

    public List<EmployeeInfoVO> viewAllEmployeeInfo();
}
