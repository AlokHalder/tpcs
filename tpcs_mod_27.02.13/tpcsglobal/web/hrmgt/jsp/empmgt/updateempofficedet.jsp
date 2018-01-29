<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form  action="updateEmpoffiinfo" styleId="trip">
<div align="center"  style="margin-top: 10px">

    <%

        String messge_office = (String) request.getAttribute("messge_office");

        if (null != messge_office) {

    %>

    <h4><font color="green">

        <center><%=messge_office%></center>

        </font> </h4>  
        <%}%>   
</div>
      
    <table border="1" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h3>Update Your Office Details </h3></th>

</tr>
</thead>
<tbody>
   

    <tr>
        <td>Date Of Joining
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:text property="dateofjoining"/>(dd/mm/yyyy)<br>
         <font color="red"> <html:errors property="dateofjoining" prefix=""></html:errors></font>
        </td>
    </tr>
      <tr>
        <td>Employee Status
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:select property="status">
                <html:option value="">Select the Correct Option</html:option>
                <html:option value="1">Active</html:option>
                <html:option value="0">Not Active</html:option>
            </html:select><br>
         <font color="red"> <html:errors property="status" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Employee Type
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:select property="employeetype">
                <html:option value="">Select the Correct Option</html:option>
                <html:option value="Permanent">Permanent</html:option>
                <html:option value="Trainee">Trainee</html:option>
                <html:option value="Contract">Contract</html:option>
            </html:select><br>
         <font color="red"> <html:errors property="employeetype" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>Grade Id
            <font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
        <td><html:select property="grade">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfGradeId" label="lebel" value="value"/>                   
            </html:select><br>
         <font color="red"> <html:errors property="grade" prefix=""></html:errors></font>
        </td>
    </tr>
    <tr>
        <td>
           Deputed Location 
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="deputedlocation">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfLocationId" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="deputedlocation" prefix=""></html:errors></font>
            </td>
        </tr>
        <tr>
        <td>
           Base Branch
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="baselocation">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfLocationId" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="baselocation" prefix=""></html:errors></font>
            </td>
        </tr>
         <tr>
        <td>
           Supervisory name
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="supervisorId">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfSupervisoryId" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="supervisorId" prefix=""></html:errors></font>
            </td>
        </tr>
          <tr>
        <td>
           Parent IOU name
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="parentIouId">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfParentIouId" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="parentIouId" prefix=""></html:errors></font>
            </td>
        </tr>
          <tr>
        <td>
           Sub IOU name
            <font color="red"><bean:message key="key.mandatoryfield"/></font>
        </td>
        <td>
            <html:select property="subIouId">
                <html:option value="">Select the Correct Option</html:option>
                <html:optionsCollection name="insertOffDetBean" property="listOfSubIouId" label="lebel" value="value"/>                   
            </html:select>
            <br/><font color="red"><html:errors property="subIouId" prefix=""></html:errors></font>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/></td>
    </tr>
</tbody>
</table>
</html:form>