<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:form action="enquiry-form.do">
<table align="center" cellspacing="5" cellpadding="5">
    <tr>
        <td colspan="2">
            <h1> Enquiry Details </h1>
             <br/>
     <%
                if(null != request.getAttribute("message")){
                %>
                <%=request.getAttribute("message")%></font>
               
                    <%
                }
       %>
    </br>
        </td>
    </tr>
    <tr>
        <td> Name :</td>
        <td> <html:text property="name"/></td>
    </tr>
    <tr>
        <td> Contact No :</td>
        <td> <html:text property="contactNo"/></td>
    </tr>
    <tr>
         <td> Alternative Contact NO:</td>
         <td><html:text property="altcontactNo"/></td>
    </tr>
    <tr>
         <td> Email Id :</td>
        <td> <html:text property="emailId"/></td>
    </tr>   
    
   
    <tr>
         <td> Academic Qualification :</td>
        <td> <html:text property="qualification"/></td>
    </tr>  
  
    
    
     <tr>
         <td> Remark :</td>
         <td> 
             <html:textarea  property="remarks" rows="5" cols="30"></html:textarea>
        </td>
    </tr>
     <tr>
         <td><input type="submit" value="submit"/></td>
         <td><html:reset value="Reset"/></td>
    </tr>
</table>
</html:form>    
