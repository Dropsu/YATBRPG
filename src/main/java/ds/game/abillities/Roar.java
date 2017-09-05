package ds.game.abillities;

import ds.game.entities.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class Roar extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public Roar() {
        this.name="Roar";
    }

    @Override
    public void Effect(AbstractEntity entity) {
        entity.noWeaponDamage+=5;
    }
}
