<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>amogh</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" media="screen">
	
	<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<div id="tabs">
	<div id="menu"></div>
</div>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>
<script>
	MvcUtil = {};
	MvcUtil.showSuccessResponse = function (text, element) {
		MvcUtil.showResponse("success", text, element);
	};
	MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
		MvcUtil.showResponse("error", text, element);
	};
	MvcUtil.showResponse = function(type, text, element) {
		var responseElementId = element.attr("id") + "Response";
		var responseElement = $("#" + responseElementId);
		if (responseElement.length == 0) {
			responseElement = $('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>').insertAfter(element);
		} else {
			responseElement.replaceWith('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>');
			responseElement = $("#" + responseElementId);
		}
		responseElement.fadeIn("slow");
	};
	MvcUtil.xmlencode = function(xml) {
		//for IE 
		var text;
		if (window.ActiveXObject) {
		    text = xml.xml;
		 }
		// for Mozilla, Firefox, Opera, etc.
		else {
		   text = (new XMLSerializer()).serializeToString(xml);
		}			
		    return text.replace(/\&/g,'&'+'amp;').replace(/</g,'&'+'lt;')
	        .replace(/>/g,'&'+'gt;').replace(/\'/g,'&'+'apos;').replace(/\"/g,'&'+'quot;');
	};
</script>	
<script type="text/javascript">
$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
    	contentType : 'application/json',
    	type: "POST",
    	beforeSend: function(req) { 
    		req.setRequestHeader(header, token);
		},
        dataType: 'json',
        url: "./response/default/getMenus",
        success: function (data, status, xhr) {
        	console.log(data.result);
        	var source =
            {
        		contentType : 'application/json',
                datatype: "json",
                datafields: [
                    { name: 'id' },
                    { name: 'parentId' },
                    { name: 'menuDesc' },
                    { name: 'menuUrl' }
                ],
                id: 'id',
                localdata: data.result
            };
            // create data adapter.
            var dataAdapter = new $.jqx.dataAdapter(source);
         	// perform Data Binding.
            dataAdapter.dataBind();
            var records = dataAdapter.getRecordsHierarchy('id', 'parentId', 'items', [{ name: 'menuDesc', map: 'label'}]);
            $('#menu').jqxMenu({ source: records, height: 30,  width: '100%' });
            $("#menu").on('itemclick', function (event) {
            	console.log( dataAdapter.recordids[event.args.id].menuUrl);
                window.location.href=dataAdapter.recordids[event.args.id].menuUrl;
            });
            
        },
        error: function () {
            
        }
    });  
});
</script>
</body>
</html>