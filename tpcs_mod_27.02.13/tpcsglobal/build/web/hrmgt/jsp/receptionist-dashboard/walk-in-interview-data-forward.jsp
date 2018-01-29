
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:form action="schedule-interview">
<table>
    <tr>
        <td colspan="2">
            <bean:write name="scheduleInterviewForm" property="message"/>
        </td>        
              
    </tr>
    <tr>
        <td>Day</td>        
        <td><select name="day">
                <%for (int i = 1; i <= 31; i++) {%>
                 <option value='<%=i%>' ><%=i%></option>
                <%}%>
            </select>
        </td>        
    </tr>
    <tr>
        <td>Month</td>        
        <td><html:select property="month">

                <html:option value="Jan" >January</html:option>
                <html:option value="Feb" >February</html:option>
                <html:option value="Mar" >March</html:option>
                <html:option value="Apr" >April</html:option>
                <html:option value="May" >May</html:option>
                <html:option value="June" >June</html:option>
                <html:option value="July" >July</html:option>
                <html:option value="Aug" >August</html:option>
                <html:option value="Sept" >September</html:option>
                <html:option value="Oct" >October</html:option>
                <html:option value="Nov" >November</html:option>
                <html:option value="Dec" >December</html:option>
            </html:select></td>  
    </tr> <tr>
        <td>Year</td>        
        <td>
          
            <select name="year">
                <%for(int i = 2013; i <= 2015; i++) {%>
                 <option value='<%=i%>' ><%=i%></option>
                <%}%>
            </select>
         </td>         
    </tr>
    <tr>
        <td><html:submit value="Submit"/></td>     
        <td><html:reset value="Reset"/></td>     
    </tr>


</table>
</html:form>
