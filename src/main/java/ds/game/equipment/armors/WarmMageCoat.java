package ds.game.equipment.armors;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;
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
        this.setValue(20);
        this.setDescription("Comfy mage coat, adds 1 Concentration and looks stylish");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        if(target instanceof Mage){
            Mage mage = (Mage) target;
            mage.setConcentration(mage.getConcentration()+1);
        }
    }
}
