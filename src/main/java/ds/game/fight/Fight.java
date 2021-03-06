package ds.game.fight;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;
import ds.game.entities.basic.PlayersHero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
public class Fight {

    private PlayersHero mage;
    private AbstractEntity opponent;
    private List<String>log=new ArrayList<>();


    public Fight(PlayersHero mage, AbstractEntity opponent) {
        this.setMage(mage);
        this.setOpponent(opponent);
    }

    public PlayersHero getMage() {
        return mage;
    }

    public void setMage(PlayersHero mage) {
        this.mage = mage;
    }

    public AbstractEntity getOpponent() {
        return opponent;
    }

    public void setOpponent(AbstractEntity opponent) {
        this.opponent = opponent;
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
