var stompClient = null;


function connect() {
    var socket = new SockJS('/yatbrpg-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/notifications', function (fight) {
            handleFightState(fight);
        });
        sendForNewFight();
    });
}

function sendForNewFight() {
    stompClient.send("/app/fight-prepare", {}, "prepare");
}

function handleFightState(fight) {
    var fight = (JSON.parse(fight.body));
    var mage = fight.mage;
    var opponent = fight.opponent;
    var log = fight.log;
    var abilities = mage.abilities;

    fillMage(mage);
    fillOpponent(opponent);
    addToPageLog(log);
    displayAbilities(abilities);

}

function fillMage(mage) {
    $("#mage-name").text(mage.name);
    $("#mage-hp").text(mage.healthPoints);
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

function displayAbilities(abilities) {
    $("#innerDiv").remove();

    var innerAbilitiesDiv = document.createElement("div");
    innerAbilitiesDiv.setAttribute("id","innerDiv");

    abilities.forEach(function (ability) {
    var button = document.createElement("button");
    button.innerHTML = ability.name;
    button.setAttribute("onclick","send('"+ability.name+"');");
    innerAbilitiesDiv.append(button);
});
    $("#abilities").append(innerAbilitiesDiv);
}

function send(abilityName) {
    stompClient.send("/app/fight-ability", {}, abilityName);
}




$(function () {
   connect();
});
