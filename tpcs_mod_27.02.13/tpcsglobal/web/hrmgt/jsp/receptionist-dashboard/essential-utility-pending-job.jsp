<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset>
    <legend>
        Total Pending Jobs
    </legend>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
    <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
    <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
    <table align="cernter" width="100%">
        <thead>
            <tr>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Job&nbsp;Id</font></th>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Job&nbsp;Description</font></th>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Employee&nbsp;Name(Id)</font></th>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold" title="P: Pending, A: Assigned" >Job&nbsp;Status</font></th>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold" title="L: Low, M: Medium, H: High">Job&nbsp;Urgency</font></th>
                <th height="15px;" bgcolor="orange"><font color="#800000" style="font-weight:bold">Job&nbsp;Creation&nbsp;Date</font></th>
            </tr>
        </thead>
        <tbody>
            <logic:iterate id="jobpools" name="essentialUtilityForm" property="listOfJobs">
                <tr>
                    <td>
                        <html:link action="to-assigned-job.do" paramId="jobId" paramName="jobpools" paramProperty="jobId">
                            <bean:write name="jobpools" property="jobId"/></html:link>
                        </td>
                        <td><bean:write name="jobpools" property="jobDescription"/></td>
                    <td><bean:write name="jobpools" property="empName"/>(<bean:write name="jobpools" property="empId"/>)</td>
                    <td align="center" title="P: Pending, A: Assigned"><html:link action="search-for-assigned-who.do" paramId="jobId" paramName="jobpools" paramProperty="jobId">
                            <logic:equal name="jobpools" property="jobStatus" value="A">
                                 Assigned
                            </logic:equal>
                        </html:link>
                        <logic:equal name="jobpools" property="jobStatus" value="P"> 
                               Pending
                        </logic:equal>
                    </td>
                    <td align="left" title="L: Low, M: Medium, H: High">
                         <logic:equal name="jobpools" property="jobUrgency" value="L"> 
                             Low
                        </logic:equal>
                         <logic:equal name="jobpools" property="jobUrgency" value="M"> 
                             Medium
                        </logic:equal>   
                         <logic:equal name="jobpools" property="jobUrgency" value="H"> 
                             High
                        </logic:equal>          
                       </td>
                    <td><bean:write name="jobpools" property="jobCreationDate"/></td>
                </tr>
            </logic:iterate>
        </tbody>
    </table>
</fieldset>
