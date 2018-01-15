function sendForNewFight() {
    $.post("/fight",function (fight) {
        handleFightState(fight)
    })
}


function handleFightState(fight) {
    var mage = fight.mage;
    var opponent = fight.opponent;
    var log = fight.log;
    var abilities = mage.abilities;

    fillMage(mage);
    fillOpponent(opponent);
    addToPageLog(log);
    displayAbilities(abilities,mage);
    checkIfFightFinished(opponent, mage);

}

function fillMage(mage) {
    $("#mage-name").text(mage.name);
    $("#mage-level").text(mage.level);
    $("#mage-hp").text(mage.healthPoints);
    $("#hp-potions").text(mage.equipment.potions.healthPotions);
    $("#mana-potions").text(mage.equipment.potions.manaPotions);
    $("#mage-mana").text(mage.magicalAbilities.manaPoints);
    $("#mage-accuracy").text(mage.accuracy);
    $("#mage-agility").text(mage.agility);
    $("#mage-strength").text(mage.strength);
    $("#mage-concentration").text(mage.magicalAbilities.concentration);
    $("#mage-condition").text(mage.condition);
    if(mage.equipment.weapon!=null){
        $("#mage-damage").text(mage.equipment.weapon.damage.minDamage+"-"+mage.equipment.weapon.damage.maxDamage);
    } else {
        $("#mage-damage").text(mage.noWeaponDamage.minDamage + "-" + mage.noWeaponDamage.maxDamage);
    }
}

function fillOpponent(opponent) {
    $("#opponent-name").text(opponent.name);
    $("#opponent-level").text(opponent.level);
    $("#opponent-hp").text(opponent.healthPoints);
    $("#opponent-accuracy").text(opponent.accuracy);
    $("#opponent-agility").text(opponent.agility);
    $("#opponent-strength").text(opponent.strength);
    $("#opponent-condition").text(opponent.condition);
    if(opponent.equipment!=null&&opponent.equipment.weapon!=null){
        $("#opponent-damage").text(opponent.equipment.weapon.damage.minDamage+"-"+opponent.equipment.weapon.damage.maxDamage);
    } else {
        $("#opponent-damage").text(opponent.noWeaponDamage.minDamage+"-"+opponent.noWeaponDamage.maxDamage);
    }

}
function addToPageLog(log) {
    $("#innerLogDiv").remove();

    var innerLogDiv = document.createElement("div");
    innerLogDiv.setAttribute("id","innerLogDiv");

    log.forEach(function (log) {
        var p = document.createElement("p");
        p.innerHTML = log;
        innerLogDiv.append(p);
    });
    $("#log").append(innerLogDiv);
}

function displayAbilities(abilities, mage) {
    $("#innerDiv").remove();

    var innerAbilitiesDiv = document.createElement("div");
    innerAbilitiesDiv.setAttribute("id","innerDiv");

    abilities.forEach(function (ability) {
        if(ability.name=="Drink Health Potion"&&mage.equipment.potions.healthPotions==0){

        } else if(ability.name=="Drink Mana Potion"&&mage.equipment.potions.manaPotions==0){

        } else {
            var p = document.createElement("p");
            var description = document.createElement("span");
            var cost = document.createElement("span");
            var notEnoughMana = document.createElement("span");
            var button = document.createElement("button");

            button.innerHTML = ability.name;
            description.innerHTML = ability.description;
            cost.innerHTML = "Mana cost: " + ability.cost + " | ";
            notEnoughMana.innerHTML = "(not Enough mana) | " + ability.name + " | ";
            notEnoughMana.style.backgroundColor = "cornflowerblue";
            button.setAttribute("onclick", "send('" + ability.name + "');");

            if (ability.cost <= mage.magicalAbilities.manaPoints) {
                p.append(button);
            } else {
                p.append(notEnoughMana);
            }
            p.append(cost);
            p.append(description);
            innerAbilitiesDiv.append(p);
        }

});
    $("#abilities").append(innerAbilitiesDiv);
}

function checkIfFightFinished(opponent, mage) {
    if (opponent.healthPoints <= 0 || mage.healthPoints <= 0) {
        $("#finish").show();
        $("#abilities").hide();
    }
}

function send(abilityName) {
    $.post("/fight/next-turn",{"abilityName":abilityName},function (fight) {
        handleFightState(fight)
    })
}




$(function () {
    sendForNewFight();
});


// Promisy
// Constant i let
// Arrow function
// innerHtml
// === in place of ==
