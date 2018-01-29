<%@taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic"%>

<%@taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"%>

<div>
    <p>
    <font color="red"> Time sheet is related to <a href="office-attaindance-and-leave-policy.do"> Office Attendance and Leave Policy </a> of Company . It is directly related with employee salary in end of month 
    </font>    
    </p>
      <p>
          <font color="red"> Loss of working hours will be deducted from salary of current month . Office leave time is important as well as entry time . If an associate do not submit office leave time  it will treat as loss of full working day . For details follow <a href="hours-of-work.do">Hours Of Work </a> policy of company .
    </font>    
    </p>
</div>
<table width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td><font style="color: #800000;font-weight: bold">Date</font></td>
        <td><font style="color: #800000;font-weight: bold">Entry Time</font></td>
        <td><font style="color: #800000;font-weight: bold">Leave Time</font></td>
        <td><font style="color: #800000;font-weight: bold">Office Time Spent</font></td>        
        <td><font style="color: #800000;font-weight: bold">Working Hour Loss</font></td>
        <td><font style="color: #800000;font-weight: bold">Timesheet Status</font></td>
        <td><font style="color: #800000;font-weight: bold">Remarks</font></td>
    
      
    </tr>
<logic:iterate id="officeAttendanceForm" name="officeAttendanceForm" property="listOfAttendanceReport">
       <tr>
        <td> <bean:write name="officeAttendanceForm" property="currentDateValue"/></td> 
        <td><bean:write name="officeAttendanceForm" property="officeEntryTime"/></td>
         <td><bean:write name="officeAttendanceForm" property="officeLeaveTime"/></td>
         <td><bean:write name="officeAttendanceForm" property="officeHoursSpent"/></td>   
          <td><bean:write name="officeAttendanceForm" property="officeHoursLoss"/></td>
          <td>Pending</td>     
          <td>--</td>
      
    </tr>
               
        
    </logic:iterate>
</table>
