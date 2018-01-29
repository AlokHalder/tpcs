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
    <legend>Work Flow </legend>
    <table align="center" cellspacing="2" cellpadding="2">
        <thead>
            <tr>
                <th>Employee id</th>
                <th>Name</th>
                <th>Role</th>
                <th>Action performed</th>
                <th>Remark</th>
                <th>Status</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <logic:iterate id="workFlowOf" name="storeInterviewCandidateFormBean" property="listOfWorkFlow">
                <tr>
                    <td><bean:write name="workFlowOf" property="empId"/></td>
                    <td><bean:write name="workFlowOf" property="empName"/></td>
                    <td><bean:write name="workFlowOf" property="empRole"/></td>
                    <td><bean:write name="workFlowOf" property="empAction"/></td>
                    <td><bean:write name="workFlowOf" property="remarks"/></td>
                    <td><bean:write name="workFlowOf" property="status"/></td>
                    <td><bean:write name="workFlowOf" property="statusDate"/></td>
                </tr>
            </logic:iterate>
        </tbody>
    </table>
</fieldset>
