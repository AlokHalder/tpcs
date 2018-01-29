<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:form action="submitPassManage.do">
<table>
             <tr>
                 <td colspan="2" >
                     <%
                         String message = (String) request.getAttribute("message_password");
                         if (null != message) {
                     %>
                     <font color="green" style="font-weight: bolder"> <%=message%> </font>
                     <%
                         }
                     %>

                 </td>
             </tr> 
             
             
   <tr>
        <td><b>Current Password</b><font color="red"> <bean:message key="key.mandatoryfield"/></font></td>
        <td>
            <html:password property="curpass"></html:password><br/>
            <font color="red"><html:errors property="curpass"/></font>
        </td>
    </tr>

      <tr>
        <td><b>New Password</b><font color="red"> <bean:message key="key.mandatoryfield"/></font></td>
        <td>
            <html:password property="newpass"></html:password><br/>
           <font color="red"><html:errors property="newpass"/></font>
        </td>
    </tr>
    <tr>
        <td>
            <b>Retype Password</b><font color="red"> <bean:message key="key.mandatoryfield"/></font>
        </td>
         <td>
             <html:password property="retypepass"></html:password><br/>
            <font color="red"><html:errors property="retypepass"/></font>
        </td>
    </tr>
    
       <tr>
                <td>&nbsp;</td>
                <td colspan="2">                
                    <input type="submit" value="submit" />
                </td>

            </tr>
</table>
</html:form>     
                
 

