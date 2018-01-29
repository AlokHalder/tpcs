<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:form action="store-contact-no">
<table border="0" align="center" cellspacing="5" cell-padding="5">
    <thead>
        <tr>
            <th colspan="2"><h3> Store Contact Number </h3>
    <br/>
     <%
                if(null != request.getAttribute("message")){
                %>
                <%=request.getAttribute("message")%></font>
               
                    <%
                }
                
                  
                 %>
    </br>
        </th>
            
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Name :</td>
            <td><html:text property="name" /> </td>
        </tr>
        <tr>
            <td>Nick Name :</td>
            <td><html:text property="nickName" /> </td>
        </tr>
        <tr>
            <td>Concerned With :</td>
            <td><html:text property="category"/></td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td><html:text property="contactNumber"/></td>
        </tr>
        <tr>
            <td>Alternate Number :</td>
            <td><html:text property="alternateNumber"/></td>
        </tr>
        <tr>
            <td> Email Id:</td>
            <td><html:text property="emailId"/></td>
        </tr>
         <tr>
            <td> Alternate Email Id:</td>
            <td><html:text property="alternateEmailId"/></td>
        </tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/> &nbsp; &nbsp;<input type="reset" value="Reset"/></td>
        </tr>
    </tbody>
</table>
</html:form>