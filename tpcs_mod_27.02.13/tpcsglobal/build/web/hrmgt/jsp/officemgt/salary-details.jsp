<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib  uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<h3> Associate Details</h3><br/><br/><br/>
<div>
    <table  border="0" width="100%" align="center" bgcolor="white">
        <tr>
            <td colspan="3"><font color="#800000" style="font-weight: bold"> Personal Details </font> </td>
        </tr>
        <tr>
            <td>Employee Id :</td>
            <td><bean:write name="searchSalaryFormBean" property="employeeId"/></td>
        <tr>
            <td>Employee Name:</td>
            <td><bean:write name="searchSalaryFormBean" property="name"/></td>

        </tr>
        <tr>
            <td>Salary:</td>
            <td><bean:write name="searchSalaryFormBean" property="salary"/></td>                    
        </tr>   
        <tr>
            <td>Starting Date:</td>
            <td><bean:write name="searchSalaryFormBean" property="startingdate"/></td>                    
        </tr>
        <tr>
            <td>Ending Date:</td>
            <td><bean:write name="searchSalaryFormBean" property="endingdate"/></td>                    
        </tr>
        <tr>
            <td>Payment Date </td>
            <td><bean:write name="searchSalaryFormBean" property="paymentdate"/></td>                    
        </tr>
        <tr>
            <td>Payment Type</td>
            <td><bean:write name="searchSalaryFormBean" property="paymenttype"/></td>                    
        </tr>
       
    </table>
</div>

