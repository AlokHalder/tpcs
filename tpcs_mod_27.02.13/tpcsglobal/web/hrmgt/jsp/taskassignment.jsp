<%@taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>

<link rel="stylesheet" href="ui.datepicker.css"/>


<script type="text/javascript" src="jq.js"></script>
<script type="text/javascript" src="jq.date.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#trip input#targetdate').datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: 'calendar.gif', buttonImageOnly: true }); // format: Thurs, Jan 31, 2008, only show when the user clicks the calendar

});

</script>
<html:form action="taskAssignment">
<table border="1" width="100%">
    <thead>
        <tr>
            <th colspan="2">Task Assignment</th>
         
        </tr>
    </thead>
    <tbody>
        <tr>
            <td colspan="2" >
                <%
                 String message = (String)request.getAttribute("message");
                 if(null != message){
                %>
                <font color="green" style="font-weight: bold"> <%=message%> </font>
                <%
                 }else{                        
               %>
                <font color="red" style="font-weight: bold"> <%=message%> </font>
                <%}%>
            </td>
        </tr>
        <tr>
            <td>Resource Name : </td>
            <td><select name="resourcename">
                    <option value="107">Masud Ahmed Khan </option>
                    <option value="103">Rajarsree Chakraborty</option>
                </select></td>
        </tr>
        <tr>
            <td>Task Category : </td>
            <td><select name="taskcategory">
                    <option value="1">Web Development</option>
                    <option value="2">Institute Tracking</option>
                </select></td>
        </tr>
        <tr>
            <td>Task Description :</td>
            <td><textarea name="taskdescription" rows="4" cols="20">
                </textarea></td>
        </tr>
        <tr>
            <td>Project :</td>
            <td><select name="projectname">
                    <option value="107">Office Management </option>
                    <option value="103">www.ptutors.org</option>
                </select></td>
        </tr>
        <tr>
            <td>Target To Complete </td>
            <td>
                <input type="text" name="targetdate" styleId="targetdate"/>
            </td>
        </tr>
        <tr>
            <td>Status :</td>
            <td><select name="statusname">
                    <option value="1">Assigned</option>
                    <option value="2">In Progress</option>
                </select></td>
        </tr>
        <tr>
            <td colspan="2">                
                <input type="submit" value="submit" />
            </td>
            
        </tr>
    </tbody>
</table>
</html:form>
