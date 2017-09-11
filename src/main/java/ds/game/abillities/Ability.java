package ds.game.abillities;

import ds.game.entities.AbstractEntity;
import ds.game.entities.Mage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public abstract class Ability {
    @Id
    @GeneratedValue
    private long id;
    public String name;
    public Target target;
    public String description;
    public int damage;
    public boolean missable = true;
    public int cost = 0;

    public Ability() {
    }

    public void use(AbstractEntity source, AbstractEntity target, List<String> log){
            causeEffect(source, target, log);
    }

    protected abstract void causeEffect (AbstractEntity source, AbstractEntity target, List<String> log);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;

        Ability ability = (Ability) o;

        return name.equals(ability.name);

    }
}
