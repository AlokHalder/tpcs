<%--<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>--%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="body_resize" style="-moz-border-radius: 5px;border-radius: 5px;">
    <div class="left" style="width:800px">
       <h2>News &amp; Events</h2>


<display:table id="listOfNewsAndEvent" name="sessionScope.newsActionForm.listOfNewsAndEvent" requestURI="/more-news.do" pagesize="10"  cellpadding="15">
    <display:column property="date" />
    <display:column property="newsdetails" /> 
</display:table>
    
<%--<logic:iterate id="listOfNewsAndEvent" name="newsActionForm" property="listOfNewsAndEvent">
    <h3><bean:write name="listOfNewsAndEvent" property="date"/></h3>
    <p><bean:write name="listOfNewsAndEvent" property="newsdetails"/>
</logic:iterate>--%>
  </div>
    <div class="clr"></div>

</div>