package ds.game.entities;

import ds.game.abillities.Roar;

/**
 * Created by Damian on 05.09.2017.
 */
public class Wolf extends AbstractEntity {

    public Wolf() {
        this.accuracy=10;
        this.agility=10;
        this.condition=10;
        this.strength=10;
        this.noWeaponDamage=5;
        this.healthPoints=10;
        this.name="Angry Wolf";
        this.abilities.add(new Roar());
    }
}
