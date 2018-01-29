
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>


     <html:form action="viewEmpRecord">
            <table  border="0" align="center">
                <tr>
                    <td>&nbsp;</td>
                    <td>
                         <%
                        String message = (String) request.getAttribute("message_failure");
                        if (null != message) {
                    %>
                    <font color="green" style="font-weight: bold"> <%=message%> </font>
                    <%
                    } 
                    %>
                    </td>
                </tr>
                <tr>
                    <td>Employee Id /Employee Name:</td>
                    <td><html:text name="employeeActionFormBean" property="data"></html:text></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><html:submit value="Search"></html:submit> </td>
                </tr>
            </table>
        </html:form>
   