package ds.game.abillities.potions;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.AbstractMagicalEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class DrinkManaPotion extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public DrinkManaPotion() {
        this.setName("Drink Mana Potion");
        this.setTarget(Target.SELF);
        this.setMissable(false);
        this.setDescription("Drink one of your mana potions");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        if(source.getEquipment().getPotions().getManaPotions()>0){
            int manaRegain = source.getEquipment().getPotions().getManaPotionHealingValue();
            AbstractMagicalEntity abstractMagicalEntity = (AbstractMagicalEntity) source;
            abstractMagicalEntity.setManaPoints(abstractMagicalEntity.getManaPoints() + manaRegain);
            source.getEquipment().getPotions().setManaPotions(source.getEquipment().getPotions().getManaPotions()-1);
            log.add(target.getName()+" used mana potion and regain "+manaRegain+" mana");
        }
    }
}
