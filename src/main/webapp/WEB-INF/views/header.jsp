<%@include file="imports.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="sptg"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>${param.pageTitle}</title>
<link href="<c:url value="/resources/layout/styles/layout.css" />" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/jqwidgets/styles/jqx.energyblue.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/styles/common.css" />" type="text/css">
<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

</head>
<body id="top">
	<c:set var="currentUser">
		<sec:authentication property="principal.username" />
	</c:set>
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.i18n.properties-1.0.9.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqxcore.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/menus/menus.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/common.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/Constants.js" />"></script>
	<div class="wrapper row0">
	  <div id="topbar" class="clear"> 
	    <!-- ################################################################################################ -->
	    <nav>
		   <ul>
				<li><a href="#">Home</a></li>
				<c:if test="${not empty currentUser}">
					<li><a
						href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a></li>
				</c:if>
			</ul>
	    </nav>
	    <!-- ################################################################################################ --> 
	  </div>
	</div>
	<div class="wrapper row1">
	  <header id="header" class="clear"> 
	    <!-- ################################################################################################ -->
	    <div id="logo" class="fl_left">
	      <h1><a href="<c:url value="/" />">amogh</a></h1>
	      <p>Section for ${param.pageTitle} Maintenance</p>
	    </div>
	    <div class="fl_right">  
	      <form class="clear" method="post" action="#">
	        <fieldset>
	          <legend>Search:</legend>
	          <input type="text" value="" placeholder="Search Here">
	          <button class="fa fa-search" type="submit" title="Search"><em>Search</em></button>
	        </fieldset>
	      </form>		
	    </div>
	    <div class="fl_right" style="margin-right: 0.5%;">
	      <div id="menu"></div>
	    </div>
	    <!-- ################################################################################################ --> 
	  </header>
	</div>
	<div id="wrongNotification">
        <div>Fill required details.</div>
    </div>