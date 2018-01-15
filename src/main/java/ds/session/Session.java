package ds.session;

import ds.game.entities.basic.PlayersHero;
import ds.game.fight.Fight;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public class Session {
        private PlayersHero mage;
        private Fight fight;

    public PlayersHero getMage() {
        return mage;
    }

    public void setMage(PlayersHero mage) {
        this.mage = mage;
    }

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }
}