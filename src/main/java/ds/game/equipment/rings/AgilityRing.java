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
    private int agilityGain = 4;

    public AgilityRing() {
        this.setName("Agility Ring");
        this.setValue(50);
        this.setDescription("Super Agile, easy to miss, adds "+agilityGain+ " agility");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.setAgility(target.getAgility() + agilityGain);
    }

    @Override
    public void everyTurnEffect(AbstractEntity target) {}
}
