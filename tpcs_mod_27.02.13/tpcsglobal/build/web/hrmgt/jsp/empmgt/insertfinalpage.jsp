<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<table border="0" align="center" width="100%" >
        <thead>
            <tr>
                <th colspan="2"><h2>Your Office Details</h2></th>

</tr>
</thead>
<tbody>
    <tr>
        <td>
            <bean:message key="key.name"/>
            
        </td>
        <td>            
            <h4 style="color:#3300CC"><bean:write name="employeeProfFormBean" property="name"/></h4>
        </td>
    </tr>
     <tr>
        <td>
           Your Employee Id
            
        </td>
        <td>            
            <h4 style="color:#3300CC">  <bean:write name="storeFinanDetBean" property="employeeId"/></h4>
        </td>
    </tr>
    <tr>
        <td></td>
        <td> <h3 style="color:#FF0000">Your Registration Complete</h3></td>
    </tr>
    </tbody>
</table>  
