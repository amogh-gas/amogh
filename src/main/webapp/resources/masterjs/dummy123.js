var customButtonsDemo = (function () {
            var _collapsed = false;
            function _addEventListeners() {
                $('#showWindowButton').mousedown(function () {
                    $('#customWindow').jqxWindow('open');
                });
                $('#hideWindowButton').mousedown(function () {
                    $('#customWindow').jqxWindow('close');
                });
                $('#pinWindowButton').mousedown(function () {
                    $('#customWindow').jqxWindow('draggable', false);
                });
                $('#unpinWindowButton').mousedown(function () {
                    $('#customWindow').jqxWindow('draggable', true);
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
                $('#searchTextInput').keydown(function () {
                    _searchButtonHandle();
                });
                $('#searchTextInput').change(function () {
                    _searchButtonHandle();
                });
                $('#searchTextInput').keyup(function () {
                    _searchButtonHandle();
                });
                $(document).mousemove(function () {
                    _searchButtonHandle();
                });
            };
            function _searchButtonHandle() {
                if ($('#searchTextButton').length > 0) {
                    if ($('#searchTextInput').val() !== '') {
                        $('#searchTextButton').jqxButton('disabled', false);
                    } else {
                        $('#searchTextButton').jqxButton('disabled', true);
                    }
                    $('#cancelButton').jqxButton('disabled', false);
                }
            };
            function _createElements() {
                $('#showWindowButton').jqxButton({ width: '80px'});
                $('#hideWindowButton').jqxButton({ width: '80px' });
                $('#pinWindowButton').jqxButton({ width: '80px' });
                $('#unpinWindowButton').jqxButton({ width: '80px' });
                $('#collapseWindowButton').jqxButton({ width: '80px' });
                $('#expandWindowButton').jqxButton({ width: '80px' });
                $('#customWindow').jqxWindow({  width: 400,
                    height: 110, resizable: false,
                    cancelButton: $('#cancelButton'),
                    initContent: function () {
                        $('#searchTextButton').jqxButton({ width: '80px', disabled: true });
                        $('#cancelButton').jqxButton({ width: '80px', disabled: false });
                        $('#matchCaseCheckBox').jqxCheckBox({ width: '150px' });
                    }
                });
            };
            return {
                init: function () {
                    _createElements();
                    _addEventListeners();
                }
            };
        } ());
        $(document).ready(function () {
            customButtonsDemo.init();
        });