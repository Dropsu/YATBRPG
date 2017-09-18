package ds.game.equipment.basic;

import ds.game.entities.basic.AbstractEntity;

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
    private long id;

    private String name;
    private int value;
    private String description ="";

    public Item() {
    }

    public void battlePersistentEffect(AbstractEntity target){

    }
    public void everyTurnEffect(AbstractEntity target){

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
