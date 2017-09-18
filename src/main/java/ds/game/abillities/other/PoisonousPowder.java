package ds.game.abillities.other;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class PoisonousPowder extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public PoisonousPowder() {
        this.setName("Poisonous Powder Strike");
        this.setTarget(Target.OTHER);
        this.setDescription("Attacks opponent with poisonous powder decreasing his condition");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int conditionTaken = 2;
        int strengthTaken = 2;
        target.setStrength(target.getStrength()-strengthTaken);
        target.setCondition(target.getCondition()-conditionTaken);
        log.add(source.getName()+" released poisonous powder, "+target.getName()+" took big unhealthy breath of it,"+
        target.getName()+" losses "+conditionTaken+" condition and"+strengthTaken+" strength.");
    }
}
