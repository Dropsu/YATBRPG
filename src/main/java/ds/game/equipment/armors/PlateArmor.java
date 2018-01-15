package ds.game.equipment.armors;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;
import ds.game.equipment.basic.Armor;

import javax.persistence.Entity;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class PlateArmor extends Armor {

    public PlateArmor() {
        this.setName("Plate Armor");
        this.setDamageReduction(3);
        this.setValue(50);
        this.setDescription("Sorry, it takes 3 agility and 2 concentration");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.setAgility(target.getAgility()-3);
            Mage mage = (Mage) target;
            target.getMagicalAbilities().decreaseConcentration(2);

    }
}
