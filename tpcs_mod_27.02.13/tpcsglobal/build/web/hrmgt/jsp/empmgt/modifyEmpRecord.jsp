<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<div align="center">
    <h3>Employee Records</h3>
    <html:form  action="modifyEmployeeRecord">
        <table bgcolor="#8ad0ff" border="1" cellpadding="2" cellspacing="2">
            
            <tr>

                <td>

                    <table border="0" align="center">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="2">
                                    <input type="text" name="employeeId" value="<bean:write name="employeeActionFormBean" property="employeeId"/>" readonly="true"/>

                                </td>
                            </tr>
                            <tr>
                                <td>Name ::</td>
                                <td><input type="text" name="name" value="<bean:write name="employeeActionFormBean" property="name"/>"/></td>
                            </tr>
                            <tr>
                                <td>Address ::</td>
                                <td><input type="text" name="address" value="<bean:write name="employeeActionFormBean" property="address"/>"/></td>
                            </tr>
                            <tr>
                                <td>City ::</td>
                                <td><input type="text" name="city" value="<bean:write name="employeeActionFormBean" property="city"/>"/></td>
                            </tr>
                            <tr>
                                <td>Pin ::</td>
                                <td><input type="text" name="pin" value="<bean:write name="employeeActionFormBean" property="pin"/>"/></td>
                            </tr>
                            <tr>
                                <td>Phone ::</td>
                                <td><input type="text" name="phone" value="<bean:write name="employeeActionFormBean" property="phone"/>"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><html:submit/></td>
                            </tr>
                        </tbody>
                    </table>

                </td>
            </tr>

        </table>
    </div>
</html:form>
