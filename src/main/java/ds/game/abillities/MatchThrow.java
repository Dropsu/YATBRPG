package ds.game.abillities;

import ds.game.entities.AbstractEntity;
import ds.game.entities.AbstractMagicalEntity;
import ds.game.entities.Mage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class MatchThrow extends Spell {

    @Id
    @GeneratedValue
    private long id;


    public MatchThrow() {
        this.name="Match Throw";
        this.target=Target.OTHER;
        this.damage = 1;
        this.description = "Throws a match in opponent's face - deal "+damage+" damage.";
        this.missable = true;
        this.cost = 15;
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target) {
        target.healthPoints -= damage;
    }
}
