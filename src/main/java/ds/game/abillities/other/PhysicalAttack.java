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
        this.setName("Physical Attack");
        this.setTarget(Target.OTHER);
        this.setDescription("Attack with weapon in hand, or with no weapon");
        this.setMissable(true);
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int damage;
        if(source.getEquipment() ==null || source.getEquipment().getWeapon()==null){
            damage = source.getNoWeaponDamage().getRandomDamage();
        } else {
            damage = source.getEquipment().getWeapon().getDamage().getRandomDamage();
        }
        damage += source.getStrength() -10;
        if(!(target.getEquipment() ==null || target.getEquipment().getArmor()==null)){
            damage -= target.getEquipment().getArmor().getDamageReduction();
        }
        if(damage<0){
            damage=0;
        }
        target.setHealthPoints(target.getHealthPoints() - damage);
        log.add(source.getName() +" has physically attacked "+ target.getName() +" dealing "+damage+" damage");
    }

}
