$(document).ready(function() {
	// Include CSRF token as header in JQuery AJAX requests
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	/******** Retrieve Code over ******/
	var theme = 'classic';
	var source =
	{		
			contentType : 'application/json',
			datatype: "json",
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
	$("#productDetails").jqxGrid(
			{    
				width: '99.5%',
				selectionmode: 'rowselect',
				source: dataadapter,
				theme: theme,
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
			          { text: 'PROD NAME', datafield: 'name', width: "25%" },
			          { text: 'PROD TYPE', datafield: 'typeId', width: "15%" },
			          { text: 'PORDUCT DESC', datafield: 'desc', width: "15%" },
			          { text: 'SHORT DESC', datafield: 'shortDesc', width: "14%" },
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
			            	$('#saveType').val(CONSTANT.REMOVE);
			            	$('#id').val(data.id);
			            	$('#name').val(data.name);
			            	saveProduct();
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
	var theme = 'classic';

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
            _addCustomButtonsHandlers();
            _addSearchInputEventHandlers();
        };
        function _addCustomButtonsHandlers() {
            $('#pinButton').mousedown(function () {
                if ($('#customWindow').jqxWindow('draggable')) {
                    $('#customWindow').jqxWindow('draggable', false);
                } else {
                    $('#customWindow').jqxWindow('draggable', true);
                }
            });
            $('#collapseWindowButton').mousedown(function () {
                $('#customWindow').jqxWindow('collapse');
            });
            $('#expandWindowButton').mousedown(function () {
                $('#customWindow').jqxWindow('expand');
            });
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
            $('#showWindowButton').jqxButton({ width: '80px'});
            $('#hideWindowButton').jqxButton({ width: '80px' });
            $('#collapseWindowButton').jqxButton({ width: '80px' });
            $('#expandWindowButton').jqxButton({ width: '80px' });
            $('#customWindow').jqxWindow({  width: 360,
                height: 250, resizable: true, autoOpen: false, isModal: true, 
                cancelButton: $('#cancelButton'),
                initContent: function () {
                    $('#saveButton').jqxButton({ width: '80px', disabled: true });
                    $('#cancelButton').jqxButton({ width: '80px', disabled: false });                    
                }
            });
        };
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
    var productTypeDropDownList = [
	                               "1",
	                               "2"
	                               ];
	// Create a jqxDropDownList
	$("#customWindow #type").jqxDropDownList({ source: productTypeDropDownList, selectedIndex: 0, dropDownHeight:50, dropDownHorizontalAlignment:'left', width: '145', height: '16'});
	
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
		alert('Fill required details.');
	});

	/*****End:Product window validation settings******/
});