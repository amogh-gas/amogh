$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	/******** Retrieve Code over ******/
	var source =
	{		
			contentType : 'application/json',
			datatype: "json",
			datafields: [
			             	{ name: 'id' },
							{ name: 'name' },
							{ name: 'address' },
							{ name: 'area' },
							{ name: 'state' },
							{ name: 'email' },
							{ name: 'phone' },
							{ name: 'priMobile' },
							{ name: 'secMobile' },
							{ name: 'contactPerson1' },
							{ name: 'contactPerson2' },
							{ name: 'tinNum' },
							{ name: 'cstNum' },
							{ name: 'panNum' },
							{ name: 'eCCNum' },
							{ name: 'holdingAdvice' },
							{ name: 'creditDays' },
							{ name: 'maxCylinder' },
							{ name: 'minCylinder' },
							{ name: 'second' }
			             ],
			             id: 'id',
			             type: "POST",
			             url: './customer/getCustomers',
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
	$("#customerDetails").jqxGrid(
			{    
				width: '99.5%',
				selectionmode: 'rowselect',
				source: dataadapter,
				theme: CONSTANT.THEME,
				editable: false,
				autoheight: true,
				pageable: true,
				virtualmode: true,
				rendergridrows: function () {
					return dataadapter.records;
				},
				columns: 
					[
			          { text: 'id', editable: false, datafield: 'id', hidden: true },
			          {text:'CUST_NAME',datafield:'name',width:"25%"},
			          {text:'ADDR',datafield:'address',width:"25%"},
			          {text:'AREA',datafield:'area',width:"25%"},
			          {text:'STATE',datafield:'state',width:"25%"},
			          {text:'EMAIL',datafield:'email',width:"25%"},
			          {text:'PHONE',datafield:'phone',width:"25%"},
			          {text:'PRI_MOBILE',datafield:'priMobile',width:"25%"},
			          {text:'SEC_MOBILE',datafield:'secMobile',width:"25%"},
			          {text:'CONTACT_PERSON1',datafield:'contactPerson1',width:"25%"},
			          {text:'CONTACT_PERSON2',datafield:'contactPerson2',width:"25%"},
			          {text:'TIN_NUM',datafield:'tinNum',width:"25%"},
			          {text:'CST_NUM',datafield:'cstNum',width:"25%"},
			          {text:'PAN_NUM',datafield:'panNum',width:"25%"},
			          {text:'ECC_NUM',datafield:'eCCNum',width:"25%"},
			          {text:'HOLDING_ADVICE',datafield:'holdingAdvice',width:"25%"},
			          {text:'CREDIT_DAYS',datafield:'creditDays',width:"25%"},
			          {text:'MAX_CYLINDER',datafield:'maxCylinder',width:"25%"},
			          {text:'MIN_CYLINDER',datafield:'minCylinder',width:"25%"},
			          {text:'SECOND',datafield:'second',width:"25%"},
			          { text: ' ', datafield: 'Edit', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "Edit";
			            }, buttonclick: function (row) {
			            	var data = $('#customerDetails').jqxGrid('getrowdata', row);				            	
			            	$('#saveType').val(CONSTANT.UPDATE);
			            	for(var type in data) {
			            		console.log(type);
			            		if( $('#customerWindow #'+type).length )         // use this if you are using id to check
			            		{
			            			$('#customerWindow #'+type).val(data[type]);
			            		}
			            	}

	            			$('#customerWindow').jqxWindow('open');
			            }
			          },
			          { text: ' ', datafield: 'Remove', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "X";
			            }, buttonclick: function (row) {
			            	var data = $('#customerDetails').jqxGrid('getrowdata', row);
			            	
			            	if(confirm("Do you want to remove? \n\n"+ data.name +"!")) {
			            		$('#saveType').val(CONSTANT.REMOVE);
			            		$('#id').val(data.id);
			            		$('#name').val(data.name);
			            		saveCustomer();
			            	}
			            }
			          },
				    ]
			});

	var nullCheck = function(id) {
		return $('#'+id).val() != null && $('#'+id).val() != '';
	};
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	/***** Save the Product ****/
	var saveCustomer = function() {
		var dataPersist = $.CommonComponent.serializeObject("customWindowContent");
		var name = dataPersist.name;
		var actionType = 'Updated.';
		
		if($('#saveType').val() == CONSTANT.SAVE) {
			delete dataPersist.id;
			actionType = 'Added.';
		} else if($('#saveType').val() == CONSTANT.REMOVE) {
			actionType = 'Removed.';
		}
		console.log(JSON.stringify(dataPersist));
		$.ajax({
			contentType : 'application/json',
			dataType: 'json',
			beforeSend: function(req) { 
				req.setRequestHeader(header, token);
			},
			type: "POST",
			url: './customer/addCustomer',
			data: JSON.stringify(dataPersist),
			success: function (data, status, xhr) {
				if(data.status == 'SUCCESS') {
					$('#customerDetails').jqxGrid('updatebounddata');
					if(data.result.saveType == CONSTANT.UPDATE) {
						$('#customerWindow').jqxWindow('close');
					}
					alert('\' ' + name.toUpperCase() + ' \' ' + actionType );
					customerReset();
				} else {
					alert('\' ' + name.toUpperCase() + ' \' Not Added.');
				}
			}
		});
	};
	$('#saveButton').click(function(pEvent){
		$('#customerWindow').jqxValidator('validate');
	});
	
	var customerReset = (function() {
		$('.customerReset').each(function(pEvent){
			$('#'+this.id).val('');
		});
	});
	
	/***** Save the Customer ****/
	
	var customButtonsDemo = (function () {
        var _collapsed = false;
        function _addEventListeners() {
            $('#showWindowButton').mousedown(function () {
                $('#customerWindow').jqxWindow('open');
                customerReset();
                $('#saveType').val(CONSTANT.SAVE);
            });
            $('#hideWindowButton').mousedown(function () {
                $('#customerWindow').jqxWindow('close');
            });
            _addSearchInputEventHandlers();
        };

        function _addSearchInputEventHandlers() {
            $('#name').keydown(function () {
                _searchButtonHandle();
            });
            $('#name').change(function () {
                _searchButtonHandle();
            });
            $('#name').keyup(function () {
                _searchButtonHandle();
            });
            $(document).mousemove(function () {
                _searchButtonHandle();
            });
        };
        function _searchButtonHandle() {
            if ($('#saveButton').length > 0) {
                if ($('#name').val() !== '') {
                    $('#saveButton').jqxButton('disabled', false);
                } else {
                    $('#saveButton').jqxButton('disabled', true);
                }
                $('#cancelButton').jqxButton('disabled', false);
            }
        };
        function _createElements() {
            $('#showWindowButton').jqxButton({ width: '80px',theme:CONSTANT.THEME});
            $('#customerWindow').jqxWindow({  showCollapseButton: true,theme:CONSTANT.THEME,width: '50%',
                height: '55%', resizable: true, autoOpen: false, isModal: true, 
                cancelButton: $('#cancelButton'),
                initContent: function () {
                    $('#saveButton').jqxButton({ width: '80px', disabled: true });
                    $('#cancelButton').jqxButton({ width: '80px', disabled: false });                    
                }
            });
        };
        $('#customerWindow').on('close', function(){
            $('.jqx-validator-hint').remove();
        });
        return {
            init: function () {
                _createElements();
                _addEventListeners();
                $("#customerWindow").css('visibility', 'visible');
                $("#customerMenu").css('visibility', 'visible');
                
            }
        };
    } ());
    $(document).ready(function () {
        customButtonsDemo.init();
    });
    
    /*****Start:Customer window validation settings******/
	var vParams = {};
	vParams.content = 'customerWindow';
	var newWoFns = function() {};
	$.CommonComponent.Validation(vParams, new newWoFns());
	$('#customerWindow').on('validationSuccess', function (event) {
		saveCustomer();
	});
	$('#customerWindow').on('validationError', function (event) {
		$("#wrongNotification").jqxNotification("open");
	});

	/*****End:Product window validation settings******/
});