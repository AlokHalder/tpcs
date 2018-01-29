<%-- 
    Document   : salary-slip
    Created on : Dec 19, 2012, 11:30:21 AM
    Author     : TPCS
--%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


 <html:form action="search-salary.do">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Of Salary Details</title>
    </head>
    <body>
        <h1 align="center">Search Of Salary Details</h1>
        
        
        
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
                       Month:
                    </td>
                    <td>
                        <html:select property="month">
                            <html:option value="01">January</html:option>
                            <html:option value="02">February</html:option>
                            <html:option value="03">March</html:option>
                            <html:option value="04">April</html:option>
                            <html:option value="05">May</html:option>
                            <html:option value="06">June</html:option>
                            <html:option value="07">July</html:option>
                            <html:option value="08">August</html:option>
                            <html:option value="09">September</html:option>
                            <html:option value="10">October</html:option>
                            <html:option value="11">November</html:option>
                            <html:option value="12">December</html:option>
                        </html:select>
                    </td>
                </tr>
                 <tr>
                    <td></td>
                     <td>
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
