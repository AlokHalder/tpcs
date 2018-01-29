<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic"  prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"%>
<body bgcolor="#8ad0ff">

    <table border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td>
                <font color="red"> Name</font>
            </td>
            <td>
                <font color="red"> Email ID</font>
            </td>
            <td>
                <font color="red">Technology</font>
            </td>
            <td>
                <font color="red"> Experience</font>
            </td>
            <td>
              <font color="red"> Resume</font>
            </td> 
        </tr>

        <logic:iterate id="downloadCvFormBean" name="downloadCvFormBean" property="listOfCv">
            <tr>
                <td>
                    <bean:write name="downloadCvFormBean" property="name"/>
                </td>
                <td>
                    <bean:write name="downloadCvFormBean" property="email"/>
                </td>
               
                <td>
                    <bean:write name="downloadCvFormBean" property="technology"/>
                </td>
                <td>
                    <bean:write name="downloadCvFormBean" property="experience"/>
                </td>
                <td>
                    <a href="<bean:write name="downloadCvFormBean" property="filename"/>">Download Cv</a>
                </td> 
            </tr>
        </logic:iterate>
    </table>




</body>