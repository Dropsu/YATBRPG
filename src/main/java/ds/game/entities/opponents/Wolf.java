package ds.game.entities.opponents;

import ds.game.abillities.Roar;
import ds.game.entities.AbstractEntity;
import ds.game.equipment.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class Wolf extends AbstractEntity {

    public Wolf() {
        this.level=1;
        this.accuracy=10;
        this.agility=10;
        this.condition=10;
        this.strength=10;
        this.noWeaponDamage=new Damage(1,6);
        this.healthPoints=10;
        this.name="Angry Wolf";
        this.abilities.add(new Roar());
        this.experienceForDefeating = 15;
    }
}
