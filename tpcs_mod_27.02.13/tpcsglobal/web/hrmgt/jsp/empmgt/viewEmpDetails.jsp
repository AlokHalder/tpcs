<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
  <body bgcolor="#8ad0ff">
        <div align="center"  style="margin-top: 250px">
            <h3>Employee Information System</h3>
        </div>
        
            <table  border="0" align="center">
                <tr>
                    <td>Name :</td>
                    <td><bean:write name="employeeActionFormBean" property="name"/></td>
                </tr>
                <tr>
                    <td>Address :</td>
                    <td><bean:write name="employeeActionFormBean" property="address"/></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><bean:write name="employeeActionFormBean" property="phone"/></td>
                </tr>
                <tr>
                     <td>City :</td>
                     <td><bean:write name="employeeActionFormBean" property="city"/></td>
                </tr>
                <tr>
                    <td>Pin :</td>
                    <td><bean:write name="employeeActionFormBean" property="pin"/></td>
                </tr>
                    <td>&nbsp;</td>
                    <td>
                      <html:submit>Modify</html:submit>
                    </td>
            </table>   
    </body>
</html:html>