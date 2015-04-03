<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Amogh</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<c:url value="/resources/layout/styles/layout.css"/>"
	rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row0">
		<div id="topbar" class="clear">
			<!-- ################################################################################################ -->
			<nav>
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</nav>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row1">
		<header id="header" class="clear">
			<!-- ################################################################################################ -->
			<div id="logo" class="fl_left">
				<h1>
					<a href="<c:url value="/" />">Amogh</a>
				</h1>
				<p>Amogh Website Template</p>
			</div>
			<div class="fl_right">
				<form class="clear" method="post" action="#">
					<fieldset>
						<legend>Search:</legend>
						<input type="text" value="" placeholder="Search Here">
						<button class="fa fa-search" type="submit" title="Search">
							<em>Search</em>
						</button>
					</fieldset>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</header>
	</div>
	<div class="wrapper row2">
		<div class="rounded">
			<section class="loginform cf" style="height:80px;">
				<form method='POST'
					action="${pageContext.request.contextPath}/j_security_check"
					name='logon' autocomplete='off'>
					<ul>
						<li><label for="j_username">User Name</label> <input type="text"
							id="j_username" name="j_username" placeholder="yourname" required>
						</li>
						<li><label for="j_password">Password</label> <input
							type="password" id="j_password" name="j_password" placeholder="password" required></li>
						<li><input type="submit" value="Login"></li>
					</ul>
				</form>
			</section>
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
<script>
var sPageURL = window.location.search.substring(1);
var sURLVariables = sPageURL.split('&');
for (var i = 0; i < sURLVariables.length; i++)
{
	var sParameterName = sURLVariables[i].split('=');
	if (sParameterName[0] == 'Logout' && sParameterName[1])
	{
		window.location="../";
	}
}
</script>
</body>
</html>