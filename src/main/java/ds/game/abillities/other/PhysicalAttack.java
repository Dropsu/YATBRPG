package ds.game.abillities.other;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 08.09.2017.
 */
@Entity
public class PhysicalAttack extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public PhysicalAttack() {
        this.name="Physical Attack";
        this.target= Target.OTHER;
        this.description="Attack with weapon in hand, or with no weapon";
        this.missable = true;
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int damage;
        if(source.equipment==null || source.equipment.getWeapon()==null){
            damage = source.noWeaponDamage.getRandomDamage();
        } else {
            damage = source.equipment.getWeapon().getDamage().getRandomDamage();
        }
        damage += source.strength-10;
        if(!(target.equipment==null || target.equipment.getArmor()==null)){
            damage -= target.equipment.getArmor().getDamageReduction();
            if(damage<0){
                damage=0;
            }
        }
        target.healthPoints -= damage;
        log.add(source.name+" has physically attacked "+target.name+" dealing "+damage+" damage");
    }

}
