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
    private int spellLevel = 1;

    @Override
    public void use(AbstractEntity source, AbstractEntity target, List<String>log) {
        if(payAbilityCost(source)) {
            super.use(source, target, log);
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

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }
}
