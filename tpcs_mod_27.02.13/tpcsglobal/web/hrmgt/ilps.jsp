<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<link rel="stylesheet" href="../css/ui.datepicker.css"/>


<script type="text/javascript" src="../js/jq.js"></script>
<script type="text/javascript" src="../js/jq.date.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#trip input#joinofdate1').datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: '../images/calendar.gif', buttonImageOnly: true }); // format: Thurs, Jan 31, 2008, only show when the user clicks the calendar

});

</script>

<h1> Leave - Apply Leave</h1> 
<p><font color="red">If an associate do not apply leave within same month,that date will be converted into Loss Of Salary Pay </font></p>
<html:form action="apply-leave">
<table border="0" align="center" cellspacing="5" cellpadding="5">
    <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Leave Type <font color="red">*</font></td>
            <td><select name="leaveType">
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
            <td><html:text property="endDate"/> </td>
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
            <td><html:text property="daysNum"/> </td>
        </tr>
        <tr>
            <td>Detailed Reason of request <font color="red">*</font></td>
            <td><html:textarea property="reasonOfLeave" cols="30" rows="5"></html:textarea></td>
        </tr>
        <tr>
            <td>Upload Documents</td>
            <td><input type="file"/></td>
        </tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="submit"/></td>
        </tr>
    </tbody>
</table>
</html:form>