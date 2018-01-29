<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:form  action="storeEmpPerRecord" styleId="trip">

    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Store Employee Personal Record </h3></th>

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
        <td><html:text property="dateofbirth" styleId="inputField" />(dd/mm/yyyy)
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
                <html:option value="">Select the Correct Option</html:option>
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
        <html:option value="">Select the Correct Option</html:option>
        <html:optionsCollection name="insertUserPersBean" property="listOfCountry" label="lebel" value="value"/>                   
    </html:select>
        <br/>
          <font color="red"><html:errors property="country_id" prefix=""></html:errors></font>
</td>
</tr>>


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
    <td>Nationality :</td>
    <td>
        <html:select property="nationality">
            <html:option value="IND">Indian</html:option>
            <html:option value="PAK">Pakistani</html:option>
            <html:option value="BAN">Bangladesi</html:option>
        </html:select>
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
