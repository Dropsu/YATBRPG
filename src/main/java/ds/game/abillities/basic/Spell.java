package ds.game.abillities.basic;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.AbstractMagicalEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public abstract class Spell extends Ability {

    @Id
    @GeneratedValue
    private long id;

    @Override
    public void use(AbstractEntity source, AbstractEntity target, List<String>log) {
        if(payAbilityCost(source)) {
            super.use(source, target, log);
        }
    }

    protected boolean payAbilityCost (AbstractEntity source){
        if(source instanceof AbstractMagicalEntity){
            AbstractMagicalEntity magicalEntity = (AbstractMagicalEntity) source;
            magicalEntity.setManaPoints(magicalEntity.getManaPoints() - getCost());
        }
        return true;
    }

    public Spell() {
        Spell spell;
    }
}
