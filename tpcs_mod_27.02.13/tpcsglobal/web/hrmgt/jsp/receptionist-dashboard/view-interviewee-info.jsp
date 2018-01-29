<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>

<table  cellspacing="2px" border="0" cellpadding="5px">
    <thead>
        <tr>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Sl.&nbsp;No</font></th>    
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Interviewee&nbsp;Name</font></th>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Contact&nbsp;No.</font></th>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Applied&nbsp;For</font></th>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Qualification</font></th>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">University</font></th>
            <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold" title="Date of Received CV">DRC</font></th>
        </tr>
    </thead>
    <logic:iterate name="viewInterviewCandidateFormBean" property="listOfInterViewee" id="listOfInterViewee">
        <tr bgcolor="#E2F4FF" valign="top" style="padding-top:5px">
            <td>
                <%-- where is I(Chandan 109)  --%>
                <html:link action="to-call-follow-up.do" paramId="intervieweeSlNo" paramName="listOfInterViewee" paramProperty="intervieweeSlNo">
                    <bean:write name="listOfInterViewee" property="intervieweeSlNo"/>
                </html:link>
            </td>
            <td style="padding:5px;" >
                <bean:write name="listOfInterViewee" property="name"/>
                <%-- <html:link action="to-update-interviewee.do" paramId="emailId" paramName="listOfInterViewee" paramProperty="emailId" style="text-decoration: none">
                </html:link> 
                --%>
            </td>
            <td>
                <bean:write name="listOfInterViewee" property="contactNo"/>
            </td>
            <td>
                <bean:write name="listOfInterViewee" property="profileAppliedFor"/>
            </td>                                           
            <td valign="middle">
                <bean:write name="listOfInterViewee" property="qualification"/>                                 
            </td>
            <td>
                <bean:write name="listOfInterViewee" property="interviewUniversity"/>                                 
            </td>

            <td valign="middle">
                <bean:write name="listOfInterViewee" property="receiveDate"/>                                 
            </td>
        </tr>

    </logic:iterate>

</table>
