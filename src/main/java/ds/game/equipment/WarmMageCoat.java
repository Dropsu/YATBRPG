package ds.game.equipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class WarmMageCoat extends Armor {

    public WarmMageCoat() {
        this.name="Warm Mage Coat";
        this.setDamageReduction(20);
        this.setValue(10);
    }
}
