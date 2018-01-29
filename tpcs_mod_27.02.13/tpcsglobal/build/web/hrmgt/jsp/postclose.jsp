<%
  String message = (String) request.getAttribute("message");
  if(null != message){
%>
<%=message%>
<%}%>