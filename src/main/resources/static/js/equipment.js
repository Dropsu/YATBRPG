/**
 * Created by Damian on 13.09.2017.
 */




function sendForItems() {
    $.post("/equipment",function (equipment) {
        fillItems(equipment)
    })
}

function sell(itemType) {
    $.post("/equipment/sell",{"itemType":itemType},function (equipment) {
        fillItems(equipment)
    })
}

function fillItems(equipment) {
    $(".input").val("");
    $(".val").text("");
    $("#gold").text(equipment.gold);
    if(equipment.weapon!=null) {
        $("#weapon").val(equipment.weapon.name);
        $("#weaponval").text(equipment.weapon.value);
    }
    if(equipment.armor!=null) {
        $("#armor").val(equipment.armor.name);
        $("#armorval").text(equipment.armor.value);
    }
    if(equipment.leftHandRing!=null) {
        $("#lring").val(equipment.leftHandRing.name);
        $("#lringval").val(equipment.leftHandRing.value);
    }
    if(equipment.rightHandRing!=null) {
        $("#rring").val(equipment.rightHandRing.name);
        $("#rringval").val(equipment.rightHandRing.value);
    }

}

$(function () {
    sendForItems();
    $(".sell").click(function () {
        sell(this.name);
    })
});



