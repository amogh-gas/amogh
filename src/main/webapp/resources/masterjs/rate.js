$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	/******** Retrieve Code over ******/
	var rateGridSource =
	{		
			contentType : 'application/json',
			datatype: "json",
			datafields: [
			             	{ name: 'id' },
							{ name: 'name' },
							{ name: 'custId' },
							{ name: 'prodId' },
							{ name: 'ratePerNo' },
							{ name: 'ratePerLtr' },
							{ name: 'ratePerCubMtr' },
							{ name: 'ratePerKg' },
							{ name: 'exciseRate' },
							{ name: 'cessExcise' },
							{ name: 'eduCess' },
							{ name: 'frieght' },
							{ name: 'loadingChrgs' },
							{ name: 'unloadingChrgs' },
							{ name: 'withoutExcise' },
							{ name: 'srvcTaxFlag' },
							{ name: 'srvcTax' },
							{ name: 'supplementryInvoice' },
							{ name: 'vat' },
							{ name: 'cstWithCForm' },
							{ name: 'cstWithoutCForm' }
			             ],
			             id: 'id',
			             type: "POST",
			             url: './rate/getRates',
			             root: 'rows',
			             beforeSend: function(req) {
			            	 req.setRequestHeader(header, token);
			             },
			             beforeprocessing: function (data) {
			            	 rateGridSource.totalrecords = data.result.totalRows;
			             },       
	};

	var rateGridDataAdapter = new $.jqx.dataAdapter(rateGridSource,
			{
		formatData: function (data) {
			return JSON.stringify(data);
		}
			}
	);

	//Initialise jqxGrid
	$("#rateDetails").jqxGrid(
			{    
				width: '99.5%',
				selectionmode: 'rowselect',
				source: rateGridDataAdapter,
				theme: CONSTANT.THEME,
				editable: false,
				autorowheight: true,
				autoheight: true,
				pageable: true,
				virtualmode: true,
				rendergridrows: function () {
					return rateGridDataAdapter.records;
				},
				columns: 
					[
			          { text: 'id', editable: false, datafield: 'id', hidden: true },
			          {text:'RATE_NAME',datafield:'name',width:"15%"},
			          {text:'CUST_NAME',datafield:'custId',width:"20%"},
			          {text:'PROD_NAME',datafield:'prodId',width:"10%"},
			          {text:'RATE_PER_NO',datafield:'ratePerNo',width:"10%"},
			          {text:'RATE_PER_LTR',datafield:'ratePerLtr',width:"15%"},
			          {text:'RATE_PER_CUB_MTR',datafield:'ratePerCubMtr',width:"10%"},
			          {text:'RATE_PER_KG',datafield:'ratePerKg',width:"10%"},
			          {text:'EXCISE_RATE',datafield:'exciseRate',width:"10%"},
			          {text:'CESS_EXCISE',datafield:'cessExcise',width:"15%"},
			          {text:'EDU_CESS',datafield:'eduCess',width:"15%"},
			          {text:'FRIEGHT',datafield:'frieght',width:"7%"},
			          {text:'LOADING_CHRGS',datafield:'loadingChrgs',width:"7%"},
			          {text:'UNLOADING_CHRGS',datafield:'unloadingChrgs',width:"8%"},
			          {text:'WITHOUT_EXCISE',datafield:'withoutExcise',width:"7%"},
			          {text:'SRVC_TAX_FLAG',datafield:'srvcTaxFlag',width:"8%"},
			          {text:'SRVC_TAX',datafield:'srvcTax',width:"10%"},
			          {text:'SUPPLEMENTRY_INVOIC',datafield:'supplementryInvoice',width:"10%"},
			          {text:'VAT',datafield:'vat',width:"10%"},
			          {text:'CST_WITH_CFORM',datafield:'cstWithCForm',width:"5%"},
			          {text:'CST_WITHOUT_CFORM',datafield:'cstWithoutCForm',width:"5%"},
			          { text: ' ', datafield: 'Edit', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "Edit";
			            }, buttonclick: function (row) {
			            	var data = $('#rateDetails').jqxGrid('getrowdata', row);				            	
			            	$('#saveType').val(CONSTANT.UPDATE);
			            	for(var type in data) {
			            		console.log(type);
			            		if( $('#rateWindow #'+type).length )         // use this if you are using id to check
			            		{
			            			$('#rateWindow #'+type).val(data[type]);
			            		}
			            	}

	            			$('#rateWindow').jqxWindow('open');
			            }
			          },
			          { text: ' ', datafield: 'Remove', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "X";
			            }, buttonclick: function (row) {
			            	var data = $('#rateDetails').jqxGrid('getrowdata', row);
			            	
			            	if(confirm("Do you want to remove? \n\n"+ data.name +"!")) {
			            		$('#saveType').val(CONSTANT.REMOVE);
			            		$('#id').val(data.id);
			            		$('#name').val(data.name);
			            		saveRate();
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
	var saveRate = function() {
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
			url: './rate/addRate',
			data: JSON.stringify(dataPersist),
			success: function (data, status, xhr) {
				if(data.status == 'SUCCESS') {
					$('#rateDetails').jqxGrid('updatebounddata');
					if(data.result.saveType == CONSTANT.UPDATE) {
						$('#rateWindow').jqxWindow('close');
					}
					alert('\' ' + name.toUpperCase() + ' \' ' + actionType );
					rateReset();
				} else {
					alert('\' ' + name.toUpperCase() + ' \' Not Added.');
				}
			}
		});
	};
	$('#saveButton').click(function(pEvent){
		$('#rateWindow').jqxValidator('validate');
	});
	
	var rateReset = (function() {
		$('.rateReset').each(function(pEvent){
			$('#'+this.id).val('');
		});
	});
	
	/***** Save the Rate ****/
	
	var customButtonsDemo = (function () {
        var _collapsed = false;
        function _addEventListeners() {
            $('#showWindowButton').mousedown(function () {
                $('#rateWindow').jqxWindow('open');
                rateReset();
                $('#saveType').val(CONSTANT.SAVE);
            });
            $('#hideWindowButton').mousedown(function () {
                $('#rateWindow').jqxWindow('close');
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
            $('#rateWindow').jqxWindow({  showCollapseButton: true,theme:CONSTANT.THEME,width: '40%',
                height: '50%', resizable: true, autoOpen: false, isModal: true, 
                cancelButton: $('#cancelButton'),
                initContent: function () {
                    $('#saveButton').jqxButton({ width: '80px', disabled: true });
                    $('#cancelButton').jqxButton({ width: '80px', disabled: false });                    
                }
            });
        };
        $('#rateWindow').on('close', function(){
        	//close all error display
            $('.jqx-validator-hint').click();
        });
        return {
            init: function () {
                _createElements();
                _addEventListeners();
                $("#rateWindow").css('visibility', 'visible');
                $("#rateMenu").css('visibility', 'visible');
                
            }
        };
    } ());
    $(document).ready(function () {
        customButtonsDemo.init();
    });
    
    
    /***** Drop Down list for Product*****/
    // prepare the data
	var productSource =
	{
		datatype: "json",
		datafields: [
		{ name: 'id'},
		{ name: 'name'},
		],
		url: './product/getAllProducts',
		beforeSend: function(req) { 
			req.setRequestHeader(header, token);
		},
		type: "POST",
		async: false
	};
	var productDataAdapter = new $.jqx.dataAdapter(productSource);
	// Create a jqxDropDownList
	$("#rateWindow #prodId").jqxDropDownList({ theme:CONSTANT.THEME,source: productDataAdapter, selectedIndex: 0, dropDownHeight:80, dropDownHorizontalAlignment:'left', width: '127px', height: '18px',displayMember: 'name',
		valueMember: 'id'});
	
	$('#rateWindow #prodId .jqx-dropdownlist-content').each(function(){
		$(this).children().attr("name",$(this).attr('id')).attr("id",$(this).attr('id'));
	});
	/***** End Drop Down list for product Type*****/
	
	/***** Drop Down list for Customer*****/
    // prepare the data
	var customerSource =
	{
		datatype: "json",
		datafields: [
		{ name: 'id'},
		{ name: 'name'},
		],
		url: './customer/getAllCustomers',
		beforeSend: function(req) { 
			req.setRequestHeader(header, token);
		},
		type: "POST",
		async: false
	};
	var customerDataAdapter = new $.jqx.dataAdapter(customerSource);
	// Create a jqxDropDownList
	$("#rateWindow #custId").jqxDropDownList({ theme:CONSTANT.THEME,source: customerDataAdapter, selectedIndex: 0, dropDownHeight:80, dropDownHorizontalAlignment:'left', width: '127px', height: '18px',displayMember: 'name',
		valueMember: 'id'});
	
	$('#rateWindow #custId .jqx-dropdownlist-content').each(function(){
		$(this).children().attr("name",$(this).attr('id')).attr("id",$(this).attr('id'));
	});
	/***** End Drop Down list for product Type*****/
    
    /*****Start:Rate window validation settings******/
	var vParams = {};
	vParams.content = 'rateWindow';
	var newWoFns = function() {};
	$.CommonComponent.Validation(vParams, new newWoFns());
	$('#rateWindow').on('validationSuccess', function (event) {
		saveRate();
	});
	$('#rateWindow').on('validationError', function (event) {
		$("#wrongNotification").jqxNotification("open");
	});

	/*****End:Product window validation settings******/
});