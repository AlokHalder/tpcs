<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<fieldset>
    <legend>Job Details</legend>
    <table border="0" width="100%" cellspacing="0" cellpadding="0" align="center" >
        <tr><td><font style="font-weight: bold">Job Id</font></td><td><bean:write name="essentialUtilityForm" property="jobId"/></td></tr>
                <%-- <tr><td>Job Description</td><td><bean:write name="essentialUtilityForm" property="jobDescription"/></td></tr> 
                 <tr><td><font style="font-weight: bold">Employee Id</font></td><td><bean:write name="essentialUtilityForm" property="empId"/></td></tr>--%>
        <tr><td><font style="font-weight: bold">Job Status</font></td>
            <td>
                <logic:equal name="essentialUtilityForm" property="jobStatus" value="A">
                    Assigned
                </logic:equal>
                <logic:equal name="essentialUtilityForm" property="jobStatus" value="P">
                    Pending
                </logic:equal>
            </td>
        </tr>
        <tr><td><font style="font-weight: bold">Job Urgency</td>
            <td>
                <logic:equal name="essentialUtilityForm" property="jobUrgency" value="L">
                    Low
                </logic:equal>
                <logic:equal name="essentialUtilityForm" property="jobUrgency" value="M">
                    Medium
                </logic:equal>
                <logic:equal name="essentialUtilityForm" property="jobUrgency" value="H">
                    High
                </logic:equal>
            </td></tr>
        <tr><td><font style="font-weight: bold">Job Creation Date</font></td><td><bean:write name="essentialUtilityForm" property="jobCreationDate"/></td></tr> 
    </table>
</fieldset>
<fieldset>
    <legend>
        Assigned Job
    </legend>
    <html:form action="assign-to.do">
        <table border="0" width="100%" cellspacing="0" cellpadding="0" align="center" > 
            <tbody>
                <tr>
                    <td colspan="2" align="center">
                        <bean:write name="essentialUtilityForm" property="message"/> 
                    </td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold">Assign to: :</font> </td>
                    <td>
                        <html:hidden name="essentialUtilityForm" property="jobId"/>
                        <html:select name="essentialUtilityForm" property="empId">
                            <html:optionsCollection name="essentialUtilityForm" property="listOfUserProfile"  label="lebel" value="value" ></html:optionsCollection>
                        </html:select> 
                    </td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold">Task Category : </td>
                    <td>
                        <html:select property="taskCategoryId">
                            <html:optionsCollection name="essentialUtilityForm" property="listOfTaskCategory" label="lebel" value="value"/>                   
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold">Additional info:</font></td><td><html:textarea rows="10" cols="50" name="essentialUtilityForm" property="jobDescription"></html:textarea></td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold"> Priority:</font></td>
                    <td>
                        <html:select property="jobUrgency" name="essentialUtilityForm">
                            <html:option value="L">LOW</html:option>
                            <html:option value="M">MEDIUM</html:option>
                            <html:option value="H">HIGH</html:option>
                        </html:select>
                    </td>
                </tr>           
                <tr>
                    <td align="right"><font style="font-weight: bold">Project :</font></td>
                    <td>
                        <html:select property="projectId">
                            <html:optionsCollection name="essentialUtilityForm" property="listOfTask" label="lebel" value="value"/>                   
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold">Target To Complete : </font></td>
                    <td>

                        <html:text property="targetDate" styleId="inputField"/>
                    </td>
                </tr>
                <tr>
                    <td align="right"><font style="font-weight: bold">Status :</font></td>
                    <td><select name="statusId">
                            <option value="1">Assigned</option>
                            <option value="2">In Progress</option>
                            <option value="3">Assigned</option>
                            <option value="4">Facing Issues</option>
                        </select></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">                
                        <input type="submit" value="submit" />
                    </td>
                </tr>
            </tbody>
        </table>
    </html:form>
</fieldset>
