<%@page import="java.util.List" %>
<%@page import="com.hrmgt.emp.vo.UserLoginVO" %>

<table cellpadding="5" border="2">
    <tr style="background-color: gold">
        <td><b><%out.println("user_id");%></b></td>
        <td><b><%out.println("Name");%></b></td>
     </tr>
        <%
            List<UserLoginVO> listoflogindata = (List<UserLoginVO>) request.getAttribute("message");

        for( UserLoginVO userLoginVO :listoflogindata){
         %>
                <TR>
                    <TD><%=userLoginVO.getUserid()%></TD>
                    <TD><%=userLoginVO.getName()%></TD>
        
                </TR>
          <%}%>
   
</table>