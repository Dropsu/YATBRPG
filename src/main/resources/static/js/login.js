/**
 * Created by Damian on 16.09.2017.
 */
$(function () {
   $("#register").click(function () {
       $.post("/account/register",{"username":$("#username").val(),"password":$("#password").val()},function (message) {
           $("#registration-message").text(message);
       })
   })
});
