<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/layout.jsp"  flush="true">
  <tiles:put name="title" value="Tiles"/>
  <tiles:put name="header" value="/header.jsp"/>
  <tiles:put name="leftmenu" value="/leftmenu.jsp"/>
  <tiles:put name="body" value="/body.jsp"/>
  <tiles:put name="footer" value="/footer.jsp"/>

</tiles:insert>