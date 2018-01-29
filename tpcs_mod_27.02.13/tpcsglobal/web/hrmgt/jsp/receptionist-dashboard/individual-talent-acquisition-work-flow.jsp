<%-- 
    Document   : individual-talent-acquisition-work-flow
    Created on : May 30, 2013, 8:28:16 PM
    Author     : TPCS_PL Chandan 109
--%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<fieldset>
    <legend>Details of Interviewee </legend>
    <table align="center" cellspacing="2" cellpadding="2">
        <tr>
            <td>Ticket No</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="intervieweeSlNo"/></td>
        </tr>
        <tr>
            <td> Name :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="name"/></td>
        </tr>
        <tr>
            <td> Contact No :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="contactNo"/></td>
        </tr>
        <tr>
            <td> Email Id :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="emailId"/></td>
        </tr>   
        <tr>
            <td>Alternative Email Id :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="alternateEmailId"/></td>
        </tr>  
        <tr>
            <td> Profile Applied For:</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="profileAppliedFor"/></td>
        </tr> 
        <tr>
            <td> Academic Qualification :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="qualification"/></td>
        </tr>

        <tr>
            <td>University Name :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="instituteName"/>
            </td>
        </tr>
        <tr>
            <td> Year of Pass out :</td>
            <td> <bean:write name="storeInterviewCandidateFormBean" property="passoutyr"/>
            </td>
        </tr>
        <tr>
            <td>Key Skills :</td>
            <td>
                <bean:write name="storeInterviewCandidateFormBean" property="ohterKeySkills"/>
            </td>
        </tr>
        <tr>
            <td> Experience :</td>
            <td>
                <bean:write name="storeInterviewCandidateFormBean" property="intervieweeExperience"/>
            </td>
        </tr>
        <tr>
            <td> Interview Status:</td>
            <td>
                <bean:write name="storeInterviewCandidateFormBean" property="interviewStatus"/>
                (<bean:write name="storeInterviewCandidateFormBean" property="interviewStatusDate"/>)
            </td>
        </tr>
         <tr>
            <td>Receive and Save His or Her CV </td>
            <td>
                <bean:write name="storeInterviewCandidateFormBean" property="receivedate"/> /
                 <bean:write name="storeInterviewCandidateFormBean" property="intervieweeStoreDate"/>
            </td>
        </tr>
        <tr>
            <td>Remarks : </td>
            <td>
                <bean:write name="storeInterviewCandidateFormBean" property="remarks"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                <bean:write name="storeInterviewCandidateFormBean" property="msg"/>
            </td>
            <td align="right">
                <html:link action="to-add-work-flow.do" paramId="intervieweeSlNo" paramName="storeInterviewCandidateFormBean" paramProperty="intervieweeSlNo">Add Work Flow</html:link>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>Add Work Flow</legend>
    <html:form action="add-work-flow.do">
        <table align="center" cellspacing="5" cellpadding="5">
            <tr>
                <td> Call Followup Status :</td>
                <td>
                    <html:select property="callFollowUp">
                        <html:option value="Not Contacted">Not Contacted</html:option>
                        <html:option value="Profile Rejected">Profile Rejected</html:option>
                        <html:option value="Interview Scheduled">Interview Scheduled</html:option>
                        <html:option value="Aptitude Round Taken">Aptitude Round Taken</html:option>
                        <html:option value="Aptitude and Technical Round Taken">Aptitude and Technical Round Taken</html:option>
                        <html:option value="Interview Completed">Interview Completed</html:option>
                        <html:option value="Pending for Final Dicusstion">Pending for Final Discussion</html:option>
                        <html:option value="Interview Completed">Interview Completed</html:option>
                        <html:option value="First Follow Up">First Follow Up</html:option>              
                        <html:option value="Second Follow Up">Second Follow Up</html:option> 
                        <html:option value="Third Follow Up">Third Follow Up</html:option>
                        <html:option value="Fourth Follow Up">Fourth Follow Up</html:option> 
                        <html:option value="Process Closed">Process Closed</html:option>  
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
                <td> Status:</td>
                <td> 
                    <html:select property="status">
                        <html:option value="Active">Active</html:option>
                        <html:option value="Close">Close</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>

                <td colspan="2" align="right"><input type="submit" value="submit"/></td>
            </tr>
        </table>
    </html:form>    
</fieldset>