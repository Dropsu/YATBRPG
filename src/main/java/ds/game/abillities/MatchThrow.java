package ds.game.abillities;

import ds.game.entities.AbstractEntity;

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
    }

    @Override
    public void Effect(AbstractEntity entity) {
        entity.healthPoints -=7;
    }
}
