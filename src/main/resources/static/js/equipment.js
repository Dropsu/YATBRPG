/**
 * Created by Damian on 13.09.2017.
 */

function sendForItems() {
    $.post("/equipment",function (equipment) {
        fillItems(equipment)
        fillPotions(equipment.potions);
    });

    $.post("/equipment/shop",function (shopItems) {
        fillShop(shopItems);
    });
}

function fillShop(shopItems) {

    shopItems.weapons.forEach(function (weapon) {
        var button = document.createElement("button");
        button.innerHTML = weapon.name;
        button.setAttribute("onclick", "buy('" + weapon.name + "','weapon');");
        $("#weapons").append(button);
    });
    shopItems.armors.forEach(function (armor) {
        var button = document.createElement("button");
        button.innerHTML = armor.name;
        button.setAttribute("onclick", "buy('" + armor.name + "','armor');");
        $("#armors").append(button);
    });
    shopItems.rings.forEach(function (ring) {
        var button = document.createElement("button");
        button.innerHTML = ring.name;
        button.setAttribute("onclick", "buy('" + ring.name + "','ring');");
        $("#rings").append(button);
    })

}





function sell(itemType) {
    $.post("/equipment/sell",{"itemType":itemType},function (equipment) {
        fillItems(equipment)
    })
}

function buy(itemName,itemType) {
    $.post("/equipment/buy",{"itemName":itemName,"itemType":itemType},function (equipment) {
        fillItems(equipment)
    })
}

function fillPotions(potions) {
    $("#hp-potions").text(potions.healthPotions);
    $("#hp-potion-cost").text(potions.healthPotionGoldValue);
    $("#mana-potions").text(potions.manaPotions);
    $("#mana-potion-cost").text(potions.manaPotionGoldValue);

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
        $("#lringval").text(equipment.leftHandRing.value);
    }
    if(equipment.rightHandRing!=null) {
        $("#rring").val(equipment.rightHandRing.name);
        $("#rringval").text(equipment.rightHandRing.value);
    }

}

function buyPotion(number, type) {
    $.post("/equipment/buyPotions",{"number":number,"type":type},function (equipment) {
        fillItems(equipment);
        fillPotions(equipment.potions);
    })
}

$(function () {
    sendForItems();
    $(".sell").click(function () {
        sell(this.name);
    })
    $("#buyHealthPotion").click(function () {
        var number = $("#hp-potions-number").val();
        buyPotion(number,this.name);
    })
    $("#buyManaPotion").click(function () {
        var number = $("#mana-potions-number").val();
        buyPotion(number,this.name);
    })
});



