<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form action="postlogin">
    
    
    <div style="padding-top:250px">
        <table align="center" bgcolor="#8ad0ff" width="30%" height="25%"  >
             <tr>
                <td></td>
                <td colspan="2">
                    <%
                     
                         String message = (String) request.getAttribute("loginmsg");
                         if (null != message) {
                     %>
                     <font color="red" style="font-weight: bold"> <%=message%> </font>
                     <%
                         }
                     %>
                    
                    
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <b><font color="white">The Professional Consultancy Services</font></b>
                </td>

            </tr>
            <tr>
                <td align="center" colspan="2"><b><font color="white">Welcome to Employee Zone</font></b></td>
           
                </tr>
                <tr>
                    <td><b><font color="white">User-id :</font></b></td>
                    <td><html:text property="username"></html:text></td>
                </tr>
                <tr>
                <td></td>
                <td colspan="2"><font color="red"><html:errors property="username"></html:errors></font></td>
            </tr>
            <tr>
                <td><b><font color="white">Password :</font></b></td>
                <td><html:password property="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2"><font color="red"><html:errors property="password"/></font></td>
            </tr>
           
            <tr>
                
                <td></td>
                <td><html:submit/></td>
            </tr>
        </table>
    </div>
</html:form>