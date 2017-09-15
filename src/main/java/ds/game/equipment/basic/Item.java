package ds.game.equipment.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Damian on 31.08.2017.
 */

@Entity
public abstract class Item {

    @Id
    @GeneratedValue
    protected long id;

    protected String name;
    protected int value;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
