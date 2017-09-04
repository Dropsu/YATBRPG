
$(function () {
    $( "#addStr" ).click(function() {
        if(parseInt($("#points").text())>0){
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
    })


});