/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.vo;

/**
 *
 * @author TPCS
 */
public class NewsEventVO {
 
    private String title;
    private String date;
    private String newsdetails;
    private int userid;
    public String getDate() {
        return date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewsdetails() {
        return newsdetails;
    }

    public void setNewsdetails(String newsdetails) {
        this.newsdetails = newsdetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the userid
     */
    
}
