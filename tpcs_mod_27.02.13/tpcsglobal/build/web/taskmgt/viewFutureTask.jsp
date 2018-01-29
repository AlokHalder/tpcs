<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"%>
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
<body bgcolor="#8ad0ff">
    <table border="1" cellpadding="10" cellspacing="1">

<logic:iterate id="futureTaskBean" name="futureTaskBean" property="listOffutureTaskReport">
    <tr>
        <td>
         <bean:write name="futureTaskBean" property="tasktitle"/>
        </td>
        <td>
         <bean:write name="futureTaskBean" property="taskdes"/>
        </td>
         <td>
         <bean:write name="futureTaskBean" property="taskstartdate"/>
        </td>
         <td>
         <bean:write name="futureTaskBean" property="taskcompdate"/>
        </td>
         <td>
         <bean:write name="futureTaskBean" property="taskpriority"/>
        </td>
        
        <td><a href="deleteFutureTask.do?futureTaskId=<bean:write name="futureTaskBean" property="futureTaskId"/>">Delete</a></td>
    </tr>
</logic:iterate>
</table>
</div>
    
    
    
</body>