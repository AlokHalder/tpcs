<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<script type="text/javascript">

    function inputFocus(i){
        if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
    }
    function inputBlur(i){
        if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
    }
</script>


<div class="logo"><a href="home.do"><img src="images/tpcs-logo_n.png" alt="" title="" border="0" /></a></div>
<div class="right_header">Welcome <%=session.getAttribute("username")%><br/>Your Role :<%=session.getAttribute("userrole")%><br><a href="passmgt.do">Password Management</a> |<a href="logout.do" class="logout">Logout</a></div>
<div>
    <html:form action="searchEmpRecord"> 
        <table align="right"border="0" >
            <tr>
                <td>,<font style="color:#FFFFFF"> Search :</font></td>
                <td><select>
                        <option>People</option>
                        <option>Application</option>
                        <option>Content</option>
                    </select>
                </td>
                <td valign="bottom">
                    <input type="text" name="data" title="First Name" style="color:#888;" 
                           value="Associate No/Name" onfocus="inputFocus(this)" onblur="inputBlur(this)" />
                </td>
                <td><html:submit value="Go"></html:submit> </td>
                </tr>
            </table>
    </html:form>
</div>    
<%--<div class="jclock"></div> --%>
<%-- <div><a href="#" class="messages">Password Management</a></div>  --%>
