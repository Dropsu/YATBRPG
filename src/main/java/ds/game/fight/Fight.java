package ds.game.fight;

import ds.game.entities.AbstractEntity;
import ds.game.entities.Mage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
public class Fight {

    public Mage mage;
    public AbstractEntity opponent;
    public List<String>log=new ArrayList<>();


    public Fight(Mage mage, AbstractEntity opponent) {
        this.mage = mage;
        this.opponent = opponent;
    }
}
