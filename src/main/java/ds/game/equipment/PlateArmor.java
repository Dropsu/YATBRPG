package ds.game.equipment;

import javax.persistence.Entity;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class PlateArmor extends Armor {

    public PlateArmor() {
        this.name="Plate Armor";
        this.setDamageReduction(5);
        this.setValue(25);
    }
}
