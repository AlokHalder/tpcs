<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div align="center"  style="margin-top: 10px">

    <%
        String message = (String) request.getAttribute("message");
        if (null != message) {
    %>
    <h4> <font color="green"> <%=message%></font></h4>
        <%
            }
        %>
</div>

<html:form  action="storeEmpRecord" styleId="trip">

    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Store Employee Record </h3></th>

</tr>
</thead>
<tbody>
    <tr>
        <td>
            <bean:message key="key.name"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="name" /><br/>
            <font color="red"> <html:errors property="name" prefix=""></html:errors></font>
        </td>
    </tr>
    
    <tr>
        <td>Address :</td>
        <td><html:textarea rows="4" cols="20" property="address"/></td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.dateofbirth"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="dateofbirth" styleId="joinofdate1" />(dd/mm/yyyy)
            <br/><font color="red"><html:errors property="dateofbirth" prefix=""></html:errors></font>
        </td>
    </tr>
    
    <tr>
        <td>
            <bean:message key="key.maritalstatus"/>
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:radio property="maritalstatus" value="U"/>Unmarried 
            <html:radio property="maritalstatus" value="M"/>Married 
            <html:radio property="maritalstatus" value="D"/>Divorce
            <html:radio property="maritalstatus" value="W"/>Widowed
            <br/>
           <font color="red"><html:errors property="maritalstatus" prefix=""></html:errors></font>
        </td>
    </tr>
    
    <tr>
        <td>
            <bean:message key="key.dateofjoining"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="dateofjoining" styleId="enddate"/>(dd/mm/yyyy)
           <br/><font color="red"><html:errors property="dateofjoining" prefix=""></html:errors></font>
        </td>
    </tr>
   
    <tr>
        <td>Grade/Brand :</td>
        <td>
            <html:select property="grade">
                <html:optionsCollection name="insertEmpFormBean" property="listOfGradeProfile" label="lebel" value="value"/>                   
            </html:select>
        </td>
    </tr>
    <tr>
        <td>Deputed Location :</td>
        <td>
            <html:select property="deputedlocation">
                <html:optionsCollection name="insertEmpFormBean" property="listOfLocationProfile" label="lebel" value="value"/>                   
            </html:select>
        </td>

    </tr>
    <tr>
        <td>Employee Type :</td>
        <td><html:select property="employeetype">
                <html:option value="P">Permanent</html:option>
                <html:option value="T">Trainee</html:option>
                <html:option value="C">Contract Basis</html:option>
            </html:select>
        </td>
    </tr>
    <tr>
        <td>Gender :</td>
        <td><html:radio property="gender" value="M"/> Male
            <html:radio property="gender" value="F"/> Female
        </td>
    </tr>
    <tr>
        <td>Nationality :</td>
        <td>
            <html:select property="nationality">
                <html:option value="IND">Indian</html:option>
            </html:select>
        </td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.designation"/>
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="designation">
                <html:optionsCollection name="insertEmpFormBean" property="listOfDesignation" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="designation" prefix=""></html:errors></font>
        </td>
    </tr>
   
    <tr>
        <td>
            <bean:message key="key.employmentstatus"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:select property="employmentstatus">
                <html:option value="1">Active</html:option>
                <html:option value="0">Non-Active</html:option>
            </html:select> 
          <br/> <font color="red"><html:errors property="employmentstatus" prefix=""></html:errors></font>     
        </td>
    </tr>
    
    <tr>
        <td>
            <bean:message key="key.emailid"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="emailid"/><br/>
            <font color="red"><html:errors property="emailid" prefix=""></html:errors></font>
        </td>
    </tr>
   
    <tr>
        <td>City/Location :</td>
        <td><html:text property="city"/></td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.pin"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="pin"/>
        <br/><font color="red"> <html:errors property="pin" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.phone"/>
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="phone"/>
        <br/><font color="red">  <html:errors property="phone" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><html:submit/></td>
    </tr>
</tbody>
</table>
<%

    String Employee_id = (String) request.getAttribute("Employee_id");

    if (null != Employee_id) {

%>

<h4><font color="green">

    <center> Your Employee Id:<%=Employee_id%></center>

    </font> </h4>  
    <%}%>            

</html:form>
