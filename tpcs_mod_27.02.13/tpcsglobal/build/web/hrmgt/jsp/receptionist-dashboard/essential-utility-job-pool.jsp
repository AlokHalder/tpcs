<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="create-job.do">
    <fieldset>
        <legend>
            Add Job
        </legend>
        <table align="center" cellspacing="2" cellpadding="2" width="100%">
            <tr>
                <td colspan="2"><bean:write name="essentialUtilityForm" property="message"/>  
                </td>
            </tr>
            <tr>
                <td>Job Description:</td><td><html:textarea property="jobDescription" rows="10" cols="50"></html:textarea></td>
            <tr>
                <td> Priority:</td>
                <td><html:select property="jobUrgency" style="width:150px">
                        <html:option value="L">LOW</html:option>
                        <html:option value="M">MEDIUM</html:option>
                        <html:option value="H">HIGH</html:option>
                    </html:select></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <html:submit value="Add job"/>
                </td>
            </tr>
        </table>
        <center>

        </html:form>
</fieldset>
