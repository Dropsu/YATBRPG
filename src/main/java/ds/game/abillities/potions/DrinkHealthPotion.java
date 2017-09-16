package ds.game.abillities.potions;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class DrinkHealthPotion extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public DrinkHealthPotion() {
        this.setName("Drink Health Potion");
        this.setTarget(Target.SELF);
        this.setMissable(false);
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        if(source.getEquipment().getPotions().getHealthPotions()>0){
            target.setHealthPoints(target.getHealthPoints() + 30);
            source.getEquipment().getPotions().setHealthPotions(source.getEquipment().getPotions().getHealthPotions()-1);
            log.add("Health Potion drunk");
        }
    }
}
