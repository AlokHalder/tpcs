<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

    <html:form>
        
        <table border="0" align="center" bgcolor="#8ad0ff">
        <tr>
            <td>Task Id:</td>
            
            <td><input type="text" name="taskId"  readonly="true" value="<bean:write name='displayTaskAssignmentFormBean'property='taskId' />" />
            </td>
        </tr>
        <tr>
            <td>Assigned By:</td>
             <td><input type="text" name="resourceName" value="<bean:write name='displayTaskAssignmentFormBean'property='resourceId'/>"/></td>
                    </tr>
       <%-- <tr>
            <td>Task Category :</td>
            <td>
                
                <html:select property="categoryId" name="displayTaskAssignmentFormBean">
                    <html:optionsCollection name="displayTaskAssignmentFormBean" property="taskCategoryList" label="lebel" value="value"/>                   
                </html:select>
            </td>
        </tr>--%>
        <tr>
            <td>Task Description:</td>
            <td><textarea name="taskdescription" rows="4" cols="20" value="<bean:write name='displayTaskAssignmentFormBean'property='taskDescription'/>"></textarea></td>
                
  
        </tr>
        <tr>
            <td>Task Target Date:</td>
            <td><input type="text" name="taskTargetDate" value="<bean:write name='displayTaskAssignmentFormBean'property='taskDescription'/>"/></</td>
        </tr>
        <%--<tr>
            <td>Status:</td>
            <td><html:select property="statusId" name="displayTaskAssignmentFormBean">
                    <html:optionsCollection name="displayTaskAssignmentFormBean" property="taskStatusList" label="lebel" value="value"/>                   
                </html:select></td>
  
        </tr>--%>
        <tr>
            <td></td>
            <td><input type="submit" value="submit" align="center"/></td>
        </tr>
    </table>
    </html:form>