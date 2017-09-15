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
        this.name="Drink Mana Potion";
        this.target = Target.SELF;
        this.missable = false;
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        if(source.equipment.getPotions().getManaPotions()>0){
            AbstractMagicalEntity abstractMagicalEntity = (AbstractMagicalEntity) source;
            abstractMagicalEntity.manaPoints+=30;
            source.equipment.getPotions().setManaPotions(source.equipment.getPotions().getManaPotions()-1);
            log.add("Mana Potion drunk");
        }
    }
}
