<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"%>



 <table border="1" cellpadding="2" cellspacing="0">
     <thead>
<th height="25px;" bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Employee ID</font>
</th>

<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Status Description</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Billable Hours</font>
</th>

<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Non BIllable Hours</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Active Status</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Reject Status</font>
</th>



</thead>

<logic:iterate id="viewDailyStatusReportBean" name="viewDailyStatusReportBean" property="listStatusReport">
    <tr>
        <td>
         <bean:write name="viewDailyStatusReportBean" property="resourceId"/>
        </td>
        <td>
         <bean:write name="viewDailyStatusReportBean" property="statusReportDescription"/>
        </td>
        <td>
         <bean:write name="viewDailyStatusReportBean" property="billableHours"/>
        </td>
         <td>
         <bean:write name="viewDailyStatusReportBean" property="nonBillableHours"/>
    </td>
        <td>
            <a href="activeStatus.do?status=<bean:write name="viewDailyStatusReportBean" property="statusReportId"/>" onclick="return confirm('Are You Sure Want To Activate?')" >Activate</a>
        </td>
        <td>
            <a href="rejectStatus.do?status=<bean:write name="viewDailyStatusReportBean" property="statusReportId"/>" onclick="return confirm('Are You Sure Want To Rejected?')" >Rejected</a>
        </td>
    </tr>
    </logic:iterate>
</table>