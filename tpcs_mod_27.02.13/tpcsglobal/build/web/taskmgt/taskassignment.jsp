<%@taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>

<html:form action="taskAssignment" styleId="trip">
    
    <table border="0" width="100%" cellspacing="0" cellpadding="0" align="center" >        
        <tbody>
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
                <td colspan="2"><h3>Task Assignment</h3></td>
            </tr>
            <tr>
                <td align="right"><font style="font-weight: bold">Resource Name :</font> </td>
                <td>
                    <html:select property="resourceId">
                        <html:optionsCollection name="assignTaskFormBean" property="listOfUserProfile" label="lebel" value="value"/>                   
                    </html:select>
                </td>
            </tr>
            <tr> 
                <td colspan="2">
                    &nbsp;
                </td>
            </tr>
            
            <tr>
                <td align="right"><font style="font-weight: bold">Task Category : </td>
                <td>
                    <html:select property="taskCategoryId">
                        <html:optionsCollection name="assignTaskFormBean" property="listOfTaskCategory" label="lebel" value="value"/>                   
                    </html:select>
                </td>
            </tr>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            
            <tr>
                <td align="right"><font style="font-weight: bold">Task Description :</font></td>
                <td><textarea name="taskDescription" rows="10" cols="50" >
                    </textarea></td>
            </tr>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            <%--
            <tr>
                <td align="right"><font style="font-weight: bold">Task Description :</font></td>
                <td><html:file property="taskAttachment"/></td>
           </tr>--%>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            
            <tr>
                <td align="right"><font style="font-weight: bold">Project :</font></td>
                <td>
                    <html:select property="projectId">
                        <html:optionsCollection name="assignTaskFormBean" property="listOfTask" label="lebel" value="value"/>                   
                    </html:select>
                </td>
            </tr>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            
            <tr>
                <td align="right"><font style="font-weight: bold">Target To Complete : </font></td>
                <td>

                    <html:text property="targetDate" styleId="inputField"/>(dd/mm/yyyy)
                </td>
            </tr>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            
            <tr>
                <td align="right"><font style="font-weight: bold">Status :</font></td>
                <td><select name="statusId">
                        <option value="1">Assigned</option>
                        <option value="2">In Progress</option>
                        <option value="3">Assigned</option>
                        <option value="4">Facing Issues</option>
                    </select></td>
            </tr>
            <tr> 
                <td colspan="2">
                     &nbsp;
                </td>
            </tr>
            
            <tr>
                <td>&nbsp;</td>
                <td colspan="2">                
                    <input type="submit" value="submit" />
                </td>

            </tr>
        </tbody>
    </table>
</html:form>         
