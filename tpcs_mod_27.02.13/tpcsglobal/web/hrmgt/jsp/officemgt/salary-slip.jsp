<%-- 
    Document   : salary-slip
    Created on : Dec 19, 2012, 11:30:21 AM
    Author     : TPCS
--%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


 <html:form action="salarySlip.do">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry Of Balance</title>
    </head>
    <body>
        <h1 align="center">Enter Salary Details</h1>
        
        
        <%
                if(null != request.getAttribute("storesalarysheet")){
                %>
    <center><font color="red"><%=request.getAttribute("storesalarysheet")%></font></center>
               
                    <%
                }
       %>
    </br>
        
            <table border="0" align="center">
                 <tr>
                    <td>
                        Associate Name:
                    </td>
                    <td>
                    <html:select property="employeeId">
                        <html:optionsCollection name="salaryTaskFormBean" property="listOfUserProfile" label="lebel" value="value"/>                   
                    </html:select>
                    </td>
                </tr>
                 
                <tr>
                    
                    <td>
                        Salary:
                    </td>
                    <td>
                        <html:text property="salary"/><br>
                        <font color="red"><html:errors property="salary"/></font>
                    </td>
                </tr>
                <tr>
                    
                    <td>
                       Salary Starting Date(dd/mm/yyyy)
                    </td>
                    <td>
                        <html:text property="startingdate"/><br>
                         <font color="red"><html:errors property="startingdate"/></font>
                    </td>
                </tr>
                
                <tr>
                   
                    <td>
                        Salary Ending Date(dd/mm/yyyy)
                    </td>
                    <td>
                        <html:text property="endingdate"/><br>
                        <font color="red"><html:errors property="endingdate"/></font>
                    </td>
                </tr>
                <tr>
                   
                    <td>
                        Salary Payment Date(dd/mm/yyyy)
                    </td>
                    <td>
                        <html:text property="paymentdate"/><br>
                        <font color="red"><html:errors property="paymentdate"/></font>
                    </td>
                </tr>
               
                 <tr>
                    
                    <td>
                       Payment Account No(with Bank Name):
                    </td>
                    <td>
                        <html:text property="paymenttype"/><br>
                         <font color="red"><html:errors property="paymenttype"/></font>
                    </td>
                </tr>
                
            
                <tr>
                    <td></td>
                    
                    <td>
                        <html:submit value="submit"/>
                    </td>
                    
                </tr>
            </table>
         </html:form>
