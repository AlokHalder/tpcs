<%@taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<html:form action="store-future-task.do">
 <table border="0" width="100%" cellspacing="0" cellpadding="0" align="center" >        
     
   
        <tbody>
            <tr>
                <td colspan="2"><h3>Future Task Assignment</h3></td>
            </tr>
            <tr>
                <td colspan="2" >
                    <%
                        String message = (String) request.getAttribute("message");
                        if (null != message) {
                    %>
                    <font color="green" style="font-weight: bold"> <%=message%> </font>
                    <%
                    } 
                    %>
                    
                </td>
            </tr>
             <tr>
                <td align="right"><font style="font-weight: bold">Task Title : </font><font color="red">*</font></td>
                <td>

                    <html:text property="tasktitle"/><br/>
                    <font color="red"><html:errors property="tasktitle"/></font>
                </td>
            </tr>
             <tr>
                <td align="right"><font style="font-weight: bold">Task Description : </font><font color="red">*</font></td>
                <td>

                    <html:textarea property="taskdes"/><br/>
                    <font color="red"><html:errors property="taskdes"/></font>
                </td>
            </tr>
             <tr>
                <td align="right"><font style="font-weight: bold">Task Starting Date: </font><font color="red">*</font></td>
                <td>
                    <html:text property="taskstartdate" styleId="inputField"/><br/>
                    <font color="red"><html:errors property="taskstartdate"/></font>
                </td>
            </tr>
             <tr>
                <td align="right"><font style="font-weight: bold">Task Complete Date : </font><font color="red">*</font></td>
                <td>
                    <html:text property="taskcompdate" styleId="inputField_1"/><br/>
                    <font color="red"><html:errors property="taskcompdate"/></font>
                </td>
            </tr>
            <tr>
                <td align="right"><font style="font-weight: bold">Task Priority</font><font color="red">*</font></td>
                <td>
                    
                    <html:select property="taskpriority">
                        <html:option value="">Select The Priority</html:option>
                        <html:option value="Urgent">Urgent</html:option>
                        <html:option value="Medium">Medium</html:option>
                        <html:option value="Low">Low</html:option>
                    </html:select><br/>
                    <font color="red"><html:errors property="taskpriority"/></font>
                    
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2">                
                    <input type="submit" value="Submit" />
                </td>

            </tr>
            
        </tbody>
           </table>
</html:form>