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
	
	<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<h1><a href="<c:url value="/" />">mahesh-sample</a></h1>
<p>Admin section for Menu Maintenance</p>
<div id="tabs">
	<div id="menu"></div>
	
	<div class="simple-content">
		<div
		style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 70px;">
			<div
				style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Menu Description:</label>
				<input name="menuDesc" id="menuDesc"></input>
			</div>
			<div
				style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Menu URL:</label>
				<input name="menuUrl" id="menuUrl"></input>
			</div>
			<div
				style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
					<label class="fieldhead">Parent Id:</label>
					<input name="parentId" id="parentId" value="-1" readonly></input>
				</div>
			</div> 
			<span
				class="btnDataLoad" id="addResource">Add Resource</span>
	</div>
	<div id="ResourceDetails"></div>
</div>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.11.2/jquery-1.11.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqwidgets/jqx-all.js" />"></script>

<script type="text/javascript">
$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
    var theme = 'classic';
    var source =
    {
    	contentType : 'application/json',
    	datatype: "json",
        datafields: [
             { name: 'id' },
			 { name: 'menuDesc' },
			 { name: 'menuUrl' }
        ],
        id: 'id',
        type: "POST",
        url: './response/default/getMenuDetails',
        root: 'rows',
        beforeSend: function(req) { 
    		req.setRequestHeader(header, token);
		},
        beforeprocessing: function (data) {
        	source.totalrecords = data.result.totalRows;
        },
        
    };
    
    var dataadapter = new $.jqx.dataAdapter(source,
    	    {
    	        formatData: function (data) {
    	        	return JSON.stringify(data);
    	        }
    	    }
    	);
    //Initialise jqxGrid
    $("#ResourceDetails").jqxGrid(
    {
        width: '99.5%',
        selectionmode: 'singlecell',
        source: dataadapter,
        theme: theme,
        editable: true,
        autoheight: true,
        pageable: true,
        virtualmode: true,
        rendergridrows: function () {
            return dataadapter.records;
        },
        columns: [
              { text: 'id', editable: false, datafield: 'id', hidden: true },
              { text: 'Menu Description', datafield: 'menuDesc', width: "50%" },
              { text: 'Menu URL', datafield: 'menuUrl', width: "50%" }
          ]
    });
    
    $('#addResource').click(function(pEvent){
    	var data = {};
    	data.parentId=$('#parentId').val();
    	data.menuDesc=$('#menuDesc').val();
    	data.menuUrl=$('#menuUrl').val();
        $.ajax({
        	contentType : 'application/json',
            dataType: 'json',
            beforeSend: function(req) { 
        		req.setRequestHeader(header, token);
    		},
            type: "POST",
            url: './response/default/addMenuDetails',
            data: JSON.stringify(data),
            success: function (data, status, xhr) {
            	if(data.status == 'SUCCESS') {
            		$("#ResourceDetails").jqxGrid('updatebounddata');
    			}
            }
        });
    });
    
    var nullCheck = function(id) {
    	return $('#'+id).val() != null && $('#'+id).val() != '';
    };
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

});
</script>
</body>
</html>