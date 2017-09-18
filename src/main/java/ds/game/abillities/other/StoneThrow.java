package ds.game.abillities.other;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class StoneThrow extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public StoneThrow() {
        this.setName("Poisonous Powder Strike");
        this.setTarget(Target.OTHER);
        this.setDescription("Attacks opponent with poisonous powder decreasing his condition");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int damageDealt = source.getNoWeaponDamage().getRandomDamage();
        int agilityTaken = 3;
        String messageToLog=source.getName()+" throws a stone at "+target.getName()+" dealing "+
                damageDealt+" damage. "+target.getName()+" is dazed -"+
                agilityTaken+" agility\n";
        target.setHealthPoints(target.getHealthRegen()-damageDealt);
        target.setAccuracy(target.getAgility()-agilityTaken);

        if(target instanceof Mage){
            int concentrationTaken = 2;
            Mage mage = (Mage)target;
            mage.setConcentration(mage.getConcentration()-concentrationTaken);
            messageToLog+=",-"+concentrationTaken+" concentration";
        }
        log.add(messageToLog);
    }
}
