/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.dao.impl;

import com.tpcs.admin.taskmgt.dao.LovServicesDao;
import com.tpcs.admin.taskmgt.vo.ListOfValuesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pankaj
 */
public class LovServicesDaoImpl implements LovServicesDao {
 DbConnectionDaoImpl dbConnectionDaoImpl = new DbConnectionDaoImpl();
    @Override
    public List <ListOfValuesVO> populateTaskCategoryList() {
        List<ListOfValuesVO> listOfCategoryList =new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from task_category";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("task_category_name"));
                listOfValuesVO.setValue(rs.getString("task_category_id"));
                listOfCategoryList.add( listOfValuesVO );
            }
        } 
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfCategoryList;
    }

    @Override
    public List<ListOfValuesVO> populateTaskList() {
        List<ListOfValuesVO> listOfTasKList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from task_project";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("task_project_name"));
                listOfValuesVO.setValue(rs.getString("task_project_id"));
                listOfTasKList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfTasKList;
    }
    public List<ListOfValuesVO> populateParentIouList(){
        List<ListOfValuesVO> listOfParentIouList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_parent_iou";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                 ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("parent_iou_name"));
                listOfValuesVO.setValue(rs.getString("parent_iou_id"));
                listOfParentIouList.add(listOfValuesVO);
            }
        }catch(Exception exception){
             System.out.println("Message: " +exception.getMessage());
        }
        return listOfParentIouList;
    }

    @Override
    public List<ListOfValuesVO> populateUserProfileList() {
      List<ListOfValuesVO> listOfUserProfileList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from user_profile";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("user_call_name"));
                listOfValuesVO.setValue(rs.getString("user_id"));
                listOfUserProfileList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfUserProfileList;
    }

    @Override
    public List<ListOfValuesVO> populateTaskStatusList() {
        List<ListOfValuesVO> listOfStatusList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from task_status";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("task_status_name"));
                listOfValuesVO.setValue(rs.getString("task_status_id"));
                listOfStatusList.add(listOfValuesVO);
            }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfStatusList;
    }
     @Override
    public List<ListOfValuesVO> populateTpcsLocationList() {
      List<ListOfValuesVO> listOfLocationProfileList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_location";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("location_name"));
                listOfValuesVO.setValue(rs.getString("location_id"));
                listOfLocationProfileList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfLocationProfileList;
    }
       @Override
    public List<ListOfValuesVO> populateGradeList() {
      List<ListOfValuesVO> listOfLocationProfileList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_grade";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("grade_value"));
                listOfValuesVO.setValue(rs.getString("grade_id"));
                listOfLocationProfileList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfLocationProfileList;
    }
        @Override
    public List<ListOfValuesVO> populateDesignationList() {
      List<ListOfValuesVO> listOfDesignationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_designation";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("designation"));
                listOfValuesVO.setValue(rs.getString("designation_id"));
                listOfDesignationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfDesignationList;
    }
         @Override
    public List<ListOfValuesVO> populateCountryList() {
      List<ListOfValuesVO> listOfDesignationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from country_details";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("county_name"));
                listOfValuesVO.setValue(rs.getString("country_code"));
                listOfDesignationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfDesignationList;
    }
          @Override
    public List<ListOfValuesVO> populateLocationList() {
      List<ListOfValuesVO> listOfDesignationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from location_details";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("location_name"));
                listOfValuesVO.setValue(rs.getString("location_id"));
                listOfDesignationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfDesignationList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsUgQualification() {
         List<ListOfValuesVO> listOfUgQualificationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from ug_qualification";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("ug_qualification"));
                listOfValuesVO.setValue(rs.getString("ug_qualification_id"));
                listOfUgQualificationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfUgQualificationList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsPgQualification() {
         List<ListOfValuesVO> listOfPgQualificationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from pg_qualification";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("pg_qualification"));
                listOfValuesVO.setValue(rs.getString("pg_qualification_id"));
                listOfPgQualificationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfPgQualificationList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsUgSpecialization() {
        List<ListOfValuesVO> listOfUgSpecializationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from ug_specialozation";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("ug_specialization"));
                listOfValuesVO.setValue(rs.getString("ug_specialization_id"));
                listOfUgSpecializationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfUgSpecializationList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsUgUniversity() {
        List<ListOfValuesVO> listOfUgUniversityList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from ug_university";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("ug_university"));
                listOfValuesVO.setValue(rs.getString("ug_university_id"));
                listOfUgUniversityList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfUgUniversityList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsPgSpecialization() {
        List<ListOfValuesVO> listOfPgSpecializationList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from pg_specialization";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("pg_specialization"));
                listOfValuesVO.setValue(rs.getString("pg_specialization_id"));
                listOfPgSpecializationList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfPgSpecializationList;
    }

    @Override
    public List<ListOfValuesVO> populateTpcsPgUniversity() {
       List<ListOfValuesVO> listOfPgUniversityList=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from pg_university";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("pg_university"));
                listOfValuesVO.setValue(rs.getString("pg_university_id"));
                listOfPgUniversityList.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfPgUniversityList;
    }
    
    


    @Override
 public List<ListOfValuesVO> populateTpcsLocationId() {
         List<ListOfValuesVO> listOfLocationId=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_location";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("location_name"));
                listOfValuesVO.setValue(rs.getString("location_id"));
                listOfLocationId.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfLocationId;
    }
    @Override
  public List<ListOfValuesVO> populateTpcsGradeId() {
         List<ListOfValuesVO> listOfGradeId=new ArrayList<ListOfValuesVO>();
        try{
            String sqlQuery="select * from tpcs_grade";
            Connection conn=dbConnectionDaoImpl.dbConnect();
            PreparedStatement pstmt=conn.prepareStatement(sqlQuery);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                ListOfValuesVO listOfValuesVO=new ListOfValuesVO();
                listOfValuesVO.setLebel(rs.getString("grade_value"));
                listOfValuesVO.setValue(rs.getString("grade_id"));
                listOfGradeId.add(listOfValuesVO);
              }
        }
        catch(Exception exception){
            System.out.println("Message: " +exception.getMessage());
        }
        return listOfGradeId;
    }
 }