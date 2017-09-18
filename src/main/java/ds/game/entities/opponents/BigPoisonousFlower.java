package ds.game.entities.opponents;

import ds.game.abillities.other.ExhaustingAttack;
import ds.game.abillities.other.PoisonousPowder;
import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

/**
 * Created by Damian on 05.09.2017.
 */
public class BigPoisonousFlower extends AbstractEntity {

    public BigPoisonousFlower() {
        this.setLevel(1);
        this.setAccuracy(9);
        this.setAgility(7);
        this.setCondition(14);
        this.setStrength(13);
        this.setNoWeaponDamage(new Damage(1,6));
        this.setHealthPoints(10);
        this.setName("Angry Wolf");
        this.getAbilities().add(new ExhaustingAttack());
        this.setExperienceForDefeating(15);
        this.setGoldForDefeating(15);
        this.getAbilities().add(new PoisonousPowder());
    }
}
