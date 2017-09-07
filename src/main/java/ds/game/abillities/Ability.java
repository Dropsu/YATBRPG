package ds.game.abillities;

import ds.game.entities.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Ability {
    @Id
    @GeneratedValue
    private long id;
    public String name;
    public Target target;
    public String description;
    public int damage;

    public Ability() {
    }

    public abstract void causeEffect(AbstractEntity entity);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;

        Ability ability = (Ability) o;

        return name.equals(ability.name);

    }
}
