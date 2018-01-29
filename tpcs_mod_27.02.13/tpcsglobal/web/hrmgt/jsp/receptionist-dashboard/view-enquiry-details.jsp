
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table border="1" cellpadding="0" cellspacing="0">
   
<thead >
<th height="25px;" bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Sr.&nbsp;No</font>
</th>    
<th height="25px;" bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Interviewee&nbsp;Name</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Contact&nbsp;No.</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Alternative&nbsp;Contact&nbsp;No.</font>
</th>
<th bgcolor="orange" height="25px;">
    <font color="#800000" style="font-weight:bold">Email Id</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Qualification</font>
</th>
<th bgcolor="orange"><font color="#800000" style="font-weight:bold">Remarks</font>
</th>

</thead>
<% int i = 0;%>
<logic:iterate name="viewEnquiryReportFormBean" property="listOfEnquiry" id="listOfEnquiry">
    <% i++;
        if (i % 2 == 0) {
    %>
    <tr bgcolor="#E2F4FF" valign="top" style="padding-top:5px">
        <%                                                                    } else {%>
    <tr valign="top" bgcolor="lightgrey">
        <%}%>
         <td>
            <%=i%>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="name"/>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="contactNo"/>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="altcontactNo"/>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="emailId"/>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="qualification"/>
        </td>
        <td>
            <bean:write name="listOfEnquiry" property="remarks"/>
        </td>
        </tr>


</logic:iterate>

</table>
        
        
        
