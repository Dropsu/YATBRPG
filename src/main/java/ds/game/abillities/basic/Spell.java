package ds.game.abillities.basic;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.AbstractMagicalEntity;
import ds.game.entities.basic.Mage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public abstract class Spell extends Ability {

    @Id
    @GeneratedValue
    private long id;

    @Override
    public void use(AbstractEntity source, AbstractEntity target, List<String>log) {
        if(payAbilityCost(source)) {
            if(isConcentrationAllowingPlayerToCastSpell(source)){
                super.use(source, target, log);
            } else {
                log.add("Spell had no effect due to low Concentration");
            }
        }
    }

    private boolean isConcentrationAllowingPlayerToCastSpell(AbstractEntity source) {
        Mage mage = (Mage)source;
        if(mage.getConcentration()<10){
            double spellSuccessChance = 1-((10-mage.getConcentration())*0.05);
            if(ThreadLocalRandom.current().nextDouble()>spellSuccessChance){
                return false;
            }else {
                return true;
            }
        } else {
            return true;
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
