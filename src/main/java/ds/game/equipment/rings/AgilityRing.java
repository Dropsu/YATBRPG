package ds.game.equipment.rings;

import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Ring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class AgilityRing extends Ring {

    @Id
    @GeneratedValue
    private long id;

    public AgilityRing() {
        this.name="Agility Ring";
        this.setValue(50);
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.agility+=2;
    }

    @Override
    public void everyTurnEffect(AbstractEntity target) {}
}