<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<head>
<title>JQuery Datepicker</title>

<link rel="stylesheet" href="../css/ui.datepicker.css"/>


<script type="text/javascript" src="../js/jq.js"></script>
<script type="text/javascript" src="../js/jq.date.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#trip input#joinofdate, #trip input#birthdate, #trip input#higherqualification').datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: '../images/calendar.gif', buttonImageOnly: true }); // format: Thurs, Jan 31, 2008, only show when the user clicks the calendar

});

</script>



<html:form action="postuserentry" styleId="trip">
    <table>
        <tr>
            <td>Enter Userid:</td>
            <td><html:text property="userid"/></td>
        </tr>
         <tr>
            <td>Enter Password:</td>
            <td><html:text property="password"/></td>
        </tr>
        <tr>
            <td>Enter Name:</td>
            <td><html:text property="name"/></td>
        </tr>
        <tr>
            <td>Enter Joining date:</td>
            <td><html:text property="joiningdate" styleId="joinofdate"/></td>
        </tr>
        <tr>
            <td>Enter Date of Birth:</td>
            <td><html:text property="dateofbirth" styleId="birthdate"/></td>
        </tr>
        <tr>
            <td>Enter Designation:</td>
            <td><html:text property="designation"/></td>
        </tr>
         <tr>
            <td>Enter Higher Qualification:</td>
            <td><html:text property="higherqualification" styleId="higherqualification"/></td>
        </tr>
        <%-- <tr>
            <td>Enter Year of Pass-out:</td>
            <td><html:text property="yearofpassout"/></td>
        </tr>--%>
        <tr>
            <td>Enter Specialization:</td>
            <td><html:text property="specilization"/></td>
        </tr>
        <tr>
            <td>Enter Address:</td>
            <td><html:text property="empaddress"/></td>
        </tr>
        <tr>
            <td>Enter Zip code:</td>
            <td><html:text property="empzipcode"/></td>
        </tr>
        <tr>
            <td>Enter Contact Number:</td>
            <td><html:text property="empcontactnumber"/></td>
        </tr>
        <tr>
            <td>Enter Email-id:</td>
            <td><html:text property="empemailid"/></td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/></td>
        </tr>
    </table>

</html:form>