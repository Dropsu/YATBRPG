var stompClient = null;

function connect() {
    var socket = new SockJS('/yatbrpg-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/notifications', function (greeting) {
            //addToLog(JSON.parse(greeting.body).message);
            location.reload();
        });
    });
}

function send(abilityName) {
    stompClient.send("/app/fight-ability", {}, abilityName);
}

/*function addToLog(message) {
    $("#log").append("<tr><td>" + message + "</td></tr>");
}*/


$(function () {
   connect();


});
