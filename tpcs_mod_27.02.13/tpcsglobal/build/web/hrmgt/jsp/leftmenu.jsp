<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<div class="sidebar_search">
    <form>
        <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
        <input type="image" class="search_submit" src="images/search.png" />
    </form>            
</div>

<div class="sidebarmenu">
    <a href="#" class="menuitem submenuheader"><b>Collaboration and Mail</b></a>
    <div class="submenu">
        <ul>
            <li><a href="my-grievancestore.do">My Grievance</a></li>
        </ul>
    </div>
    <a class="menuitem submenuheader" href="">Employee Services</a>
    <div class="submenu">
        <ul>
            <li><a href="my-profile.do">My Profile</a></li>
            <li><a href="">Payslip</a></li>
            <li><a href="">Compensation Letter</a></li>
            <li><a href="ilps.do">Apply Leave</a></li>
            <li><a href="#">My Leave Request</a></li>
            <li><a href="#">Leave Balance Report</a></li>
            <li><a href="to-update-Account-Details.do">Update Your Account Details</a></li>
            <li><a href="to-update-pers-det.do">Update Your Personal Details</a></li>
            <li><a href="to-update-edu-det.do">Update Your Educational Details</a></li>
            <li><a href="to-update-emp-office-det.do">Update Your Office Details</a></li>
        </ul>
    </div>
    <a class="menuitem submenuheader" href="" >Delivery</a>
    <div class="submenu">
        <ul>         
            <li> <a href="officein.do">Submit Office Entry Time</a></li>    
            <li><a href="assignedtasklist.do">My Assigned Tasks</a></li>
            <li><a href="planstatusreport.do">Plan your task for today</a></li>
            <li><a href="statusreport.do">Daily Status Report</a></li>
            <li><a href="to-view-my-status-report.do">View My Status Report</a></li>
            <li><a href="my-status-report.do">View My Status Report</a></li>
            <li><a href="office-attendance-report.do">View My Office Attendance</a></li>
            <li><a href="close.do">Office Leave Time</a></li>
            <li><a href="plan-your-future-task.do">Plan Your Future Task</a></li> 
            <li><a href="view-future-task.do">View Your Future Task</a></li>
            <li><a href="assigntask.do">Assign Task to Other</a></li> 
            <li><a href="to-view-daily-status.do">View daily status report</a></li>
        </ul>
    </div>
    <%-- This is devloped by Sameep Bohidar and integrated Chandan Kumar Sasmal--%>
    <a class="menuitem submenuheader" href="">Utility Management</a>
    <div class="submenu">
        <ul>
            <li><html:link action="create-jobs-request.do" title="Apply a request for your requirement">Create New Job</html:link></li>
            <li><html:link action="pending-jobs.do">Jobs Pool</html:link></li>
        </ul>
    </div>
    <a class="menuitem submenuheader" href="">Knowledge Management</a>
    <div class="submenu">
        <ul>
            <li><a href="#">Sidebar submenu</a></li>
            <li><a href="#">Sidebar submenu</a></li>
            <li><a href="#">Sidebar submenu</a></li>
            <li><a href="#">Sidebar submenu</a></li>
            <li><a href="#">Sidebar submenu</a></li>
        </ul>
    </div>
    <a class="menuitem submenuheader" href="">Talent Acquisition</a>
    <div class="submenu">
        <ul>
            <li><html:link href="walk-in-interview-data-forward.do">Schedule Interview Date</html:link></li>
            <li><html:link action="interviewee-info.do">Add New Interviewee Details</html:link></li>
            <li><html:link action="view-interviewee-info.do">View All Interviewed Candidates</html:link></li>
            <li><html:link action="view-interviewee-emails.do">View All Interviewee E-mails </html:link></li> 
            <%-- <li><a href="to-update-interviewee.do">Update Interviewee Info</a></li> --%> 
        </ul>
    </div>
    <a class="menuitem submenuheader" href="">Employee Referral</a>
    <div class="submenu">
        <ul>
            <li><a href="#">Why Refer to TPCS</a></li>
            <li><a href="#">Benefits</a></li>
        </ul>
    </div>

    <a class="menuitem submenuheader" href="">TPCS Global Helpdesk</a>
    <div class="submenu">
        <ul>
            <li><a href="contact-no.do">Store Contact No</a></li>
            <li><a href="view-contact-no.do">View Contact No</a></li>

        </ul>
    </div>

    <%--                <a class="menuitem" href="">Blue button</a>
                    
                    <a class="menuitem_green" href="">Green button</a>
                    
                    <a class="menuitem_red" href="">Red button</a>
    --%>                    
</div>


<div class="sidebar_box">
    <div class="sidebar_box_top"></div>
    <div class="sidebar_box_content">
        <h3>User help desk</h3>
        <img src="images/info.png" alt="" title="" class="sidebar_icon_right" />
        <p>
            91-33-24425535,9163527795
            <br>hr@tpcsglobal.com</br>
        </p>                
    </div>
    <div class="sidebar_box_bottom"></div>
</div>

<%--
<table width="100%" border="0" cellspacing="5" cellpadding="0" bgcolor="powderblue" >
    
    <tr>
        <td>
            <a href="office-regular-task.do" style="text-decoration: none"><b>Employee Regular Mandatory Task</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="employee-services.do" style="text-decoration: none"><b>Employee Services</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="task-management.do" style="text-decoration: none"><b>Task Management</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Delivery</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Finance</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Information Security</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Knowledge Management</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Talent Management</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>TPCS Video Channel</b></a>
        </td>
    </tr>

    <tr>
        <td>
            <a href="officeleave.do" style="text-decoration: none"><b>For Office Leave</b></a>
        </td>
    </tr>


    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>TPCS Global Helpdesk</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Infrastructure</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Wellness</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="#" style="text-decoration: none"><b>Utilities</b></a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="workforce-management.do" style="text-decoration: none"><b>Talent Acquisition</b></a>
        </td>
    </tr>
</table>

--%>