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
        var p = document.createElement("p");
        var itemName = document.createElement("span");
        var itemCost = document.createElement("span");
        var button = document.createElement("button");
        var damage = document.createElement("span");
        var description = document.createElement("span");
        button.innerHTML = "Buy";
        itemName.innerHTML=weapon.name;
        itemCost.innerHTML="Price: "+weapon.value;
        damage.innerHTML="  Damage:"+weapon.damage.minDamage+"-"+weapon.damage.maxDamage;
        description.innerHTML="     "+weapon.description;
        button.setAttribute("onclick", "buy('" + weapon.name + "','weapon');");
        p.append(itemName);
        p.append(damage);
        p.append(button);
        p.append(itemCost);
        p.append(description);
        $("#weapons").append(p);
    });
    shopItems.armors.forEach(function (armor) {
        var p = document.createElement("p");
        var itemName = document.createElement("span");
        var itemCost = document.createElement("span");
        var damageReduction = document.createElement("span");
        var button = document.createElement("button");
        var description = document.createElement("description");

        button.innerHTML = "Buy";
        itemName.innerHTML=armor.name;
        itemCost.innerHTML="Price: "+armor.value;
        damageReduction.innerHTML=" Damage Reduction: "+armor.damageReduction;
        description.innerHTML="     "+armor.description;
        button.setAttribute("onclick", "buy('" + armor.name + "','armor');");
        p.append(itemName);
        p.append(damageReduction);
        p.append(button);
        p.append(itemCost);
        p.append(description);
        $("#armors").append(p);
    });
    shopItems.rings.forEach(function (ring) {
        var p = document.createElement("p");
        var itemName = document.createElement("span");
        var itemCost = document.createElement("span");
        var button = document.createElement("button");
        var description = document.createElement("description");
        var button = document.createElement("button");

        button.innerHTML = "Buy";
        itemName.innerHTML=ring.name;
        itemCost.innerHTML="Price: "+ring.value;
        description.innerHTML="     "+ring.description;
        button.setAttribute("onclick", "buy('" + ring.name + "','ring');");

        p.append(itemName);
        p.append(button);
        p.append(itemCost);
        p.append(description);

        $("#rings").append(p);
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
    $(".item").hide();
    $(".val").text("");
    $("#gold").text(equipment.gold);
    if(equipment.weapon!=null) {
        $("#weapon_p").show();
        $("#weapon").text(equipment.weapon.name);
        $("#damage").text(equipment.weapon.damage.minDamage+"-"+equipment.weapon.damage.maxDamage);
        $("#weaponval").text(equipment.weapon.value);
    }
    if(equipment.armor!=null) {
        $("#armor_p").show();
        $("#armor").text(equipment.armor.name);
        $("#damageReduction").text(equipment.armor.damageReduction);
        $("#armorval").text(equipment.armor.value);
    }
    if(equipment.leftHandRing!=null) {
        $("#lring_p").show();
        $("#lring").text(equipment.leftHandRing.name);
        $("#lringdesc").text(equipment.leftHandRing.description)
        $("#lringval").text(equipment.leftHandRing.value);
    }
    if(equipment.rightHandRing!=null) {
        $("#rring_p").show();
        $("#rring").text(equipment.rightHandRing.name);
        $("#rringdesc").text(equipment.rightHandRing.description)
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



