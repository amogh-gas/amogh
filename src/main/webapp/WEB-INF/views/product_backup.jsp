<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>mahesh-sample</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" media="screen">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles/common.css" />" media="screen">
	<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	
</head>

 
<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/menus/menus.js" />"></script>

<script type="text/javascript" src="/resources/scripts/jquery-1.11.1.min.js"></script>   
    <script type="text/javascript" src="/resources/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="/resources/jqwidgets/jqxexpander.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxvalidator.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxbuttons.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxcheckbox.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/globalization/globalize.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxcalendar.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxdatetimeinput.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxmaskedinput.js"></script> 
    <script type="text/javascript" src="/resources/jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="/resources/jqwidgets/jqxbuttons.js"></script> 
    <script type="text/javascript" src="/resources/scripts/demos.js"></script> 
    
    <script type="text/javascript" src="/resources/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="/resources/jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="/resources/jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript" src="<c:url value="/resources/masterjs/product.js" />"></script>
<body>
<h1><a href="<c:url value="/" />">mahesh-sample</a></h1>
<p>Admin section for Customer Maintenance</p> 
<div id="tabs">
	<div id="menu"></div>
	<p></p>	
	<div id="product">
        <div><h3>Product</h3></div>
        <div>  
        	<form id="productForm" action="./">          
                <table class="register-table">
                    <tr>
                        <td>Product Name:</td>
                        <td><input type="text" id="name" class="text-input" /></td>
                    </tr>
                    <tr>
                        <td>Product Type:</td>
                        <td id="productTypeList">
                        	<div id="productTypeList"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>Product Desc:</td>
                        <td><input type="text" id="description" class="text-input" /></td>
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
                        <td colspan="2" style="text-align: center;">
                        <input type="button" value="Save" id="saveButton" />
                        <input type="button" value="Cancel" id="cancelButton" />
                        <!-- <button id="primaryButton">Primary</button> -->
                        </td>
                    </tr>
                    
                </table>
			</form>
			<!-- <div id="productTypeList"></div> -->
        </div>
        
    </div>
	
</div>


</body>

</html>