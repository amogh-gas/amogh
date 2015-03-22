<%@include file="imports.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>${param.pageTitle}</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />"  rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/styles/common.css" />" type="text/css">
<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
</head>
<body>
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.i18n.properties-1.0.9.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqxcore.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/menus/menus.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/common.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/Constants.js" />"></script>
	
	<h1>
		<a href="<c:url value="/" />">amogh</a>
	</h1>
	<p>Section for ${param.pageTitle} Maintenance</p>