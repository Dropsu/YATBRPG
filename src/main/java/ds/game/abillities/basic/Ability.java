package ds.game.abillities.basic;

import ds.game.entities.basic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public abstract class Ability {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Target target;
    private String description;
    private boolean missable = true;
    private int cost = 0;

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

        return getName().equals(ability.getName());

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMissable() {
        return missable;
    }

    public void setMissable(boolean missable) {
        this.missable = missable;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
