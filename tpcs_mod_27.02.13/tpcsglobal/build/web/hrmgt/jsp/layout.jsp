<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

    <link rel="stylesheet" type="text/css" media="all" href="css/jsDatePick_ltr.min.css" />
    <script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
    <script type="text/javascript" src="js/jq.js"></script>
    <script type="text/javascript" src="js/jq.date.js"></script>
    <!--   this is for interviewee details submit by TPCS_PL Chandan 109 -->
    <script type="text/javascript" src="js/admin/store-interviewee-util.js"></script>
    <!-- End -->
    <script type="text/javascript">
        window.onload = function(){
            new JsDatePick({
                useMode:2,
                target:"inputField",
                dateFormat:"%d/%m/%Y"
            });
            new JsDatePick({
                useMode:2,
                target:"inputField_1",
                dateFormat:"%d/%m/%Y"
            });
            new JsDatePick({
                useMode:2,
                target:"inputField_2",
                dateFormat:"%d/%m/%Y"
            });
        };
        function camelCaps(str) {
            var fieldValue = document.getElementById(str).value;
       
            var tempArray = fieldValue.split(' ');  
            // Make the first character of each word upper
            for (var i = 0; i < tempArray.length; i++) {
                tempArray[i] = tempArray[i].charAt(0).toUpperCase() + tempArray[i].substring(1);
            }           
            document.getElementById(str).value = tempArray.join(' ');      
        }
        
        
    </script>
    <%--
    <html>
        <body bgcolor="#8ad0ff">

    <center>
        <table bgcolor="#FFFFFF" width="100%"  border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="3">
                    <tiles:insert attribute="header" />
                </td>
            </tr>
            <tr>
                <td width="157" height="584" valign="top">
                    <tiles:insert attribute="leftmenu" /></td>
                <td width="609" valign="top">
                    <tiles:insert attribute="body" />
                </td>
            </tr>
            <tr>
                <td height="177" colspan="3">
                    <tiles:insert attribute="footer" /></td>
            </tr>
        </table>
    </center>


</body>
</html>
    --%>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ADMIN PANEL | Powered by The Professional Consultancy Services</title>
        <link rel="stylesheet" href="css/ui.datepicker.css"/>

        <link rel="stylesheet" type="text/css" href="css/admin-style.css" />

        <script type="text/javascript" src="js/admin/jquery.min.js"></script>
        <script type="text/javascript" src="js/admin/ddaccordion.js"></script>
        <script type="text/javascript">
            ddaccordion.init({
                headerclass: "submenuheader", //Shared CSS class name of headers group
                contentclass: "submenu", //Shared CSS class name of contents group
                revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
                mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
                collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
                defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
                onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
                animatedefault: false, //Should contents open by default be animated into view?
                persiststate: true, //persist state of opened contents within browser session?
                toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
                togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
                animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
                oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>
        <script src="js/admin/jquery.jclock-1.2.0.js.txt" type="text/javascript"></script>
        <script type="text/javascript" src="js/admin/jconfirmaction.jquery.js"></script>
        <script type="text/javascript">
	
            $(document).ready(function() {
                $('.ask').jConfirmAction();
            });
	
        </script>
        <script type="text/javascript">
            $(function($) {
                $('.jclock').jclock();
            });
        </script>

        <script language="javascript" type="text/javascript" src="js/admin/niceforms.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="js/admin/niceforms-default.css" />

    </head>
    <body>

        <div id="main_container">

            <div class="header">
                <tiles:insert attribute="header" />
                <%-- <div class="logo"><a href="#"><img src="images/tpcs-logo.gif" alt="" title="" border="0" /></a></div>

                <div class="right_header">Welcome Admin, <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> | <a href="#" class="logout">Logout</a></div>
                <div class="jclock"></div>
                --%>
            </div>

            <div class="main_content">

                <div class="menu">
                    <ul>
                        <li><a class="current" href="home.do">Home</a></li>
                        <!--[if lte IE 6]></td></tr></table></a><![endif]-->

                        <li><a href="corporate-policy.do">Corporate Policy<!--[if IE 7]><!--></a><!--<![endif]-->
                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                            <ul>
                                <li><a href="terms-and-conditions.do">Terms and Conditions of Employment</a></li>
                                <li><a href="statement-of-facts.do">Statements of facts</a></li>
                                <li><a href="duties.do" style="text-decoration: none">Duties</a></li>
                                <li><a href="hours-of-work.do" style="text-decoration: none">Hours of work</a></li>
                                <li><a href="office-attaindance-and-leave-policy.do" style="text-decoration: none">Regular Attendance/Leave Policy</a></li>
                                <li><a href="leave-and-vacation.do" style="text-decoration: none">Leave and Vacation</a></li>                             
                                <li> <a href="code-of-conduct.do" style="text-decoration: none">Conduct</a></li>                          
                                <li><a href="dress-code.do" style="text-decoration: none">Dress Code</a></li>
                                <li><a href="confidentiality.do" style="text-decoration: none">Confidentiality</a></li>
                                <li><a href="separation-policy.do" style="text-decoration: none">Separation from the company</a></li> 
                            </ul>
                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                        </li>
                        <li><a href="global-hr.do">Global HR<!--[if IE 7]><!--></a><!--<![endif]-->
                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                            <ul>

                                <li><a class="sub1" href="" title="">Downloads<!--[if IE 7]><!--></a><!--<![endif]-->
                                    <!--[if lte IE 6]><table><tr><td><![endif]-->
                                    <ul>
                                        <li><a href="" title="">Enquiry Form</a></li>
                                        <li><a href="" title="">Feedback Form</a></li>
                                        <li><a class="sub2" href="#nogo">Requirement Forms<!--[if IE 7]><!--></a><!--<![endif]-->

                                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                                            <ul>
                                                <li><a href="download/offerletter.jsp">Offer Letter</a></li>
                                                <li><a href="download/terms&condition.jsp">Emp Terms And Condition Letter</a></li>
                                                <li><a href="download/stirictlyconfidential.jsp">Emp Strictly Confidential Letter</a></li>
                                                <li><a href="download/joiningletter.jsp">Emp Joining Letter</a></li>
                                                <li><a href="download/releaseletter.jsp">Emp Release Letter</a></li>
                                                <li><a href="download/experienceletter.jsp">Emp Experience Letter</a></li>
                                                <li><a href="download/salaryslip.jsp">Emp Salary Slip</a></li>
                                            </ul>

                                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                        </li>

                                    </ul>
                                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                </li>

                                <li><a href="" title="" class="sub1">Manage Employee</a>
                                    <ul>
                                        <li><a href="insertUserProfile.do" title="">Insert Employee Record</a></li>
                                        <li><a href="viewEmployeeRecord.do" title="">View Employee Record</a></li>
                                        <li><a href="viewAllEmployeeRecord.do" title="">View All Employee Record</a></li>
                                        <!--<li><a href="storeEmpRecord.do" title="">Store Employee Record</a></li>-->
                                        <li><a href="deleteEmployeeRecord.do" title="">Delete Employee Record</a></li>
                                        <li><a href="modifyEmployeeRecord.do" title="">Update Employee Record</a></li>
                                        <!-- <li><a href="searchEmployeeRecord.do" title="">Search Employee Record</a></li>-->
                                        <li><a href="viewEmployeeEmailId.do" title="">View Employee Email Ids</a></li>
                                        <li><a class="sub2" href="#nogo">Requirement Forms</a></li>                             
                                    </ul>
                                </li>
                            </ul>
                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                        </li>
                        <li><a href="office-management.do">Office Management<!--[if IE 7]><!--></a><!--<![endif]-->
                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                            <ul>
                                <li><a href="contact-no.do" title="">Store Contact No</a></li>
                                <li><a href="view-contact-no.do" title="">View Contact No</a></li>
                                <li><a class="sub1" href="" title="">Check List<!--[if IE 7]><!--></a><!--<![endif]-->
                                    <!--[if lte IE 6]><table><tr><td><![endif]-->
                                    <ul>
                                        <li><a href="office-todays-checklist.do" title="">Office Todays Checklist</a></li>
                                        <li><a href="office-weekly-checklist.do" title="">Office Weekly Checklist</a></li>
                                        <li><a class="sub2" href="office-monthly-checklist.do">Office Monthly Checklist<!--[if IE 7]><!--></a><!--<![endif]-->

                                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                                            <ul>
                                                <li><a href="#nogo">Salary Slip</a></li>
                                                <li><a href="#nogo">Salary Register</a></li>
                                                <li><a href="office-attendance-report.do">Attendance Register</a></li>
                                                <li><a href="#nogo">Balance Sheet</a></li>
                                            </ul>

                                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                        </li>
                                        <li><a class="sub2" href="#" title="">Finance</a>
                                            <ul>
                                                <li><a href="salaryslip.do" title="">Store Salary Details</a></li>
                                                <li><a href="searchslipdetails.do" title="">Search Salary Details</a></li>
                                            </ul>

                                        </li>
                                    </ul>
                                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                </li>


                            </ul>
                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                        </li>
                        <li><a href="receptionist-dashboard.do">Reception Dashboard<!--[if IE 7]><!--></a><!--<![endif]-->
                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                            <ul>
                                <li><a href="reception-goal-sheet.do" title="">Reception Goal Sheet</a></li>
                                <li><a href="enquiry-interview.do" title="">Enquiry Form</a></li>
                                <li><a href="view-enquiry-report.do" title="">View Enquiry Form</a></li>
                                <li><a href="to-download-cv.do">Download CV</a></li>

                                <%-- <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
                                  <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
                                  <li><a class="sub1" href="" title="">sublevel2<!--[if IE 7]><!--></a><!--<![endif]-->
                                      <!--[if lte IE 6]><table><tr><td><![endif]-->
                                      <ul>
                                          <li><a href="" title="">sublevel link</a></li>
                                          <li><a href="" title="">sulevel link</a></li>
                                          <li><a class="sub2" href="#nogo">sublevel3<!--[if IE 7]><!--></a><!--<![endif]-->

                                            <!--[if lte IE 6]><table><tr><td><![endif]-->
                                            <ul>
                                                <li><a href="#nogo">Third level-1</a></li>                                              
                                            </ul>

                                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                        </li>
                                        <li><a href="" title="">sulevel link</a></li>
                                    </ul>
                                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                                </li>
                                       
                                <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
                                --%>
                            </ul>
                            <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                        </li>
                        <li><a href="news-and-media.do" style="text-decoration: none">News &AMP; Media</a>

                            <ul> <li><a href="tpcs-news-event.do">Post News &amp; Event</a></li></ul>
                            
                        </li>
                        <!-- <li><a href="food-for-thoughts.do">Food 4 Thoughts</a></li> -->
                        <li><a href="#">Quick Link</a>
                            <ul>
                                <li><a href="download/hikeletter.jsp">Hike Letter</a></li>
                                <li><a href="#nogo">Anniversary Letter </a></li>
                                <li><a href="#nogo">Appraisal Letter</a></li>
                                <li><a href="#nogo">Bonafied Employee</a></li>
                            </ul>
                        </li>
                        <li><a href="leave-calendar.do">Time Out</a></li>

                    </ul>
                </div>


                <div class="center_content">  
                    <div class="left_content">
                        <tiles:insert attribute="leftmenu" />
                    </div>  
                    <div class="right_content"> 
                       <div id="rounded-corner">
                            <tiles:insert attribute="body" />                  
                        </div>                       
                    </div><!-- end of right content-->
                </div>   <!--end of center content -->               

               <div class="clear"></div>
            </div> <!--end of main content-->


            <div class="footer">

                <div class="left_footer"> ADMIN PANEL | Powered by The Placement Consultancy Services<a href="http://ptutor.org/"></a></div>


            </div>

        </div>		
    </body>
</html>