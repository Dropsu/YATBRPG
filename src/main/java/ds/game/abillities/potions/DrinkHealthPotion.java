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
    private int healingFor;

    public DrinkHealthPotion() {
        this.setName("Drink Health Potion");
        this.setTarget(Target.SELF);
        this.setMissable(false);
        this.setDescription("Drink one of your health potions");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        if(source.getEquipment().getPotions().getHealthPotions()>0){
            int healedFor = source.getEquipment().getPotions().getHealthPotionHealingValue();
            target.setHealthPoints(target.getHealthPoints() +healedFor );
            source.getEquipment().getPotions().setHealthPotions(source.getEquipment().getPotions().getHealthPotions()-1);
            log.add(target.getName()+" used health potion and healed for "+healedFor);
        }
    }
}
