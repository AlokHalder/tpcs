<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

            
<div class="body_resize" style="-moz-border-radius: 5px;border-radius: 5px;">
    <div class="left">
    <html:form action="upload-cv-server.do" styleId="contactform" enctype="multipart/form-data">
            <fieldset>
                <legend><font style="font-size:18px;color: #000000">Please feel up below forms</font></legend>
                <%
                String message = (String) request.getAttribute("filemessage");
                if(message!=null){
                %>
      
                <font color="red"><%=message%></font>
                <%}%>    
                <table border="0">
                        <tr>
                            <td><label for="name">Name <span class="red">*</span></label></td>
                            <td><html:text styleId="name" property="name" styleClass="text" />
                        <br><font color="red"><html:errors property="name"/></font></td>
                        </tr>
                        <tr>

                            <td><label for="email">Your email Id<span class="red">*</span></label></td>
                            <td><html:text styleId="email" property="email" styleClass="text" />
                        <br> <font color="red"><html:errors property="email"/></font></td>
                        </tr>
                                                
                        <tr>
                            <td><label for="phno">Phone Number<span class="red">*</span></label></td>
                            <td><html:text styleId="phno" property="phno" styleClass="text" />
                        <br><font color="red"><html:errors property="phno"/></font></td>
                        </tr>
                        <tr>
                            <td><label for="technology">Technology <span class="red">*</span></label></td>
                            <td><html:select property="technology" styleId="technology">
                                    <html:option value="">Select The Technology</html:option>
                                    <html:option value="J2EE">Java & J2EE</html:option>
                                    <html:option value=".NET">.NET</html:option>
                                    <html:option value="PHP">PHP</html:option>
                                    <html:option value="DBA">DBA</html:option>
                                </html:select>
                            <br/><font color="red"><html:errors property="technology"/></font></td>
                        </tr>
                        <tr>
                            <td><label for="experience">Experience <span class="red">*</span></label></td>
                            <td><html:text styleId="experience" property="experience" styleClass="text"/>
                            <br/><font color="red"><html:errors property="experience"/></font></td>
                        </tr>
                        <tr>
                            <td><label for="uploadcv">Upload CV (.doc/.docx/.pdf File)<span class="red">*</span></label></td>
                            <td><html:file property="theFile"/>
                                <br><font color="red"><html:errors property="theFile"/></font>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><html:submit value="Submit"></html:submit></td>
                        </tr>                        
                    </table>
              
            </fieldset>
        </html:form>
        <br/>
        <h2>Route Direction to Head Office</h2>                       

        <h3> <font color="#800000" style="font-weight: bold"> From Ruby Hospital </font></h3>                   
        <font color="#333">Take an auto/bus from Ruby towards Gariahat .Step down at Kasba New Police Station (Kasba Natun Thana)which is next stoppage after Tribarna 
        <br/><br/>                     
        Turn left direction from main road from bus stop. Take a Rikshwa from stand &rarr; Come to Bose Pukur Masjid &rarr; Notice one grocery shop named 'Ashirbad Bhandara' &rarr; Turn right
        from main road &rarr; Last Building &rarr; TPCS Global (91/39H,Bose Pukur Road,Kol-42)  
        </font>

        <h3> <font color="#800000" style="font-weight: bold">From Gariahat More</font></h3>                   
        <font color="#333">Take an auto/bus from Gariahat towards Ruby Hospital . Step down at Kasba New Police Station (Kasba Natun Thana) . It is next bus stop after Bakultala crossing Ballygunge Bijan Setu Flyover .
        <br/><br/>&rarr; Cross the road to opposite foot  &rarr;  Take a Rikshwa from stand &rarr; Come to Bose Pukur Masjid &rarr; Notice one grocery shop named 'Ashirbad Bhandara' &rarr; Turn right
        from main road &rarr; Last Building &rarr; TPCS Global (91/39H,Bose Pukur Road,Kol-42) 
        </font>

        <h3> <font color="#800000" style="font-weight: bold">From Ballygung Station</font></h3>                   
        <font color="#333"> Cross the 1st foot bridge towards Kasba . Take a riksha to Kasba Post Office Bus Stop in ByPass or come to Bijan Setu Flyover 
        Take an auto/bus towards Ruby Hospital . Step down at Kasba New Police Station (Kasba Natun Thana) . It is next bus stop after Bakultala crossing Ballygunge Bijan Setu Flyover .
        <br/><br/>&rarr; Cross the road to opposite foot  &rarr;  Take a Rikshwa from stand &rarr; Come to Bose Pukur Masjid &rarr; Notice one grocery shop named 'Ashirbad Bhandara' &rarr; Turn right
        from main road &rarr; Last Building &rarr; TPCS Global (91/39H,Bose Pukur Road,Kol-42) 
        </font>
    </div>
       <div class="right">
        <h2>Address</h2>
            TPCS Global <br/>                
        Contact Office : 91/39H Bose Pukur Road . Kol-42           
        <p><a href="#">Phone</a>:  91-33-65400826<br />
            <a href="#">Mobile</a>: 91-9748556776<br />
            <a href="#">Email :hrd@tpcsglobal.com </a><br />
            <a href="#">Email : tpcsglobal@gmail.com</a><br />           
        </p>
        <h2>Branch Address</h2>
        <p> <h2>Siliguri </h2></p>
        TPCS Global <br/>         
        Contact Office: Haider Para More (Opposite Swamiji Club)
        <p> <a href="#">Mobile</a>:91-9749389792<br />
            <a href="#">Email :hrd@tpcsglobal.com </a><br />
            <a href="#">Email : tpcsglobal@gmail.com</a><br />                      
            <a href="www.phpsiliguri.com">Website : www.tpcsglobal.com,www.phpsiliguri.com </a> 
        </p>
        <h2>Upcoming Branches</h2>
        <p> <a href="#">Saltlake Sec V, Kolkata, West Bengal</a></p>
                <p> <a href="#">Bangalore, Karnataka</a></p>

        <p> <a href="#">Bhubaneswar, Odisha</a></p>
        <p><strong>More Information</strong><br />
        </p>
        <!-- <img src="images/map.jpg" alt="picture" width="270" height="185" /> -->

        <h2>Route Direction to Siliguri Office</h2>                       

        <!--   <h3> <font color="#800000" style="font-weight: bold"> From Ruby Hospital </font></h3>                   
           <font color="#333">Take an auto/bus from Ruby towards Gariahat .  Step down at  Bakultala Bustop (Kasba) .
               You will be at "Nabarun Sangha " club<br/><br/>                     
               From there you go to left side &rarr; Kasba Blue Print (Medical Shop)  &rarr; Kishore Tailors  &rarr; Right turn  &rarr; turn again left  &rarr;  The Professional Consultancy Services (95/24,Bose Pukur Road,Kol-42)  
           </font>
        -->
    </div>
    <div class="clr"></div>
</div>
    
    
