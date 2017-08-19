package ds.messaging;

import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;

/**
 * Created by Damian on 19.08.2017.
 */

@Controller
public class MsgController {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(MsgController.class);

    @MessageMapping("/sayHi")
    public Shout handleShout(Shout incoming) {
        LOGGER.info(incoming.getMessage());
        Shout outgoing = new Shout();
        outgoing.setMessage("HI "+incoming.getMessage());
        return outgoing;
    }

}
