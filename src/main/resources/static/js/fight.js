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
    $("#mage-mana").text(mage.manaPoints);
    $("#mage-accuracy").text(mage.accuracy);
    $("#mage-agility").text(mage.agility);
    $("#mage-strength").text(mage.strength);
    $("#mage-concentration").text(mage.concentration);
    $("#mage-condition").text(mage.condition)
}

function fillOpponent(opponent) {
    $("#opponent-name").text(opponent.name);
    $("#opponent-hp").text(opponent.healthPoints);
    $("#opponent-accuracy").text(opponent.accuracy);
    $("#opponent-agility").text(opponent.agility);
    $("#opponent-strength").text(opponent.strength);
    $("#opponent-condition").text(opponent.condition);
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

        } else
        if(ability.cost<=mage.manaPoints) {
            var p = document.createElement("p");
            var description  = document.createElement("span");
            var button = document.createElement("button");

            button.innerHTML = ability.name;
            description.innerHTML = ability.description;
            button.setAttribute("onclick", "send('" + ability.name + "');");

            p.append(button);
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
