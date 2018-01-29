<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html>
  <body bgcolor="#8ad0ff">
        <div align="center"  style="margin-top: 250px">
            <h3>Employee Information System</h3>
        </div>
     <html:form action="viewEmpRecord">
            <table  border="0" align="center">
                <tr>
                    <td>Employee Id/Employee Name:</td>
                    <td><html:text name="employeeActionFormBean" property="data"></html:text></td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td><html:submit value="Search"></html:submit> </td>
                </tr>
            </table>
        </html:form>
    </body>
</html:html>