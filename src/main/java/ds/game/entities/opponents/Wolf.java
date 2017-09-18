package ds.game.entities.opponents;

import ds.game.abillities.other.ExhaustingAttack;
import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class Wolf extends AbstractEntity {

    public Wolf() {
        this.setLevel(1);
        this.setAccuracy(12);
        this.setAgility(12);
        this.setCondition(10);
        this.setStrength(12);
        this.setNoWeaponDamage(new Damage(1,6));
        this.setHealthPoints(34);
        this.setName("Angry Wolf");
        this.getAbilities().add(new ExhaustingAttack());
        this.setExperienceForDefeating(15);
        this.setGoldForDefeating(15);
    }
}
