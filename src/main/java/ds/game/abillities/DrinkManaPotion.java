package ds.game.abillities;

import ds.game.entities.AbstractEntity;
import ds.game.entities.AbstractMagicalEntity;

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
        if(source.potions.getManaPotions()>0){
            AbstractMagicalEntity abstractMagicalEntity = (AbstractMagicalEntity) source;
            abstractMagicalEntity.manaPoints+=30;
            source.potions.setManaPotions(source.potions.getManaPotions()-1);
            log.add("Mana Potion drunk");
        }
    }
}
