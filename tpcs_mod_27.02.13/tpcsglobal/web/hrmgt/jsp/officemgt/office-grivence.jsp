<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
 <html:form action="storegrievance.do">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry Of Grievance</title>
    </head>
    <body>
        <h1 align="center">Entry Of Grievance</h1>
        
        
        <%
                if(null != request.getAttribute("storegrievance")){
                %>
    <center><font color="red"><%=request.getAttribute("storegrievance")%></font></center>
               
                    <%
                }
       %>
    </br>
        
            <table border="0" align="center">
                <tr>
                    
                    <td>
                        My Grievance
                    </td>
                    <td>
                        <html:textarea rows="10" cols="20" property="grievance"/><br>
                        <font color="red"><html:errors property="grievance"/></font>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <html:submit value="Submit"/>
                    </td>
                </tr>
            </table>
 </html:form>