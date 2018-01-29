
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:form action="submitNewsEvent.do" >
<table>
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
        <td><b>Title :</b></td>
        <td>
      <html:text property="title" ></html:text>
        </td>
    </tr>

      <tr>
        <td><b>Date :</b></td>
        <td>
        <html:text property="date" styleId="inputField" ></html:text>
        </td>
    </tr>
    <tr>
        <td>
            <b> News And Event Report: </b>
        </td>
         <td>
             <html:textarea rows="10" cols="50" property="newsdetails" ></html:textarea>
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
                
 

