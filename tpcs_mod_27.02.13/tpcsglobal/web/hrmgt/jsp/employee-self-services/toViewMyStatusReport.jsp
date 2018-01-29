<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div align="center"  style="margin-top: 10px">

    <%

        String failureStatus = (String) request.getAttribute("failureStatus");

        if (null != failureStatus) {

    %>

    <h4><font color="green">

        <center><%=failureStatus%></center>

        </font> </h4>  
        <%}%>   
</div>
<html:form  action="view-my-status-report.do">
    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>View My Daily Status Report </h3></th>

</tr>
</thead>
<tbody>
    <tr>
        <td>
            Insert The Date Field
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="dateofstatusreport" styleId="inputField" />
            <br/><font color="red"><html:errors property="dateofstatusreport" prefix=""></html:errors></font>
        </td>
    </tr>
    
    <tr>
        <td></td>
        <td><html:submit/></td>
</tr>
</tbody>
</table>
    
</html:form>

