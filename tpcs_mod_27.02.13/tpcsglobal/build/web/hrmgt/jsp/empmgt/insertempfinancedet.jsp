<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form  action="storeFinanDet" styleId="trip">

      <div align="center"  style="margin-top: 10px">

    <%

        String messge_professional = (String) request.getAttribute("messge_finance");

        if (null != messge_professional) {

    %>

    <h4><font color="green">

        <center><%=messge_professional%></center>

        </font> </h4>  
        <%}%>   
</div>
    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Store User Finance Details  </h3></th>

</tr>
</thead>
<tbody>
    <tr>
        <td>
            <bean:message key="key.name"/>
        </td>
        <td><input type="text" value="<bean:write name="employeeProfFormBean" property="name"/>" readonly="true"/><br/>

        </td>
    </tr>
    <tr>
        <td>
            Pan Number
        </td>
        <td><html:text property="pannumber" /><br/>
        </td>
    </tr>

    <tr>
        <td>Primary Bank Account Number
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="primarybankacc"/><br>
         <font color="red"> <html:errors property="primarybankacc" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
           Secondary Account Details
        </td>
        <td>
           <html:text property="secondarybankacc"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/></td>
    </tr>
</tbody>
</table>
</html:form>