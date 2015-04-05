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
							{ name: 'name' }/*,
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
							{ name: 'second' }*/
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
			          /*{text:'ADDR',datafield:'address',width:"20%"},
			          {text:'AREA',datafield:'area',width:"10%"},
			          {text:'STATE',datafield:'state',width:"10%"},
			          {text:'EMAIL',datafield:'email',width:"15%"},
			          {text:'PHONE',datafield:'phone',width:"10%"},
			          {text:'PRI_MOBILE',datafield:'priMobile',width:"10%"},
			          {text:'SEC_MOBILE',datafield:'secMobile',width:"10%"},
			          {text:'CONTACT_PERSON 1',datafield:'contactPerson1',width:"15%"},
			          {text:'CONTACT_PERSON 2',datafield:'contactPerson2',width:"15%"},
			          {text:'TIN_NUM',datafield:'tinNum',width:"7%"},
			          {text:'CST_NUM',datafield:'cstNum',width:"7%"},
			          {text:'PAN_NUM',datafield:'panNum',width:"8%"},
			          {text:'ECC_NUM',datafield:'eCCNum',width:"7%"},
			          {text:'HOLDING_ADVICE',datafield:'holdingAdvice',width:"8%"},
			          {text:'CREDIT_DAYS',datafield:'creditDays',width:"10%"},
			          {text:'MAX_CYLINDER',datafield:'maxCylinder',width:"10%"},
			          {text:'MIN_CYLINDER',datafield:'minCylinder',width:"10%"},
			          {text:'SECOND',datafield:'second',width:"5%"},*/
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