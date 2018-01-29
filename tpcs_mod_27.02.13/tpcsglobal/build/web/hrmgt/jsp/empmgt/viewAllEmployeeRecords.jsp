<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"%>
<body bgcolor="#8ad0ff">
<div align="center">
    <h4> All Employee Records </h4>
    <%
        String message = (String) request.getAttribute("message");
        if (null != message) {
    %>
    <h4> <font color="green"> <%=message%></font></h4>
        <%
            }
        %>
     <table border="1" cellpadding="2" cellspacing="0">

<logic:iterate id="employeeActionFormBean" name="employeeActionFormBean" property="listOfEmployee">
    <tr>
        <td>
         <bean:write name="employeeActionFormBean" property="employeeId"/>
        </td>
        <td>
         <bean:write name="employeeActionFormBean" property="name"/>
        </td>
        <td>
         <bean:write name="employeeActionFormBean" property="designation"/>
        </td>
         <td>
         <bean:write name="employeeActionFormBean" property="city"/>
        </td>
         <td>
         <bean:write name="employeeActionFormBean" property="pin"/>
        </td>
         <td>
         <bean:write name="employeeActionFormBean" property="phone"/>
        </td>
        <td>
         <bean:write name="employeeActionFormBean" property="emailid"/>
        </td>
        <td><a href="viewEmpRecord.do?data=<bean:write name="employeeActionFormBean" property="employeeId"/>" >View Details</a></td>
        <!--<td><a href="deleteEmpRecord.do?employeeId=<!--bean:write name="employeeActionFormBean" property="employeeId"/>">Delete</a></td>-->
       <!-- <td><a href="modifyEmpInfo.do?employeeId=--><!--bean:write name="employeeActionFormBean" property="employeeId"/>">Modify</a></td>-->

    </tr>
</logic:iterate>
</table>
</div>
</body>