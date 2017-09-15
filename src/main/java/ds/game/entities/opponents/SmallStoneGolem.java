package ds.game.entities.opponents;

import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class SmallStoneGolem extends AbstractEntity {

    public SmallStoneGolem() {
        this.level=1;
        this.accuracy=10;
        this.agility=8;
        this.condition=10;
        this.strength=16;
        this.noWeaponDamage=new Damage(1,5);
        this.healthPoints=15;
        this.name="Small Stone Golem";
        this.experienceForDefeating = 15;
    }
}
