<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<div align="centre">
    <tr>
        <logic:iterate id="employeeActionFormBean" name="employeeActionFormBean" property="ListOfEmployee">
        <tr>
            <td><bean:write name="employeeActionFormBean" property="name"/></td>
        </tr>
        <tr>
            <td><bean:write name="employeeActionFormBean" property="address"/></td>
        </tr>
        <tr>
            <td><bean:write name="employeeActionFormBean" property="city"/></td>
        </tr>
        <tr>
            <td><bean:write name="employeeActionFormBean" property="pin"/></td>
        </tr>
        <tr>
            <td><bean:write name="employeeActionFormBean" property="phone"/></td>
        </tr>
        <td><a href="deleteEmployeeRecord.do?"><bean:write name="employeeActionFormBean" property="delete"/></a>delete</td>
        </logic:iterate>

    </tr>
</div>