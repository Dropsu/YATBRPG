package ds.game.entities.opponents;

import ds.game.abillities.other.Roar;
import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class Wolf extends AbstractEntity {

    public Wolf() {
        this.setLevel(1);
        this.setAccuracy(10);
        this.setAgility(10);
        this.setCondition(10);
        this.setStrength(10);
        this.setNoWeaponDamage(new Damage(1,6));
        this.setHealthPoints(10);
        this.setName("Angry Wolf");
        this.getAbilities().add(new Roar());
        this.setExperienceForDefeating(15);
        this.setGoldForDefeating(15);
    }
}
