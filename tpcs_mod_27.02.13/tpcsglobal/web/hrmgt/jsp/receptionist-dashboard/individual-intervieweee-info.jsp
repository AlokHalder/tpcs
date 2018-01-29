<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form action="update-interviewee-info">
    <table align="center" cellspacing="5" cellpadding="5">
        <tr>
            <td colspan="2">
                <h1> Interviewee Details </h1>
                <br/>
                <%
                    if (null != request.getAttribute("message")) {
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
            <td> <input type="text" name="name" value ="<bean:write name='storeInterviewCandidateFormBean' property='name'/>"</td>
        </tr>
        <tr>
            <td> Contact No :</td>
            <td> <input type="text" name="contactNo" value ="<bean:write name='storeInterviewCandidateFormBean' property='contactNo'/>"</td>
        </tr>
        <tr>
            <td> Email Id :</td>
            <td> <html:text property="emailId"/></td>
        </tr>   

        <tr>
            <td> Profile Applied For:</td>
            <td> 
                <html:select property="profileAppliedFor">
                    <html:option value="JAVA/J2EE">JAVA/J2EE</html:option>
                    <html:option value="ASP.NET">ASP.NET</html:option>
                    <html:option value="DBA">DBA</html:option>
                    <html:option value="PHP">PHP</html:option>
                    <html:option value="TESTING">TESTING</html:option> 
                    <html:option value="INFRASRUCTURE">INFRASRUCTURE</html:option> 
                    <html:option value="OTHERS">OTHERS</html:option>                 
                </html:select>
            </td>
        </tr> 
        <tr>
            <td> Highest Qualification :</td>
            <td> 

                <html:select property="qualification">
                    <html:option value="B.TECH">B.TECH</html:option>
                    <html:option value="MCA">MCA</html:option>
                </html:select>
            </td>
        </tr>
        <tr>
            <td>Institute Name</td>
            <td> 
                <html:text property="institutename"/>
            </td>
        </tr>
        <tr>
            <td>Year Of Passout</td>
            <td> 
                <html:text property="passoutyr"/>
            </td>
        </tr>
        <tr>
            <td> Years Of Exp:</td>
            <td>
                <html:select property="interviewexperience">
                    <html:option value="Freshers">Freshers</html:option>
                    <html:option value="0-1">0-1</html:option>
                    <html:option value="1-2">1-2</html:option>
                    <html:option value="2-3">2-3</html:option>
                    <html:option value="3-4">3-4</html:option>
                </html:select>
            </td>
        </tr>
        <tr>
            <td> Key Skills :</td>
            <td> <html:text property="keySkills"/></td>
        </tr>
        <tr>
            <td> Interview Status :</td>
            <td> <html:select property="interviewStatus">
                    <html:option value="Not Interviewed">Not Interviewed</html:option>
                    <html:option value="Interview Taken">Interview Taken</html:option>
                    <html:option value="Interview Scheduled">Interview Scheduled </html:option>
                    <html:option value="Interview Cancelled">Interview Cancelled</html:option>
                    <html:option value="Profile Rejected">Profile Rejected</html:option>                 
                </html:select>    
            </td>
        </tr>
        <tr>
            <td> Call Followup Status :</td>
            <td>
                <html:select property="callFollowUp">
                    <html:option value="Not Interviewed">Not Contacted</html:option>
                    <html:option value="Contacted First Time">Contacted First Time</html:option>
                    <html:option value="Contacted Second Time">Contacted Second Time</html:option>              
                </html:select>   
            </td>
        </tr>
        <tr>
            <td> Remark :</td>
            <td> 
                <html:textarea  property="remarks" rows="5" cols="30"></html:textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="submit"/></td>
            </tr>
        </table>
</html:form>    