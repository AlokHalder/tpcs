<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.tpcs.admin.taskmgt.vo.ResultVO"%>
<div class="body_resize" style="-moz-border-radius: 5px;border-radius: 5px;">
    <div class="left">
        <h2>Registration For Training Purpose </h2>
        <p><strong>THE PROFESSIONAL CONSULTANCY SERVICES </strong></p>
        <p><strong>E-mail: <a href="mailto:info@tpcsglobal.com" style="text-decoration: none;">info@tpcsglobal.com</a> or <a href="mailto:sales@tpcsglobal.com" style="text-decoration: none;">sales@tpcsglobal.com</a></strong></p>
        <p><strong>Website: <a href="http://www.tpsglobal.com" style="text-decoration: none;">http://www.tpsglobal.com</a></strong></p>
        <form action="registration-training.do" method="post" id="contactform">
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
                            <td><label for="name">Name <span class="red">*</span></label></td>
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

                            <td><label for="altemail">Your Alternative email Id</label></td>
                            <td><input id="altemail" name="altemail" class="text" /></td>
                        </tr>
                        
                        <tr>
                            <td><label for="phno">Phone Number<span class="red">*</span></label></td>
                            <td><input id="phno" name="phno" class="text" /></td>
                        </tr>
                         <tr>
                            <td></td>
                            <td><font color="red"><html:errors property="phno"/></font></td>
                        </tr>
                        <tr> 
                            <td> <label for="altphno">Alternative Phone Number</label></td>
                            <td><input id="altphno" name="altphno" class="text" /></td>
                        </tr>
                        <tr>
                            <td><label for="message">Message <span class="red">*</span></label></td>
                            <td><textarea id="message" name="message" rows="6" cols="50"></textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><font color="red"><html:errors property="message"/></font></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><html:submit value="Submit"></html:submit></td>
                        </tr>                        
                    </table>
              
            </fieldset>
        </form>
       
    </div>
    <div class="right">
        <h2>Address</h2>
        The Professional Consultancy Services <br/>                
        Contact Office : 91/39H Bose Pukur Road . Kol-42           
        <p><a href="#">Phone</a>:  91-33-65400826<br />
            <a href="#">Mobile</a>: 91-9748556776<br />
            <a href="#">Email :hr@tpcsglobal.com </a><br />
            <a href="#">Email : tpcsglobal@gmail.com</a><br />           
        </p>
        <h2>Branch Address</h2>
        <p> <h2>Siliguri </h2></p>
        The Professional Consultancy Services <br/>         
        Contact Office: Haider Para More (Opposite Swamiji Club)
        <p> <a href="#">Mobile</a>:91-9749389792<br />
            <a href="#">Email :hr@tpcsglobal.com </a><br />
            <a href="#">Email : tpcsglobal@gmail.com</a><br />                      
            <a href="www.phpsiliguri.com">Website : www.tpcsglobal.com,www.phpsiliguri.com </a> 
        </p>
        <h2>Upcoming Branches</h2>
        <p> <a href="#">Saltlake, West Bengal</a></p>
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