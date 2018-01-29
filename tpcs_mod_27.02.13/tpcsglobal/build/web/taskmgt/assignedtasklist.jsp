
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"%>

        <table border="0" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
                    <th>Task Id</th>                  
                  <%--  <th>Assigned By</th> --%>
                    <th>Project Name</th>
                    <th>Category Name</th>
                    <th>Task Description</th>
                    <th>Target Date</th>
                    <th>Status Id</th>                    
                    <th>Closing Date</th>
                    <th>Change</th>
                </tr>
            </thead>
            <tbody>
    <logic:iterate id="taskAssignment" name="taskAssignmentListForm" property="taskAssignmentList">

                <tr>
                    <td><a href="#"><bean:write name="taskAssignment" property="taskId"/></a></td>
                  <%--  <td><bean:write name="taskAssignment" property="assignedByResourceName"/></td> --%>
                    <td><bean:write name="taskAssignment" property="projectName"/></td>
                    <td><bean:write name="taskAssignment" property="taskCategoryName"/></td>
                    <td width ="200px"><bean:write name="taskAssignment" property="taskDescription"/></td>
                    <td><bean:write name="taskAssignment" property="taskTargetDate"/></td>
                    <td><bean:write name="taskAssignment" property="statusName"/></td>                    
                    <td><bean:write name="taskAssignment" property="closingDate"/></td>  
                    <td><a href="edittask.do?taskId=<bean:write name="taskAssignment" property="taskId"/>">Edit</a></td> 
                    <%-- <td><a href="delete.do?taskId=<bean:write name="taskAssignment" property="taskId"/>">Delete</a></td> ---%>
                </tr>     
        
    </logic:iterate>
            </tbody>
</table>
