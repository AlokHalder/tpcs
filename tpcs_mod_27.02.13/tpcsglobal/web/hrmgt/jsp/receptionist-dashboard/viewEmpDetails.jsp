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
            <td><bean:write name="employeeActionFormBean" property="employeeId"/></td>
            <td rowspan="3"><img src="associates-photo/<bean:write name="employeeActionFormBean" property="employeeId"/>.jpg" height="100px" width="100px" /></td>
        </tr>
        <tr>
            <td>Employee Name:</td>
            <td><bean:write name="employeeActionFormBean" property="name"/></td>

        </tr>
        <tr>
            <td>Designation:</td>
            <td><bean:write name="employeeActionFormBean" property="designation"/></td>                    
        </tr>    
        </td>
        </tr>
    </table>
</div>
<div>
    <table  border="0" width="100%" align="center" bgcolor="white">
        <tr>
            <td colspan="2"><font color="#800000" style="font-weight: bold">Location Details </font> </td>
        </tr>
       
        <tr>
            <td>Base Branch:</td>
            <td><bean:write name="employeeActionFormBean" property="baselocation"/></td>                  
        </tr>
        <tr>
            <td>Deputed Branch</td>
            <td><bean:write name="employeeActionFormBean" property="deputedlocation"/></td>                    
        </tr>    
        </td>
        </tr>
    </table>
</div>   

<div>
    <table  border="0" width="100%" align="center" bgcolor="white">
        <tr>
            <td colspan="2"><font color="#800000" style="font-weight: bold">Contact Details </font> </td>
        </tr>
        <tr>
            <td width="42%"> Address :</td>
            <td><bean:write name="employeeActionFormBean" property="address"/></td>                       
        </tr>
        <tr>
            <td>Location :</td>
            <td><bean:write name="employeeActionFormBean" property="city"/></td>                   
        </tr>
        <tr>
            <td>Pin : </td>
            <td><bean:write name="employeeActionFormBean" property="pin"/></td>                    
        </tr>    
        <tr>
            <td>Phone Number: </td>
            <td><bean:write name="employeeActionFormBean" property="phone"/></td>                    
        </tr> 
        <tr>
            <td>Email : </td>
            <td> <a href="mailto:tpcsglobal.com:2095">
                    <bean:write name="employeeActionFormBean" property="emailid"/>
                </a>
            </td>                    
        </tr>    
        </td>
        </tr>
    </table>
</div>           

<div>
    <table  border="0" width="100%" align="center" bgcolor="white">
        <tr>
            <td colspan="2"><font color="#800000" style="font-weight: bold">Reporting Structure </font> </td>
        </tr>
        <tr>
            <td width="42%"> Supervisor ID :</td>
            <td><bean:write name="employeeActionFormBean" property="supervisorId"/></td>                       
        </tr>
        <tr>
            <td>Supervisor Name :</td>
            <td><a href="searchEmpRecord.do?data=<bean:write name="employeeActionFormBean" property="supervisorId"/>"><bean:write name="employeeActionFormBean" property="supervisorName"/></a></td>                   
        </tr>
        <tr>
            <td>Parent Business Unit Name : </td>
            <td><bean:write name="employeeActionFormBean" property="parentIouName"/></td>                    
        </tr>    
        <tr>
            <td> Sub Business Unit Name : </td>
            <td><bean:write name="employeeActionFormBean" property="subIouName"/></td>                    
        </tr> 

        </td>
        </tr>
    </table>
</div>       
<div>
    <table  border="0" width="100%" align="center" bgcolor="white">
        <tr>
            <td colspan="2"><font color="#800000" style="font-weight: bold">Profile Status </font> </td>
        </tr>
        <tr>
            <td width="42%">Date Of Joining :</td>
            <td><bean:write name="employeeActionFormBean" property="dateofjoining"/></td>                       
        </tr>
        
        <!--logic:present name="employeeActionFormBean" property="releaseDate"-->
           <!-- <tr> 
                <td>Date Of Release from Company:</td>
                <td>--><!--bean:write name="employeeActionFormBean" property="releaseDate"/></td>                   
            </tr-->
        <!--/logic:present>-->
        <tr>
            <td>Profile Status</td>
            <td><bean:write name="employeeActionFormBean" property="profileStatus"/></td>                   
        </tr>
        <tr>
            <td>Profile Type</td>
            <td><bean:write name="employeeActionFormBean" property="employeetype"/></td>                   
        </tr>
        
        </tr>
    </table>
</div>                
