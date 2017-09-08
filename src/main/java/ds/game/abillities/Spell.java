package ds.game.abillities;

import ds.game.entities.AbstractEntity;
import ds.game.entities.AbstractMagicalEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Spell extends Ability {

    @Id
    @GeneratedValue
    private long id;

    @Override
    public void use(AbstractEntity source, AbstractEntity target) {
        if(payAbilityCost(source)) {
            super.use(source, target);
        }
    }

    protected boolean payAbilityCost (AbstractEntity source){
        if(source instanceof AbstractMagicalEntity){
            AbstractMagicalEntity magicalEntity = (AbstractMagicalEntity) source;
            magicalEntity.manaPoints-=cost;
        }
        return true;
    }

    public Spell() {
        Spell spell;
    }
}
