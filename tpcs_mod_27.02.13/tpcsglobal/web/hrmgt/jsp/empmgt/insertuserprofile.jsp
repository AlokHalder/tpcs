<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form  action="inseruserprofinfo" styleId="trip">

      
    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Store User Profile </h3></th>

</tr>

</thead>
<tbody>
    <tr>
        <td colspan="2">
              <%

        String message_userprof = (String) request.getAttribute("message_userprof");

        if (null != message_userprof) {

    %>

    <h4><font color="green">

        <center><%=message_userprof%></center>

        </font> </h4>  
        <%}%>   
        </td>
    </tr>
      <tr>
        <td>
            <bean:message key="key.employeeid"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="employeeId" /><br/>
            <font color="red"> <html:errors property="employeeId" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.name"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="name" onblur="camelCaps('name')" styleId="name"/><br/>
            <font color="red"> <html:errors property="name" prefix=""></html:errors></font>
        </td>
    </tr>

    <tr>
        <td><bean:message key="key.password"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:password property="password"/><br>
         <font color="red"> <html:errors property="password" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.designation"/>
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="designation">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertUserProfBean" property="listOfDesignation" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="designation" prefix=""></html:errors></font>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/></td>
    </tr>
</tbody>
</table>
</html:form>