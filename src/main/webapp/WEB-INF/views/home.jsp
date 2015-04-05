<%@include file="imports.jsp" %>
<%@ page session="false"%>
<spring:message htmlEscape="true" code="home.heading" var="pageTitle" />
<jsp:include page="../views/header.jsp">
    <jsp:param name="pageTitle" value="${pageTitle}"/>
</jsp:include>

<div id="tabs">
<div class="wrapper row2">
  <div class="rounded" style="background-color:lightslategrey">
  <div style="background-image:url(http://www.html.am/images/image-codes/milford_sound_t.jpg);width:initial;height:160px;color:black;font-size:18px;">
	<marquee>WELCOME to AMOGH GAS PVT. LTD</marquee>
</div>
  </div>
</div>
</div>
  

<jsp:include page="../views/footer.jsp"/>
