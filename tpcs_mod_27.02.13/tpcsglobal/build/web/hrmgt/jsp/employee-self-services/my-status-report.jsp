<%@taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic"%>

<%@taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean"%>

<div>
    <p>
    <font color="red"> Regular Status report submission is related to your performance in Company . Your salary, promotion ,incentive everything is related with status report. 
    </font>    
    </p>
      <p>
          <font color="red"> Your status report should be approved by your supervisor . Status report should be in details report of your task in entire day during office hours . It should be in details report . Associate should spend at least 15 minute time to prepare it . It should not be submitted before 5:45 PM in normal working day .
    </font>    
    </p>
</div>

<table width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td><font style="color: #800000;font-weight: bold">Date</font></td>      
        <td><font style="color: #800000;font-weight: bold">Status Report</font></td>
        <td><font style="color: #800000;font-weight: bold">Approval Status</font></td>
        <td><font style="color: #800000;font-weight: bold">Remarks</font></td>
      
    </tr>
<logic:iterate id="dailyStatusReport" name="dailyStatusReportsBean" property="listOfDailyStatusReports">
       <tr>
        <td> <bean:write name="dailyStatusReport" property="statusReportDate"/></td>       
        <td width="300px"> <bean:write name="dailyStatusReport" property="statusReportDescription"/></td>  
        <td>Pending</td>     
        <td>--</td>
    </tr>
               
        
    </logic:iterate>
</table>
