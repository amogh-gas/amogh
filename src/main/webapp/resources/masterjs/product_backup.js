$(document).ready(function() {
	
	
	$("#product").jqxExpander({ toggleMode: 'none', width: '300px', showArrow: false });
	$('#saveButton').jqxButton({ width: 60, height: 25 });
	$('#cancelButton').jqxButton({ width: 60, height: 25 });
	
	$('#saveButton').on('click', function () {
        $('#productForm').jqxValidator('validate');
    });
	
	// initialize validator.
	$('#productForm').jqxValidator({
        rules: [
               { input: '#name', message: 'Product Name is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#type', message: 'Product Type is required!', action: 'keyup, blur', rule: 'required' }]
	});
	
	var source = [
                  "GAS",
                  "OTHERS"
                  ];
    	// Create a jqxDropDownList
    	$("#productTypeList").jqxDropDownList({ source: source, selectedIndex: 1, width: '100', height: '25'});
	
	
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	
    /*var theme = 'classic';
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
	});*/

});