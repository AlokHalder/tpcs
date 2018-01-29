<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<h1> Leave - Apply Leave</h1> 
<p><font color="red">If an associate do not apply leave within same month,that date will be converted into Loss Of Salary Pay </font></p>
<html:form action="apply-leave" styleId="trip">
<table border="0" align="center" cellspacing="5" cellpadding="5">
    <thead>
        <tr>
            <th colspan="2">
                <%
                if(null != request.getAttribute("message")){
                %>
                <%=request.getAttribute("message")%></font>
               
                    <%
                }
                
                  
                 %>
                
            </th>
         
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Leave Type <font color="red">*</font></td>
            <td><select name="leaveType">
                    <option value="">Select Leave Type</option>
                    <option value="Sick Leave"> Sick Leave</option>
                    <option value="Casual Leave">Casual Leave</option>
                     <option value="Leave without Pay">Leave without pay</option>
                    <option value="Flexi Holiday">Flexi Holiday</option>
                     <option value="Earned Leave">Earned Leave</option>
                </select></td>
        </tr>
        <tr>
            <td>Leave Start Date <font color="red">*</font> </td>
            <td>
                <html:text property="startDate" styleId="joinofdate1"/> 
            </td>
        </tr>
        <tr>
              <td>Leave End Date <font color="red">*</font> </td>
            <td><html:text property="endDate" styleId="enddate"/> </td>
        </tr>
        <tr>
            <td>Duration <font color="red">*</font></td>
            <td><select name="leaveDuration">
                    <option value="Full Day">Full Day</option>
                    <option value="First Half">First half</option>
                     <option value="Second Half">Second Half</option>                   
                </select></td>
        </tr>
         <tr>
            <td>Number of days <font color="red">*</font> </td>
            <td><html:text property="daysNum"/> (e.g : for half day write 0.5 days)</td>
        </tr>
        <tr>
            <td>Detailed Reason of request <font color="red">*</font></td>
            <td><html:textarea property="reasonOfLeave" cols="30" rows="5"></html:textarea></td>
        </tr>
       
        
        <tr>
            <td></td>
            <td><input type="submit" value="submit"/></td>
        </tr>
    </tbody>
</table>
</html:form>