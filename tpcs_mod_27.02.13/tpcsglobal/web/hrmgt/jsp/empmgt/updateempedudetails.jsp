<%@page import="com.tpcs.employee.formbean.EmployeeActionFormBean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center"  style="margin-top: 10px">

    <%

        String messge_personal = (String) request.getAttribute("messge_education");

        if (null != messge_personal) {

    %>

    <h4><font color="green">

        <center><%=messge_personal%></center>

        </font> </h4>  
        <%}%>   
</div>

<html:form  action="updateEmpEduRecord" styleId="trip">

    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Update Employee Educational Record </h3></th>

</tr>
</thead>
<tbody>
   
    <tr>
        <td>Under Graduate Qualification:
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="ug_qualification">
              
                <html:optionsCollection name="insertUserEduBean" property="listOfUgQualification" label="lebel" value="value"/>                   
            </html:select>
                <br/>
            <font color="red"><html:errors property="ug_qualification" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Under Graduate Specialization:
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="ug_specialization">
                <html:optionsCollection name="insertUserEduBean" property="listOfUgSpecialization" label="lebel" value="value"/>                   
            </html:select>
            <br/>
            <font color="red"><html:errors property="ug_specialization" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
            Year Of Pass out:
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:select property="ug_passout">
                <html:option value="2012">2012</html:option>
                <html:option value="2011">2011</html:option>
                <html:option value="2010">2010</html:option>
                <html:option value="2009">2009</html:option>
                <html:option value="2008">2008</html:option>
            </html:select>
            <br/><font color="red"> <html:errors property="ug_passout" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Under Graduate University:
            <font color="red">  <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="ug_university">
                <html:optionsCollection name="insertUserEduBean" property="listOfUgUniversity" label="lebel" value="value"/>                   
            </html:select>
            <br/>
            <font color="red"><html:errors property="ug_university" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Post Graduate Qualification:
        </td>
       
        <td>
            <html:select property="pg_qualification">
                <html:optionsCollection name="insertUserEduBean" property="listOfPgQualification" label="lebel" value="value"/>                   
            </html:select>
        </td>
    </tr>
    <tr>
        <td>Post Graduate Specialization:
        </td>
        <td>
            <html:select property="pg_specialization">
                <html:optionsCollection name="insertUserEduBean" property="listOfPgSpecialization" label="lebel" value="value"/>                   
            </html:select>
            </td>
        </tr>
        <tr>
            <td>
                Post Graduate Year Of Pass out:
        </td>
        <td><html:select property="pg_passout">
                <html:option value="">Select The Year</html:option>
                <html:option value="2012">2012</html:option>
                <html:option value="2011">2011</html:option>
                <html:option value="2010">2010</html:option>
                <html:option value="2009">2009</html:option>
                <html:option value="2008">2008</html:option>
            </html:select>
        </tr>
        <tr>
            <td>Post Graduate University:
        </td>
        <td>
            <html:select property="pg_university">
                <html:optionsCollection name="insertUserEduBean" property="listOfPgUniversity" label="lebel" value="value"/>                   
            </html:select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/></td>
    </tr>
</tbody>
</table>

</html:form>
