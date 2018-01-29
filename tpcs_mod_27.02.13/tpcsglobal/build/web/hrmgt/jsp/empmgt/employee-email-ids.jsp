<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<table align ="center">
    <tr>
        <td>
            Employees Emails Ids : 
        </td>
        <td>
            <textarea rows="25" cols="50" style="padding-left: 50px; padding-top: 10px;" readonly="true">
  <bean:write name="viewEmployeeEmailFormBean" property="employeeEmailIds" />
</textarea>
        </td>
    </tr>
</table>
