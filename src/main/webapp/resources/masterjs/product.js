$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	/******** Retrieve Code over ******/
	var productGridSource =
	{		
			contentType : 'application/json',
			datatype: "json",
			cache: false,
			datafields: [
			             { name: 'id' },
			             { name: 'name' },
			             { name: 'typeId' },
			             { name: 'desc' },
			             { name: 'shortDesc' },
			             { name: 'unit' },
			             { name: 'under' },
			             { name: 'tariffCode' }
			             ],
			             id: 'id',
			             type: "POST",
			             url: './product/getProducts',
			             root: 'rows',
			             beforeSend: function(req) {
			            	 req.setRequestHeader(header, token);
			             },
			             beforeprocessing: function (data) {
			            	 productGridSource.totalrecords = data.result.totalRows;
			             }       
	};

	var productGridDataAdapter = new $.jqx.dataAdapter(productGridSource,
			{
		formatData: function (data) {
			return JSON.stringify(data);
		}
			}
	);

	//Initialise jqxGrid
	$("#productDetails").jqxGrid(
			{    
				width: '99.5%',
				selectionmode: 'rowselect',
				source: productGridDataAdapter,
				theme: CONSTANT.THEME,
				autoheight: true,
				pageable: true,
				virtualmode: true,
				rendergridrows: function (params) {
					return params.data;
				},
				columns: 
					[
			          { text: 'id', editable: false, datafield: 'id', hidden: true },
			          { text: 'PROD NAME', datafield: 'name', width: "25%" },
			          { text: 'PROD TYPE', datafield: 'typeId', width: "13%" },
			          { text: 'PORDUCT DESC', datafield: 'desc', width: "13%" },
			          { text: 'SHORT DESC', datafield: 'shortDesc', width: "13%" },
			          { text: 'UNIT', datafield: 'unit', width: "8%" },
			          { text: 'UNDER', datafield: 'under', width: "8%" },
			          { text: 'TARIFF CODE', datafield: 'tariffCode', width: "10%" },
			          { text: ' ', datafield: 'Edit', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "Edit";
			            }, buttonclick: function (row) {
			            	// @param row index.
			            	var data = $('#productDetails').jqxGrid('getrowdata', row);				            	
			            	$('#saveType').val(CONSTANT.UPDATE);
			            	for(var type in data) {
			            		console.log(type);
			            		if( $('#customWindow #'+type).length )         // use this if you are using id to check
			            		{
			            			$('#customWindow #'+type).val(data[type]);
			            		}
			            	}

	            			$('#customWindow').jqxWindow('open');
			            }
			          },
			          { text: ' ', datafield: 'Remove', columntype: 'button', width: "5%", cellsrenderer: function () {
			                return "X";
			            }, buttonclick: function (row) {
			            	// @param row index.
			            	var data = $('#productDetails').jqxGrid('getrowdata', row);				            	
			            	
			            	if(confirm("Do you want to remove? \n\n"+ data.name +"!")) {
			            		$('#saveType').val(CONSTANT.REMOVE);
			            		$('#id').val(data.id);
			            		$('#name').val(data.name);
			            		saveProduct();
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
	/******** Retrieve Code over ******/
	
	/*$("#product").jqxExpander({ toggleMode: 'none', width: '300px', showArrow: false });
	$('#saveButton').jqxButton({ width: 60, height: 25 });
	$('#cancelButton').jqxButton({ width: 60, height: 25 });

	// initialize validator.
	$('#productForm').jqxValidator({
        rules: [
               { input: '#name', message: 'Product Name is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#type', message: 'Product Type is required!', action: 'keyup, blur', rule: 'required' }]
	});
*/
	/***** Save the Product ****/
	var saveProduct = function() {
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
			url: './product/addProduct',
			data: JSON.stringify(dataPersist),
			success: function (data, status, xhr) {
				if(data.status == 'SUCCESS') {
					productReset();
					$('#productDetails').jqxGrid('updatebounddata');
					if(data.result.saveType == CONSTANT.UPDATE) {
						$('#customWindow').jqxWindow('close');
					}
					alert('\' ' + name.toUpperCase() + ' \' ' + actionType );
				} else {
					alert('\' ' + name.toUpperCase() + ' \' Not Added.');
				}
			}
		});
	};
	$('#saveButton').click(function(pEvent){
		$('#customWindow').jqxValidator('validate');
	});
	
	var productReset = (function() {
		$('.productReset').each(function(pEvent){
			$('#'+this.id).val('');
		});
	});
	
	/***** Save the Product ****/
	
	var customButtonsDemo = (function () {
        var _collapsed = false;
        function _addEventListeners() {
            $('#showWindowButton').mousedown(function () {
                $('#customWindow').jqxWindow('open');
                productReset();
                $('#saveType').val(CONSTANT.SAVE);
            });
            $('#hideWindowButton').mousedown(function () {
                $('#customWindow').jqxWindow('close');
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
            $('#showWindowButton').jqxButton({ width: '60px',theme:CONSTANT.THEME});
            $('#customWindow').jqxWindow({  animationType: 'combined',showCollapseButton: true,theme:CONSTANT.THEME,width: '260px',
                height: '240px', resizable: true, autoOpen: false, isModal: true, 
                cancelButton: $('#cancelButton'),
                initContent: function () {
                    $('#saveButton').jqxButton({ width: '80px', disabled: true });
                    $('#cancelButton').jqxButton({ width: '80px', disabled: false });                    
                }
            });
        };
        $('#customWindow').on('close', function(){
        	//close all error displays
            $('.jqx-validator-hint').click();
        });
        return {
            init: function () {
                _createElements();
                _addEventListeners();
                $("#customWindow").css('visibility', 'visible');
                $("#productMenu").css('visibility', 'visible');
                
            }
        };
    } ());
    $(document).ready(function () {
        customButtonsDemo.init();
    });
    
    
    /***** Drop Down list for product Type*****/
    // prepare the data
	var menuSource =
	{
		datatype: "json",
		datafields: [
		{ name: 'id'},
		{ name: 'name'},
		{ name: 'desc'},
		],
		url: './productType/getAllProductTypes',
		beforeSend: function(req) { 
			req.setRequestHeader(header, token);
		},
		type: "POST",
		async: false
	};
	var menuDataAdapter = new $.jqx.dataAdapter(menuSource);
	// Create a jqxDropDownList
	$("#customWindow #typeId").jqxDropDownList({ theme:CONSTANT.THEME,source: menuDataAdapter, selectedIndex: 0, dropDownHeight:80, dropDownHorizontalAlignment:'left', width: '127px', height: '18px',displayMember: 'name',
		valueMember: 'id'});
	
	$('#customWindow .jqx-dropdownlist-content').each(function(){
		$(this).children().attr("name",$(this).attr('id')).attr("id",$(this).attr('id'));
	});
	/***** End Drop Down list for product Type*****/
	
	/*****Start:Product window validation settings******/
	var vParams = {};
	vParams.content = 'customWindow';
	var newWoFns = function() {};
	$.CommonComponent.Validation(vParams, new newWoFns());
	$('#customWindow').on('validationSuccess', function (event) {
		saveProduct();
	});
	$('#customWindow').on('validationError', function (event) {
		$("#wrongNotification").jqxNotification("open");
	});

	/*****End:Product window validation settings******/
});