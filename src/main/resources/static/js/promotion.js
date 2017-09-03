var stompClient = null;

function connect() {
    var socket = new SockJS('/yatbrpg-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/notifications', function (greeting) {
            showGreeting(JSON.parse(greeting.body).message);
        });
    });
}

function sendForStats() {
    stompClient.send("/app/send-promotion-data",{},JSON.stringify({'message': $("#name").val()}));
}

$( document ).ready(function() {
   connect();
});

$( "#send" ).click(function() {
   sendForStats();
});

