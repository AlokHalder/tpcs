
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:errors/>


 <div id="body-bottom-mid">
                    <div id="body-bottom-mid-container">
						<div class="body-bottom-mid-contain">
			<div class="body-bottom-header">Registration Form</div>

            <html:form action="employeeregister" onsubmit="return validateEmployeeActionForm(this);">
                    <div class="job-search-contain">
               		  <div class="form-name"</div>
                    	<div class="job-search-location-inner"></div>
                   	  <div class="clear"></div>
                      <div class="form-name">User Name :</div>
                      <div class="job-search-location-inner"><html:text property="loginName" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Password :</div>
                      <div class="job-search-location-inner"><html:password property="password" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                      <div class="form-name">Secret Question :</div>
                       <div class="job-category-field-inner">
                                       <html:select property="secretQuestion" styleClass="job-category-field-in-inner">
                                            <html:option value="">Select</html:option>
                                            <html:option value="1">What is your nick name?</html:option>
                                            <html:option value="2">What is your mother maiden name?</html:option>
                                            <html:option value="3">What is your favourite hero?</html:option>
                                            <html:option value="4">What is your first school name ?</html:option>
                                            <html:option value="5">What is your idol name ?</html:option>

                                        </html:select>

                        </div>
                       <div class="clear"></div>
                       <div class="form-name">Secret Answer :</div>
                      <div class="job-search-location-inner"><html:text property="secretAnswer" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Employer Name :</div>
                      <div class="job-search-location-inner"><html:text property="name" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Company Name :</div>
                      <div class="job-search-location-inner"><html:text property="companyName" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Company Type Code :</div>
                      <div class="job-search-location-inner"><html:text property="companyTypeCode" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Industry Type Id :</div>
                      <div class="job-search-location-inner"><html:text property="industryTypeId" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                       <div class="form-name">Country :</div>
                       <div class="job-category-field-inner">
                                                 <html:select property="countryCode" styleClass="job-category-field-in-inner">
                                                             <html:option value="">Select</html:option>
                                                             <html:optionsCollection property="countryList" label="countryName" value="countryCode"/>
                                                        </html:select>

                        </div>
                       <div class="clear"></div>
                       <div class="form-name">Location :</div>
                       <div class="job-category-field-inner">
                                       <html:select property="locationId" styleClass="job-category-field-in-inner">
                                                            <html:option value="">Select</html:option>
                                                            <html:optionsCollection property="locationList" label="cityName" value="cityCode"/>
                                                      </html:select>

                        </div>
                       <div class="clear"></div>

                      <div class="form-name">State :</div>
                      <div class="job-search-location-inner"><html:text property="stateProvince" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                      <div class="form-name">Address :</div>
                    	<div class="job-search-location-inner-large">
                            <html:textarea rows="5" cols="10" property="address" styleClass="location-text-area"/>
                        </div>
                   	  <div class="clear"></div>
                       <div class="form-name">Postal Code :</div>
                    	<div class="job-search-location-inner">
                            <html:text property="postalCode" styleClass="location-field"/>
                        </div>
                   	  <div class="clear"></div>
                       <div class="form-name">Contact Person :</div>
                    	<div class="job-search-location-inner">
                            <html:text property="contactPerson" styleClass="location-field"/>
                        </div>
                   	  <div class="clear"></div>
                      
                       <div class="form-name">Email Address :</div>
                       <div class="job-search-location-inner"><html:text property="emailAddress" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                        <div class="form-name">Contact Number :</div>
                      <div class="job-search-location-inner"><html:text property="contactNumber" styleClass="location-field"/></div>
                   	  <div class="clear"></div>
                          <div class="edit-container">
                              <html:submit value="Submit"/>
                          </div>
                          </div>
                  </html:form>
                  <html:javascript formName="employeeActionForm"/>
                        </div>
                     </div>
                </div>


    <TABLE border=0 cellSpacing=0 cellPadding=0 width="530px">
    <TBODY>
        <TR>
            <TD vAlign=top style="padding-left: 10px"><STRONG><font color="#0000CC">REGISTRATION FORM. SUBMIT FOR BRIDE  &amp;
                </font></STRONG><BR>

                <TABLE border=0 cellSpacing=1 cellPadding=4 width=530
                       align=center>
                    <TBODY>
                        <TR>
                            <TD vAlign=top width=424>
                                <DIV align=center>
                                    <html:form action="employeeregister">
                                        <TABLE class=text border=0 cellSpacing=0 cellPadding=2
                                               width="100%">
                                            <TBODY>
                                                <TR>
                                                    <TD height=16 colSpan=2> </TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">User Name</TD>
                                                    <TD height=2 width="61%"><html:text property="loginName"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Password</TD>
                                                    <TD height=2 width="61%"><html:text property="password"/></TD></TR>
                                                 <TR>
                                                    <TD height=3>Secret Question *</TD>
                                                    <TD height=2><html:select property="secretQuestion">
                                                            <html:option value="1">What is your name</html:option>
                                                         </html:select></TD></TR>
                                                <TR>

                                                <TR>
                                                    <TD height=2 width="39%">Secret Answer</TD>
                                                    <TD height=2 width="61%"><html:text property="secretAnswer"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Employer Name</TD>
                                                    <TD height=2 width="61%"><html:text property="name"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Company Name</TD>
                                                    <TD height=2 width="61%"><html:text property="companyName"/></TD></TR>
                                               <TR>
                                                    <TD height=2 width="39%">Company Type Code</TD>
                                                    <TD height=2 width="61%"><html:text property="companyTypeCode"/></TD></TR>
                                              <TR>
                                                    <TD height=2 width="39%">Industry Type Id</TD>
                                                    <TD height=2 width="61%"><html:text property="industryTypeId"/></TD></TR>
                                              <TR>
                                                    <TD height=3>Country *</TD>
                                                    <TD height=2><html:select property="countryCode">
                                                             <html:option value="IND">India</html:option>
                                                        </html:select></TD></TR>
                                                <TR>
                                                    <TD height=3>Location*</TD>
                                                     <TD height=2><html:select property="locationId" style="width:120px">
                                                            <html:option value="1">Kolkata</html:option>
                                                      </html:select></TD>

                                                </TR>
                                                <TR>
                                                    <TD height=2 width="39%">State *</TD>
                                                    <TD height=2 width="61%"><html:text property="stateProvince"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Address *<BR></TD>
                                                    <TD height=2 width="61%"> <html:text property="address"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Postal Code*<BR></TD>
                                                    <TD height=2 width="61%"> <html:text property="postalCode"/></TD></TR>
                                                 <TR>
                                                    <TD height=2 width="39%">Contact Person *<BR></TD>
                                                    <TD height=2 width="61%"> <html:text property="contactPerson"/></TD></TR>
                                                <TR>
                                                    <TD height=2 width="39%">Email Address *<BR></TD>
                                                    <TD height=2 width="61%"> <html:text property="emailAddress"/></TD></TR>
                                                 <TR>
                                                    <TD height=2 width="39%">Contact Number *<BR></TD>
                                                    <TD height=2 width="61%"> <html:text property="contactNumber"/></TD></TR>
                                                <TR>
                                                    <TD height=31 width="39%"></TD>
                                                    <TD height=31 width="61%"><html:submit value="Submit"/></TD></TR>

                                            </TBODY></TABLE>
                                        </html:form>
                                </DIV>

                            </TD></TR></TBODY></TABLE>

            </TD></TR></TBODY></TABLE> 

