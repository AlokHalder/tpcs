/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.util;

/**
 *
 * @author ibm
 */
public class DateConversion {

    public static String convertDbDate(String date) {
        String returnDate = null;
        if (null != date) {
            String year = date.substring(0, 4);
            String month = date.substring(5, 7);
            String day = date.substring(8, 10);

            returnDate = day + "/" + month + "/" + year;
        }

        return returnDate;

    }

    public static String convertEmpDate(String date) {
        String returnDate = null;
        if (null != date) {
            String month = date.substring(0, 2);
            String day = date.substring(3, 5);
            String year = date.substring(6, 10);

            returnDate = day + "/" + month + "/" + year;
        }

        return returnDate;

    }

    public static String convertUiDate(String date) {
        String returnDate = null;
        if (null != date) {
            String day = date.substring(0, 2);
            String month = date.substring(3, 5);
            String year = date.substring(6, 10);

            returnDate = year + "-" + month + "-" + day;
        }
        return returnDate;
    }
}
