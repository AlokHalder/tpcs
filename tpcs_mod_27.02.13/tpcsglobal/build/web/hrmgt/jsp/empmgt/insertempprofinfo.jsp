<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<html:form  action="storeEmpProfRecord" styleId="trip">
    <HEAD>
        <SCRIPT language="javascript">
            /*function CreateTable(){  
                    var str = "<table id='dataTable' border='0' align='center' width='100%' ><tr>";
                    str+=" <tr><td>";
                    str+="Name <input type='text' value='<bean:write name='employeeProfFormBean' property='name'/>' readonly='true'/><br/><br/>";
                    str+="Employment Name:<html:text property="employmentname" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /> <br/><br/>";
                    str+="Duration In Year:<html:text property="empduration" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /> <br/><br/>";
                    str+="Date Of Joining:<html:text property="pastdatejoining" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /><br/><br/>";
                    str+="Date Of Release<html:text property="dateofrealise" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>";
                    str+="</td></tr></table>";
                    document.getElementById("TableHolder").innerHTML = str;  
                }*/  
           
        
            function addRow(tableID) {
 
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
            
            
                var row = table.insertRow(rowCount);
                
                var colCount = table.rows[0].cells.length;
               
                for(var i=0; i<colCount; i++) {
 
                    var newcell = row.insertCell(i);
                
                    newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                    
                    switch(newcell.childNodes[0].type) {
                        case "textarea":
                            newcell.childNodes[0].value = "";
                            break;
                        case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                        case "text":    
                            newcell.childNodes[0].value = "";
                            break;
                    }
                }
            }
 
           
            function inputFocus(i){
                if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
            }
            function inputBlur(i){
                if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
            }
 
        </SCRIPT>
    </HEAD>
    <center><h3>  Store Employee Past Details</h3></center><br/>
    <table id="dataTable" border="0" align="center" width="100%" >

    <tr>
       
        <td>
           Name <input type="text" value="<bean:write name="employeeProfFormBean" property="name"/>" readonly="true"/><br/><br/>

           Employment Name:<html:text property="employmentname" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /> <br/><br/>

           Duration In Year:<html:text property="empduration" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /> <br/><br/>

           Date Of Joining:<html:text property="pastdatejoining" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)" /><br/><br/>
            
           Date Of Release<html:text property="dateofrealise" value="" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
        </td>
    </tr>

</table>
<center>
    <INPUT type="button" value="Add More Details" onClick="addRow('dataTable')" />

    
    <html:submit value="Submit"/>
</center>

</html:form>

