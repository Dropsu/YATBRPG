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
        this.name="Drink Health Potion";
        this.target = Target.SELF;
        this.missable = false;
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        if(source.equipment.getPotions().getHealthPotions()>0){
            target.healthPoints+=30;
            source.equipment.getPotions().setHealthPotions(source.equipment.getPotions().getHealthPotions()-1);
            log.add("Health Potion drunk");
        }
    }
}
