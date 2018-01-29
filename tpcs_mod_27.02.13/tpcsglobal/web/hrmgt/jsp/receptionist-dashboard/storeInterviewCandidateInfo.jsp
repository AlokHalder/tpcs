<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:form action="add-interviewee-info.do">
    <table align="center" cellspacing="5" cellpadding="5" width="100%">
        <tr>
            <td colspan="2">
                <h3> Interviewee Details </h3>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><bean:write name="storeInterviewCandidateFormBean" property="msg"/></td>
        </tr>
        <tr>
            <td> Name : <bean:message key="key.mandatoryfield"/> </td>
            <td><html:text property="name" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="name" /></font>
            </td>
        </tr>
        <tr>
            <td> Contact No :<bean:message key="key.mandatoryfield"/></td>
            <td><html:text property="contactNo" style="width:200px;" />
            <br/><font style="color: red"><html:errors property="contactNo" /></font>
            </td>
        </tr>
        <tr>
            <td> Email Id :<bean:message key="key.mandatoryfield"/></td>
            <td><html:text property="emailId" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="emailId" /></font>
            </td>
        </tr> 
        <tr>
            <td> Alternate Email Id :</td>
            <td>
                <html:text property="alternateEmailId" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="alternateEmailId" /></font>
            </td>
        </tr> 
        <tr>
            <td>Profile Applied For :<bean:message key="key.mandatoryfield"/></td>
            <td>
                <html:select property="profileAppliedFor" styleId="orProfile" onchange="otherprofilOr()" style="width:207px;">
                    <html:option value="">Select Profile Applied For</html:option>
                    <html:optionsCollection name="storeInterviewCandidateFormBean" property="listOfProfile" label="profileApplied" value="primaryId"/>
                    <html:option value="00">OTHERS</html:option>                 
                </html:select>
                <br/><font style="color: red"><html:errors property="profileAppliedFor" /></font>
            </td>
        </tr>
        <tr style="visibility: collapse" id="profilOr">
            <td>Other Profile Applied For :<font style="color: red">*</font></td>
            <td> 
                <html:text property="otherPofileAppliedFor" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>Academic Qualification :<bean:message key="key.mandatoryfield"/></td>
            <td>
                <html:select property="qualification" styleId="ortherAca" onchange="otherAcademi()" style="width:207px;">
                    <html:option value="">Select Qualification </html:option>
                    <html:optionsCollection name="storeInterviewCandidateFormBean" property="listOfAcademicQualification" label="academicQualification" value="primaryId"/>
                    <html:option value="00">Other</html:option>
                </html:select> 
                <br/><font style="color: red"><html:errors property="qualification" /></font>

            </td>
        </tr> 
        <tr style="visibility: collapse" id="insAca">
            <td>Other Academic Qualification :<font style="color: red">*</font></td>
            <td> 
                <html:text property="otherQualification" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>Institute Name :<bean:message key="key.mandatoryfield"/></td>
            <td> 
                <html:select property="instituteName" styleId="otherInstitution" onchange="otherIns()" style="width:207px;">
                    <html:option value="">Institute Name</html:option>
                    <html:optionsCollection name="storeInterviewCandidateFormBean" property="listOfInstitute" label="instituteName" value="primaryId"/>
                    <html:option value="00">Others</html:option>
                </html:select>
                <br/><font style="color: red"><html:errors property="instituteName" /></font>
            </td>
        </tr>
        <tr style="visibility: collapse" id="or">
            <td>Other Institute Name<font style="color: red">*</font></td>
            <td> 
                <html:text property="otherInstituteName" value="" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>Year Of Pass out :<bean:message key="key.mandatoryfield"/></td>
            <td> 
                <html:text property="passoutyr" styleId="inputField_1" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="passoutyr" /></font>
            </td>
        </tr>
        <tr>
            <td> Years Of Exp :<bean:message key="key.mandatoryfield"/></td>
            <td>
                <html:select property="intervieweeExperience" style="width:207px;">
                    <html:option value="Freshers">Freshers</html:option>
                    <html:option value="0-1">0-1</html:option>
                    <html:option value="1-2">1-2</html:option>
                    <html:option value="2-3">2-3</html:option>
                    <html:option value="3-4">3-4</html:option>
                </html:select>
            </td>
        </tr>
        <tr>
            <td>Key Skills :<bean:message key="key.mandatoryfield"/></td>
            <td valign="middle">
                <html:select property="keySkills" multiple="true" size="5" style="width:207px;" title="Press Ctrl to select multiple">
                    <html:option value="">Select Skills</html:option>
                    <html:optionsCollection name="storeInterviewCandidateFormBean" property="listOfKeySkils" label="keySkills" value="keySkills"/>
                </html:select>
               
            </td>
        </tr>
        <tr>
            <td>Other Key Skills :</td>
            <td>
                <html:text property="extraKeySkills" value="" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td> Interview Status :<bean:message key="key.mandatoryfield"/></td>
            <td>  <html:select property="interviewStatus" styleId="insStatus" onchange="otherInsSudule()" style="width:207px;">
                    <html:option value="Not Interviewed">Not Interviewed</html:option>
                    <html:option value="Interview Taken">Interview Taken</html:option>
                    <html:option value="Interview Scheduled">Interview Scheduled </html:option>
                    <html:option value="Interview Cancelled">Interview Canceled</html:option>
                    <html:option value="Profile Rejected">Profile Rejected</html:option>
                </html:select> 
            </td>
        </tr>
        <tr style="visibility: collapse;" id="insDate">
            <td>Interview Scheduled Date<bean:message key="key.mandatoryfield"/></td>
            <td> 
                <html:text property="interviewStatusDate" styleId="inputField" value="" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="interviewStatusDate" /></font>
            </td>
        </tr>
        <tr>
            <td>Receive CV To Us: <bean:message key="key.mandatoryfield"/></td>
            <td> 
                <html:text property="receiveCvDate" styleId="inputField_2" style="width:200px;"/>
                <br/><font style="color: red"><html:errors property="receiveCvDate" /></font>
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
            <td><html:submit value="Submit"/><html:reset value="Reset" style="margin-left:20px;"/></td>
        </tr>
    </table>
</html:form>    