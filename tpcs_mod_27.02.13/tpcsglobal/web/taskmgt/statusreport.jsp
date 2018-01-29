<%@taglib  uri="http://struts.apache.org/tags-html"  prefix="html"%>
  
<html:form action="submitStatusReport.do">
        <HEAD>
        <TITLE> PLAN YOUR STATUS REPORT </TITLE>
        <SCRIPT language="javascript">
        
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
                        
                    }
                }
            }
 
            function deleteRow(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
 
                    for(var i=0; i<rowCount; i++) {
                        var row = table.rows[i];
                        var chkbox = row.cells[0].childNodes[0];
                        if(null != chkbox && true == chkbox.checked) {
                            if(rowCount <= 1) {
                                alert("Cannot delete all the rows.");
                                break;
                            }
                            table.deleteRow(i);
                            rowCount--;
                            i--;
                        }
                    }
                }catch(e) {
                    alert(e);
                }
            }
 
        </SCRIPT>
    </HEAD>
    <BODY>   
         <center> <%
        String message = (String) request.getAttribute("message");
        if (null != message) {
        %>
        <font color="green" style="font-weight: bold"> <%=message%> </font>
        <%
            }
        %>
    </center>  
    <center><B> Insert your Daily task</b></center>
<table id="dataTable" border="0" align="center" >

    <tr>
        <TD><INPUT type="checkbox" name="chk"/></TD>
         <td>
             <html:textarea property="statusReport" ></html:textarea>
        </td>
    </tr>
</table>
        <center>
        <INPUT type="button" value="Add Row" onClick="addRow('dataTable')" />

        <INPUT type="button" value="Delete Row" onClick="deleteRow('dataTable')" />
        </center>
        
    <table align="center">
    <tr>
        <td><b>Billable Hours :</b></td>
        <td>
      <html:text property="billableHours" ></html:text>
        </td>
    </tr>
    <tr>
        <td><b>Idle Hours :</b></td>
         <td>
           <html:text  property="nonBillableHours" ></html:text>
        </td>
        
    </tr> 
</table>
        <center><input type="submit" value="submit"/></center>
        
    </BODY>               
</html:form>     