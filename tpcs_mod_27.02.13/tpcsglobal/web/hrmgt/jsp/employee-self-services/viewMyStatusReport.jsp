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
    <font color="#800000" style="font-weight:bold">Status</font>
</th>


</thead>

<logic:iterate id="viewMyDailyStatusReportBean" name="viewMyDailyStatusReportBean" property="listStatusReport">
    <tr>
        <td>
         <bean:write name="viewMyDailyStatusReportBean" property="resourceId"/>
        </td>
        <td>
         <bean:write name="viewMyDailyStatusReportBean" property="statusReportDescription"/>
        </td>
        <td>
         <bean:write name="viewMyDailyStatusReportBean" property="billableHours"/>
        </td>
         <td>
         <bean:write name="viewMyDailyStatusReportBean" property="nonBillableHours"/>
        </td>
        <td>
         <bean:write name="viewMyDailyStatusReportBean" property="status"/>
        </td>
    </tr>
    </logic:iterate>
</table>