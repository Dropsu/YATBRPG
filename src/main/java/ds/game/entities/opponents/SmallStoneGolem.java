package ds.game.entities.opponents;

import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class SmallStoneGolem extends AbstractEntity {

    public SmallStoneGolem() {
        this.setLevel(1);
        this.setAccuracy(10);
        this.setAgility(8);
        this.setCondition(10);
        this.setStrength(16);
        this.setNoWeaponDamage(new Damage(1,5));
        this.setHealthPoints(15);
        this.setName("Small Stone Golem");
        this.setExperienceForDefeating(15);
        this.setGoldForDefeating(10);
    }
}
