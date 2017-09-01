package ds.messaging;

import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;

import java.security.Principal;

/**
 * Created by Damian on 19.08.2017.
 */

@Controller
public class MsgController {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(MsgController.class);

    @MessageMapping("/sayHi")
    public Message greetSentName(Message incoming) {
        LOGGER.info(incoming.getMessage());
        Message outgoing = new Message();
        outgoing.setMessage("HI "+incoming.getMessage());
        return outgoing;
    }

    @MessageMapping("/greetMe")
    @SendToUser("/queue/notifications")
    public Message greetLoggedInUser(Principal principal) {
        Message outgoing = new Message();
        outgoing.setMessage("HI "+principal.getName());
        return outgoing;
    }

}
