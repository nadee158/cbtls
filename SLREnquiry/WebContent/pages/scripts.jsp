<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.custom.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery_ui.css"/>

<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.printElement.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-1.4-noConflictRP.js" type="text/javascript"></script> --%>


<%-- <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery_ui.css"/>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.8.2.custom.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery_tablesorter_min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery_tablesorter_pager.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.printElement.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui-custom.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-1.4-noConflictRP.js" type="text/javascript"></script> --%>



<script>

$( document ).ready(function() {

    $(".tittle-help-icon").click(function () {
        var time = new Date().getTime();
        //$("#help-content").load("("../help/index.action?time=" + time);
        $("#help-content").load("help-content");
		$("#help-content").addClass("help-content-wrapper");
        $("#help-content").dialog('open');
    });
    $("#help-content").dialog({
        autoOpen: false,
        width: 'auto', // overcomes width:'auto' and maxWidth bug
        height: 300,
        maxWidth: 600,
        modal: true,
        fluid: true, //new option
        resizable: false,
		resizable: false,
		position: ['left','top'],
        open: function(event, ui){ 
            fluidDialog(); // needed when autoOpen is set to true in this codepen
        }
    });               
});

// run function on all dialog opens
$(document).on("dialogopen", ".ui-dialog", function (event, ui) {
    fluidDialog();
});

// remove window resize namespace
$(document).on("dialogclose", ".ui-dialog", function (event, ui) {
    $(window).off("resize.responsive");
});

function fluidDialog() {
    var $visible = $(".ui-dialog:visible");
    // each open dialog
    $visible.each(function () {
        var $this = $(this);
        var dialog = $this.find(".ui-dialog-content").data("dialog");
        // if fluid option == true
        if (dialog.options.maxWidth && dialog.options.width) {
            // fix maxWidth bug
            $this.css("max-width", dialog.options.maxWidth);
            //reposition dialog
            dialog.option("position", dialog.options.position);
        }

        if (dialog.options.fluid) {
            // namespace window resize
            $(window).on("resize.responsive", function () {
                var wWidth = $(window).width();
                // check window width against dialog width
                if (wWidth < dialog.options.maxWidth + 50) {
                    // keep dialog from filling entire screen
                    $this.css("width", "90%");
                    
                }
                //reposition dialog
                dialog.option("position", dialog.options.position);
            });
        }

    });
}

</script>