
$(function () {
    $( "#addStr" ).click(function() {
        if(parseInt($("#points").text())>0){
            if(parseInt($("#points").text())==1){
                $("#confirm").show();
            }
            $("#strength").val(function (i,oldVal) {
                return parseInt(oldVal)+1;
            });
            $("#points").text(function (i,oldVal) {
                return parseInt(oldVal)-1;
            });
        }

    });
    $( "#addCond" ).click(function() {
        if(parseInt($("#points").text())>0){
            if(parseInt($("#points").text())==1){
                $("#confirm").show();
            }
            $("#condition").val(function (i,oldVal) {
                return parseInt(oldVal)+1;
            });
            $("#points").text(function (i,oldVal) {
                return parseInt(oldVal)-1;
            });
        }

    });
    $( "#addConc" ).click(function() {
        if(parseInt($("#points").text())>0){
            if(parseInt($("#points").text())==1){
                $("#confirm").show();
            }
            $("#concentration").val(function (i,oldVal) {
                return parseInt(oldVal)+1;
            });
            $("#points").text(function (i,oldVal) {
                return parseInt(oldVal)-1;
            });
        }

    });
    $( "#addAgi" ).click(function() {
        if(parseInt($("#points").text())>0){
            if(parseInt($("#points").text())==1){
                $("#confirm").show();
            }
            $("#agility").val(function (i,oldVal) {
                return parseInt(oldVal)+1;
            });
            $("#points").text(function (i,oldVal) {
                return parseInt(oldVal)-1;
            });
        }
    });
    $( "#addAcc" ).click(function() {
        if(parseInt($("#points").text())>0){
            if(parseInt($("#points").text())==1){
                $("#confirm").show();
            }
            $("#accuracy").val(function (i,oldVal) {
                return parseInt(oldVal)+1;
            });
            $("#points").text(function (i,oldVal) {
                return parseInt(oldVal)-1;
            });
        }

    });

    $("#reset").click(function () {
        location.reload();
    });

    $('#strength_span').hover(
        function () {
            $('#s_des').show();
        },
        function () {
            $('#s_des').hide();
        }
    );
    $('#agi_span').hover(
        function () {
            $('#a_des').show();
        },
        function () {
            $('#a_des').hide();
        }
    );
    $('#acc_span').hover(
        function () {
            $('#a_des').show();
        },
        function () {
            $('#a_des').hide();
        }
    );
    $('#conc_span').hover(
        function () {
            $('#conc_des').show();
        },
        function () {
            $('#conc_des').hide();
        }
    );
    $('#cond_span').hover(
        function () {
            $('#cond_des').show();
        },
        function () {
            $('#cond_des').hide();
        }
    );

});