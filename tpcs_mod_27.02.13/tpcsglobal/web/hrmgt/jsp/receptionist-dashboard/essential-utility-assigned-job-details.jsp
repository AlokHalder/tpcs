<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<fieldset>
    <legend>Assigned Details</legend>
    <table align="center">
        <tr><td>Job Id :</td><td><bean:write name="essentialUtilityForm" property="jobId"/></td></tr>
        <tr><td>Employee Name :</td><td><bean:write name="essentialUtilityForm" property="empName"/></td></tr>
        <tr>
            <td>Job Urgency :</td>
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
            </td>
        </tr>
        <tr><td>Assign Date :</td><td><bean:write name="essentialUtilityForm" property="jobCreationDate"/></td></tr>
    </table>
</fieldset>

