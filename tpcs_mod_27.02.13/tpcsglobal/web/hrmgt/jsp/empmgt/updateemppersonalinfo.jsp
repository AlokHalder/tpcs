<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:form  action="updareEmpPerRecord" styleId="trip">
    <div align="center"  style="margin-top: 10px">

        <%

            String messge_personal = (String) request.getAttribute("messge_personal");

            if (null != messge_personal) {

        %>

        <h4><font color="green">

            <center><%=messge_personal%></center>

            </font> </h4>  
            <%}%>   
    </div>
    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Update Employee Personal Record </h3></th>

</tr>
</thead>
<tbody>
    <tr>
        <td>Address :
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:textarea rows="4" cols="20" property="address"/>
            <br/><font color="red">  <html:errors property="address" prefix=""></html:errors></font>
        </td>
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
            <bean:message key="key.phone"/>
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="phone"/>
            <br/><font color="red">  <html:errors property="phone" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
            <bean:message key="key.altphone"/>

        </td>
        <td><html:text property="altphone"/>

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
        <td>Location</td>
        <td>
            <html:select property="location_id">
                <html:optionsCollection name="insertUserPersBean" property="listOfLocation" label="lebel" value="value"/>                   
            </html:select>
        </td>
    </tr>
    <tr>
        <td>Country
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="country_id">
                <html:optionsCollection name="insertUserPersBean" property="listOfCountry" label="lebel" value="value"/>                   
            </html:select>
            <br/>
            <font color="red"><html:errors property="country_id" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Gender :
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:radio property="gender" value="M"/> Male
            <html:radio property="gender" value="F"/> Female
            <br/>
            <font color="red"><html:errors property="gender" prefix=""></html:errors></font>
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
        <td>
            <bean:message key="key.pin"/>
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="pin"/>
            <br/><font color="red"> <html:errors property="pin" prefix=""></html:errors></font>
        </td>
    </tr>

    <tr>
        <td></td>
        <td><html:submit/></td>
    </tr>
</tbody>
</table>

</html:form>
