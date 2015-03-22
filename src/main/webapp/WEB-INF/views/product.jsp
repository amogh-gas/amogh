<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>mahesh-sample</title>
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
	<h1>
		<a href="<c:url value="/" />">mahesh-sample</a>
	</h1>
	<p>Admin section for Customer Maintenance</p>
	<div id="tabs">
		<div id="menu"></div>		
		<div id="productMenu" style="visibility: hidden;">
			<p>PRODUCTS</p>
			<input type="button" value="Open" id="showWindowButton" />
	        <p></p>
			<div id="productDetails" style="font-size: 13px; font-family: Verdana;"></div>
		</div>
		
		<div id="mainDemoContainer">
            <div id="customWindow" style="visibility: hidden;">
                <div id="customWindowHeader">
                    <span id="captureContainer" style="float: left">Product </span>
                    <input type="button" value="Close" id="hideWindowButton" style="margin-left: 3px" />
                    <input type="button" value="Collapse" id="collapseWindowButton" style="margin-left: 3px" />
                    <input type="button" value="Expand" id="expandWindowButton" style="margin-left: 3px" />
                </div>
                <div id="customWindowContent" style="overflow: hidden">
                    <input id="saveType" name="saveType" type="hidden" readonly="readonly"/>
                    <div style="margin: 5px">
                        <table class="register-table">
							<tr>
								<td>Product Name:</td>
								<td>
									<input type="text" id="name" name="name" class="text-input required productReset"/>
									<input id="id" name="id" type="hidden" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>Product Type:</td>
								<td>
									<div id="type" class="jqx-dropdownlist-content required"></div>
								</td>
							</tr>
							<tr>
								<td>Product Desc:</td>
								<td><input type="text" id="desc" name="desc" class="text-input productReset" /></td>
							</tr>
							<tr>
								<td>Short Desc:</td>
								<td><input type="text" id="shortDesc" name="shortDesc" class="text-input productReset"/></td>
							</tr>
							<tr>
								<td>Unit:</td>
								<td><input type="text" id="unit"  name="unit" class="text-input productReset required" /></td>
							</tr>
							<tr>
								<td>Under:</td>
								<td><input type="text" id="under" name="under" class="text-input productReset required"/></td>
							</tr>
							<tr>
								<td>Tariff Code:</td>
								<td><input type="text" id="tariffCode" name="tariffCode" class="text-input productReset required"/></td>
							</tr>
							<tr><td colspan="2"></td></tr>
							<tr>
								<td colspan="2" style="text-align: center;">
									<!-- <input type="button" value="Save" id="saveButton" /> 
									<input type="button" value="Cancel" id="cancelButton" /> -->
									<input type="button" value="Save" style="margin-bottom: 5px;" id="saveButton" />
									<input type="button" value="Cancel" id="cancelButton" />
								</td>
							</tr>
						</table>                        
                </div>
            </div>
        </div>
		
		
		<!-- <p></p>
		<div style="visibility: hidden;" id="productWindow">
			<div id="product">
				<div>
					<h3>Product</h3>
				</div>
				<div>
					<form id="productForm" action="./">
						<table class="register-table">
							<tr>
								<td>Product Name:</td>
								<td><input type="text" id="name" class="text-input" /></td>
							</tr>
							<tr>
								<td>Product Type:</td>
								<td>
									<div id="productTypeList" class="jqx-dropdownlist-content"></div>
								</td>
							</tr>
							<tr>
								<td>Product Desc:</td>
								<td><input type="text" id="description" class="text-input" /></td>
							</tr>
							<tr>
								<td>Short Desc:</td>
								<td><input type="text" id="shortDesc" class="text-input" /></td>
							</tr>
							<tr>
								<td>Unit:</td>
								<td><input type="text" id="unit" class="text-input" /></td>
							</tr>
							<tr>
								<td>Under:</td>
								<td><input type="text" id="under" class="text-input" /></td>
							</tr>
							<tr>
								<td>Tariff Code:</td>
								<td><input type="text" id="tariffCode" class="text-input" /></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="button" value="Save" id="saveButton" /> <input
									type="button" value="Cancel" id="cancelButton" /> <button id="primaryButton">Primary</button>
								</td>
							</tr>

						</table>
					</form>
				</div>
			</div>
		</div> -->
	</div>

	<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.i18n.properties-1.0.9.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqxcore.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/menus/menus.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/common.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/common/Constants.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/masterjs/product.js" />"></script>

</body>
</html>