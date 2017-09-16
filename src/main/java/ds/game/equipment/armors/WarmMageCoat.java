package ds.game.equipment.armors;

import ds.game.equipment.basic.Armor;

import javax.persistence.Entity;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class WarmMageCoat extends Armor {

    public WarmMageCoat() {
        this.setName("Warm Mage Coat");
        this.setDamageReduction(1);
        this.setValue(10);
    }
}
