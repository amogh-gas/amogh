<%@include file="imports.jsp" %>
<%@ page session="false"%>
<spring:message htmlEscape="true" code="product.heading" var="pageTitle"/>
<jsp:include page="../views/header.jsp">
    <jsp:param name="pageTitle" value="${pageTitle}"/>
</jsp:include>

<jsp:include page="../views/footer.jsp"/>
