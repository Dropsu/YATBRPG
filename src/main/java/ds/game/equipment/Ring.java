package ds.game.equipment;

import ds.game.entities.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by Damian on 31.08.2017.
 */

@Entity
public abstract class Ring extends Item  {
    public Ring() {
    }

    public abstract void battlePersistentEffect(AbstractEntity target);
    public abstract void everyTurnEffect(AbstractEntity target);

}
