<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<table width="100%" border="0" bgcolor="lightgrey" cellspacing="0">
   <tr>
        <td colspan="2" style="text-align: right">
            <a href="#" style="text-decoration: none">Password Management</a> | <a href="logout.do" style="text-decoration: none"> Logout </a>
        </td>
    </tr>
    <tr>
        <td>     
            <table border="0" width="100%">
                <tr>
                    <td><font style="color:#800000;font-weight: bold"> <h1><a href="postlogin.do" style="text-decoration: none"> Receptionist & Telecaller Dashboard</h1></a></font></td>
                    <td style="float:right">
                          <html:form action="searchEmpRecord"> 
            <table align="right" border="0" >
                <tr>
                    <td>Search :</td>
                    <td><select>
                            <option>People</option>
                            <option>Application</option>
                            <option>Content</option>
                        </select>
                    </td>
                    <td valign="bottom">
                                 
                            <input type="text" name="employeeId"></input>   
                  
                    </td>
                    <td><html:submit value="Go"></html:submit> </td>
                </tr>
            </table>
                  </html:form>
                    </td>     
                </tr>
            </table>    
        </td>       
    </tr>
    
    <tr>
        <td align="center" colspan="2">
            <table width="100%" border="0" cellspacing="0" cellpadding="1" bgcolor="#8adoff" height="30px">
                <tr>
                    <td><a href="postlogin.do" style="text-decoration: none"><b>Check List</b></a></td>
                    <td>&nbsp;</td>
                    <td> <a href="office-regular-task.do" style="text-decoration: none"><b>Mandatory Task</b></a></td>
                    <td><a href="ilps.do" style="text-decoration: none"><b>Leave Management</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="reception-goal-sheet.do" style="text-decoration: none"><b>Goal Sheet</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="employee_management.do" style="text-decoration: none"><b>Manage Employee</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="corporate-policy.do" style="text-decoration: none"><b>Request</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="corporate-policy.do" style="text-decoration: none"><b>Mails</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="corporate-policy.do" style="text-decoration: none"><b>Activity</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="quick-links.do" style="text-decoration: none"><b>Quick Links</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="control-panel.do" style="text-decoration: none"><b>Control Panel</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="corporate-policy.do" style="text-decoration: none"><b>TPCS Websites</b></a></td>
                    <td>&nbsp;</td>
                    <td><a href="global-hr.do" style="text-decoration: none"><b>Knowledge Base</b></a></td>

                </tr>
            </table>

        </td>
    </tr>
</table>




