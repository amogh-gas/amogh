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
<p>Admin section for Customer Maintenance</p>
<div id="tabs">
	<div id="menu"></div>
	<h1>Customer Master</h1>
	<div class="simple-content">
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;" >
				<label class="fieldhead">Customer Name:</label>
				<input name="customerName" id="customerName" class="customerReset"></input>
			</div>
		</div>
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Customer Address:</label>
				<input name="customerAddress" id="customerAddress" class="customerReset"></input>
			</div>			
		</div>
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Area :</label>
				<input name="customerArea" id="customerArea" class="customerReset"></input>
			</div>			
		</div>
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">State:</label>
				<input name="customerState" id="customerState" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Email:</label>
				<input name="customerEmail" id="customerEmail" class="customerReset"></input>
			</div>			
		</div> 		
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Phone:</label>
				<input name="customerPhone" id="customerPhone" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Mobile:</label>
				<input name="customerMobile" id="customerMobile" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Contact Person:</label>
				<input name="customerContactPerson" id="customerContactPerson" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">TIN No:</label>
				<input name="customerTinNo" id="customerTinNo" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">CST No:</label>
				<input name="customerCstNo" id="customerCstNo" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">PAN No:</label>
				<input name="customerPanNo" id="customerPanNo" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">ECC No:</label>
				<input name="customerECCNo" id="customerECCNo" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Holding Advice:</label>
				<input name="customerHoldingAdvice" id="customerHoldingAdvice" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Credit Days:</label>
				<input name="customerCreditDays" id="customerCreditDays" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Max Cylinder:</label>
				<input name="customerMaxCylinder" id="customerMaxCylinder" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Min Cylinder:</label>
				<input name="customerMinCylinder" id="customerMinCylinder" class="customerReset"></input>
			</div>			
		</div> 
		<div style="width: 98% !important; margin-left: 1%; margin-right: 1%; height: 40px;">
			<div style="float: left; padding-right: 5px; padding-top: 10px; width: 250px;">
				<label class="fieldhead">Second:</label>
				<input name="customerSecond" id="customerSecond" class="customerReset"></input>
			</div>			
		</div> 
		<span class="btnDataLoad" id="addResource">Add Resource</span>
	</div>
	<div id="ResourceDetails"></div>
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

    var theme = 'classic';
    $("#addResource").jqxButton({ width: '150'});
    $('#addResource').click(function(pEvent){
    	var data = {};
    	data.customerName=$('#customerName').val();
    	data.customerAddress=$('#customerAddress').val();
    	data.customerArea=$('#customerArea').val();
    	data.customerState=$('#customerState').val();
    	data.customerEmail=$('#customerEmail').val();
    	data.customerPhone=$('#customerPhone').val();
    	data.customerMobile=$('#customerMobile').val();
    	data.customerContactPerson=$('#customerContactPerson').val();
    	data.customerTinNo=$('#customerTinNo').val();
    	data.customerCstNo=$('#customerCstNo').val();
    	data.customerPanNo=$('#customerPanNo').val();
    	data.customerECCNo=$('#customerECCNo').val();
    	data.customerHoldingAdvice=$('#customerHoldingAdvice').val();
    	data.customerCreditDays=$('#customerCreditDays').val();
    	data.customerMaxCylinder=$('#customerMaxCylinder').val();
    	data.customerMinCylinder=$('#customerMinCylinder').val();
    	data.customerSecond=$('#customerSecond').val();
        $.ajax({
        	contentType : 'application/json',
            dataType: 'json',
            beforeSend: function(req) { 
        		req.setRequestHeader(header, token);
    		},
            type: "POST",
            url: './customer/addCustomer',
            data: JSON.stringify(data),
            success: function (data, status, xhr) {
            	if(data.status == 'SUCCESS') {
            		$('.customerReset').each(function(pEvent){
            			$('#'+this.id).val('');
            		});
            		alert('Customer Added.')
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