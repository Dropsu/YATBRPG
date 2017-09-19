/**
 * Created by Damian on 16.09.2017.
 */
$(function () {
   $("#register").click(function () {
       if($("#password").val()===$("#repeated-password").val()){
           $.post("/account/register",{"username":$("#username").val(),"password":$("#password").val()},function (message) {
               $("#registration-message").text(message);
           })
       } else {
           $("#registration-message").text("Passwords are not identical");
       }

   })
});
