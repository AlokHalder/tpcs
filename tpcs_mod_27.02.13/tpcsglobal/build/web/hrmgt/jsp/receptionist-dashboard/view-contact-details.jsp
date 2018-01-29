<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table style="width:100%" cellspacing="2px" border="0" cellpadding="5px">
   
<thead >
<th height="25px;" bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Sr. No</font>
</th>    
<th height="25px;" bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Name</font>
</th>

<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Associate For</font>
</th>
<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Contact&nbsp;No.</font>
</th>

<th bgcolor="orange">
    <font color="#800000" style="font-weight:bold">Email Id</font>
</th>


</thead>
<% int i = 0;%>
<logic:iterate name="viewContactDetailsFormBean" property="listOfContactDetails" id="listOfContactDetails">
    <% i++;
        if (i % 2 == 0) {
    %>
    <tr bgcolor="#E2F4FF" valign="top" style="padding-top:5px">
        <%                                                                    } else {%>
    <tr valign="top" bgcolor="lightgrey">
        <%}%>
        <td style="padding:5px;" >
          <%=i%>
        </td>
        <td style="padding:5px;" >

            <bean:write name="listOfContactDetails" property="name"/>
            <br/>(<bean:write name="listOfContactDetails" property="nickName"/>)
        </td>
        <td>
            <bean:write name="listOfContactDetails" property="category"/>
        </td>

       
        <td>
            <bean:write name="listOfContactDetails" property="contactNumber"/><br/>
            <bean:write name="listOfContactDetails" property="alternateNumber"/>
        </td>   
         
     
        <td valign="middle">
            <bean:write name="listOfContactDetails" property="emailId"/>
        </td>
      
      
    </tr>

</logic:iterate>

</table>
