<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.tpcs.admin.taskmgt.vo.ResultVO"%>
<div class="body_resize" style="-moz-border-radius: 5px;border-radius: 5px;">
    <div class="left">
        <h2>Contact Us</h2><br>
        <h4>Freshers and their Guardians must read <a href='career-for-freshers.do'><span>Career For Freshers link</span></a> well before coming for an interview to TPCS Global)</h4>
        <p><strong>TPCS Global </strong></p>
        <p><strong>E-mail: <a href="mailto:info@tpcsglobal.com" style="text-decoration: none;">info@tpcsglobal.com</a> or <a href="mailto:sales@tpcsglobal.com" style="text-decoration: none;">sales@tpcsglobal.com</a></strong></p>
        <p><strong>Website: <a href="http://www.tpsglobal.com" style="text-decoration: none;">http://www.tpsglobal.com</a></strong></p>
        <form action="contactus.do" method="post" id="contactform">
            <%
                ResultVO resultVO = (ResultVO) request.getAttribute("resultvo");
                if (resultVO != null) {
                    if (resultVO.getMessage().equals("true")) {%>
            <font color="red"><%="THANX FOR CONTACT WITH US"%></font>
            <% } else {%>
            <font color="red"><%="VALUE IS NOT INSERTED"%></font>              
            <%  }

                }

            %>
            
            <fieldset>
                <legend><font style="font-size:18px;color: #000000">Please feel up below forms</font></legend>
                    <table border="0">
                        <tr>
                            <td><label for="name">First Name <span>*</span></label></td>
                            <td><input id="name" name="name" class="text" /></td>
                        </tr>
                         <tr>
                            <td></td>
                            <td><font color="red"><html:errors property="name"/></font></td>
                        </tr>
                        <tr>

                            <td><label for="email">Your email Id<span class="red">*</span></label></td>
                            <td><input id="email" name="email" class="text" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><font color="red"><html:errors property="email"/></font></td>
                        </tr>
                        <tr>
                            <td><label for="company">Company</label></td>
                            <td><input id="company" name="company" class="text" /></td>
                        </tr>
                        <tr> 
                            <td> <label for="subject">Subject</label></td>
                            <td><input id="subject" name="subject" class="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="message">Message <span class="red">*</span></label></td>
                            <td><textarea id="message" name="message" rows="6" cols="50"></textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><font color="red"><html:errors property="message"/></font></td>
                        </tr>
                        <tr class="buttons">
                            <td>&nbsp;</td>
                            <td> <input type="image" name="imageField" id="imageField" src="images/send.gif" /></td>
                        </tr>                        
                    </table>
              
            </fieldset>
        </form>
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
        <p><a href="#">Phone</a>:  91-33-2442-5535<br />
            <a href="#">Mobile</a>: 91-9163527795<br />
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
            <a href="www.phpsiliguri.com">Website :www.tpcsglobal.com,www.phpsiliguri.com </a> 
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