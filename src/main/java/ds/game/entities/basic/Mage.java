package ds.game.entities.basic;

import javax.persistence.*;

/**
 * Created by Damian on 24.08.2017.
 */
@Entity
public class Mage extends PlayersHero {

    public Mage() {}

    public Mage (Mage other){
        super(other);
    }

    public PlayersHero copy() {
        Mage copyMage = new Mage(this);
        return copyMage;
    }




}
