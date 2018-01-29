/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employeeinfo.dao.impl;

import com.tpcs.employeeinfo.dao.EmployeeInformationServicesDao;
import com.tpcs.employeeinfo.vo.EmployeeInfoVO;
import com.tpcs.employeeinfo.vo.ResultVO;
import com.tpcs.employeeinfo.vo.UserProfileVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class EmployeeInformationServicesDaoImpl_1 implements EmployeeInformationServicesDao {
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        public ResultVO storeEmployeeInfo(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        try{
        if (null != employeeInfoVO) {
            String name = employeeInfoVO.getName();
            String address = employeeInfoVO.getAddress();
            String city = employeeInfoVO.getCity();
            String phone = employeeInfoVO.getPhone();
            String pin = employeeInfoVO.getPin();
            String dateofbirth = employeeInfoVO.getDateofbirth();
            String maritalstatus = employeeInfoVO.getMaritalstatus();
            String dateofjoining = employeeInfoVO.getDateofjoining();
            String grade = employeeInfoVO.getGrade();
            String deputedlocation = employeeInfoVO.getDeputedlocation();
            String employeetype = employeeInfoVO.getEmployeetype();
            String gender = employeeInfoVO.getGender();
            String nationality = employeeInfoVO.getNationality();
            String designation = employeeInfoVO.getDesignation();
            String employmentstatus = employeeInfoVO.getEmploymentstatus();
            String emailid = employeeInfoVO.getEmailid();

            Connection conn=dbConnectionDaoImpl.dbConnect();
            Statement  st = conn.createStatement();
            String  sqlQuery = "insert into employee(name,address,city,pin,phone) values('"+name+"','"+address+"','"+city+"','"+pin+"','"+phone+"')";
            System.out.println(" Test Query : " + sqlQuery);
            int rowsAffected = st.executeUpdate(sqlQuery);
            if(rowsAffected>0){
             resultVO.setMessage("Value inserted");
            } else{
             resultVO.setMessage("Value not inserted");
        }
        }
        } catch(Exception e){
            e.getMessage();
        }
        return resultVO;
    }



        public EmployeeInfoVO populateEmployeeInfo(String employeeId) {
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
            try{
            if (null != employeeId) {               
            Connection conn=dbConnectionDaoImpl.dbConnect();
            Statement  st = conn.createStatement();
            String  sqlQuery = "select * from employee where employee_id ="+employeeId;
            System.out.println(" Test Query : " + sqlQuery);
            ResultSet rs = st.executeQuery(sqlQuery);
            if(rs.next()){
               employeeInfoVO.setEmployeeId(rs.getString("employee_id"));
               employeeInfoVO.setName(rs.getString("name"));
               employeeInfoVO.setPhone(rs.getString("phone"));
               employeeInfoVO.setAddress(rs.getString("address"));
               employeeInfoVO.setCity(rs.getString("city"));
               employeeInfoVO.setPin(rs.getString("pin"));
            }
            
            }
        } catch(Exception e){
            e.getMessage();
        }
        return employeeInfoVO;
    }





    public ResultVO deleteEmployeeInfo(String employeeId) {
    ResultVO resultVO = new ResultVO();
        try{
        if(null!= employeeId){
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn=dbConnectionDaoImpl.dbConnect();
        Statement  st = conn.createStatement();
        String  sqlQuery = "delete from employee where employee_id="+employeeId;
        System.out.println(" Test Query : " + sqlQuery);
        int rowsAffected = st.executeUpdate(sqlQuery);
        if(rowsAffected>0){
             resultVO.setMessage("One row deleted");
            } else{
             resultVO.setMessage("No row deleted");
            }    
        }   
    }   catch(Exception e){
        e.getMessage();
             }
        return resultVO;
    }

 
    
    public EmployeeInfoVO modifyEmployeeInfo(EmployeeInfoVO employeeInfoVO){
     if(null != employeeInfoVO){
            String employeeId = employeeInfoVO.getEmployeeId();
            String name = employeeInfoVO.getName();
            String address = employeeInfoVO.getAddress();
            String city = employeeInfoVO.getCity();
            String phone = employeeInfoVO.getPhone();
            String pin = address = employeeInfoVO.getPin();
          try{
             DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
        Connection conn=dbConnectionDaoImpl.dbConnect();
        Statement  st = conn.createStatement();
            String updateQuery = "update employee set name='"+name+"',address='"+address+"', city='"+city+"',pin='"+pin+"',phone='"+phone+"' where employee_id="+employeeId;
            System.out.println(" updateQuery : " + updateQuery);
            int rowsAffected=st.executeUpdate(updateQuery);
            if(rowsAffected>0){               
            }          
        } catch(Exception e){
            e.getMessage();
        }
     }
      return employeeInfoVO;
 }



    public ResultVO searchEmployeeInfo(String employeeId) {
    ResultVO resultVO = new ResultVO();
            try{
            if (null != employeeId) {
            DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn=dbConnectionDaoImpl.dbConnect();
            Statement  st = conn.createStatement();
            String  sqlQuery = "select * from employee where ";
            System.out.println(" Test Query : " + sqlQuery);
            int rowsAffected = st.executeUpdate(sqlQuery);
            if(rowsAffected>0){

             resultVO.setMessage("");
            } else{
             resultVO.setMessage("");
        }
        }
        } catch(Exception e){
            e.getMessage();
        }
        return resultVO;
    }




    public boolean userValidation(UserProfileVO userProfileVO) {
        String dbUser = null;
        String dbPassword = null;
        String user = userProfileVO.getUser();
        String password = userProfileVO.getPassword();
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            try {
            Connection conn = dbConnectionDaoImpl.dbConnect();
            String sqlQuery = "select * from login where user ='" + user + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                dbUser = rs.getString("user");
                dbPassword = rs.getString("password");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (user.equals(dbUser) && password.equals(dbPassword)) {
            return true;
        } else {
            return false;
        }
    }

    

    public List<EmployeeInfoVO> viewAllEmployeeInfo() {
       List<EmployeeInfoVO>  listOfEmployee=new ArrayList<EmployeeInfoVO>();
        try{        
        DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
            Connection conn=dbConnectionDaoImpl.dbConnect();
            Statement  st = conn.createStatement();
            String  sqlQuery = "select * from employee";
               ResultSet rs = st.executeQuery(sqlQuery);
                   EmployeeInfoVO employeeInfoVO = null;
               while(rs.next()){
                   employeeInfoVO =new EmployeeInfoVO();
                   employeeInfoVO.setEmployeeId(rs.getString("employee_id"));
                   employeeInfoVO.setName(rs.getString("Name"));
                   employeeInfoVO.setAddress(rs.getString("address"));
                   employeeInfoVO.setCity(rs.getString("city"));
                   employeeInfoVO.setPin(rs.getString("pin"));
                   employeeInfoVO.setPhone(rs.getString("phone"));
                     listOfEmployee.add(employeeInfoVO);  
      }
        }
        catch(Exception e){
            e.getMessage();
        }
       return listOfEmployee;
    }
    
    
    
    
    public ResultVO storeCallInfo(EmployeeInfoVO employeeInfoVO) {
        ResultVO resultVO = new ResultVO();
        try{
        if (null != employeeInfoVO) {
            String callingperson = employeeInfoVO.getCallingperson();
            String phoneno = employeeInfoVO.getPhoneno();
            String callingpurpose = employeeInfoVO.getCallingpurpose();
            String followuplevel = employeeInfoVO.getFollowuplevel();
            String status = employeeInfoVO.getStatus();
     
            Connection conn=dbConnectionDaoImpl.dbConnect();
            Statement  st = conn.createStatement();
            String  sqlQuery = "insert into application(callingperson,phoneno,callingpurpose,followuplevel,status) values('"+callingperson+"','"+phoneno+"','"+callingpurpose+"','"+followuplevel+"','"+status+"')";
            System.out.println(" Test Query : " + sqlQuery);
            int rowsAffected = st.executeUpdate(sqlQuery);
            if(rowsAffected>0){
             resultVO.setMessage("Value inserted");
            } else{
             resultVO.setMessage("Value not inserted");
        }
        }
        } catch(Exception e){
            e.getMessage();
        }
        return resultVO;
    }

  }