package ds.account;

import ds.game.abillities.potions.DrinkHealthPotion;
import ds.game.abillities.potions.DrinkManaPotion;
import ds.game.abillities.spells.MatchThrow;
import ds.game.entities.basic.Mage;
import ds.game.equipment.armors.WarmMageCoat;
import ds.game.equipment.basic.Damage;
import ds.game.equipment.basic.Equipment;
import ds.game.equipment.rings.HealingAndStrangthRing;
import ds.game.equipment.weapons.WoodenLog;
import org.springframework.stereotype.Component;

/**
 * Created by Damian on 15.09.2017.
 */
@Component
public class MageCreatorImpl implements MageCreator {

    @Override
    public Mage buildMageForNewAccount(String username) {
        Mage mage = new Mage();
        mage.setName(username + "'s hero");
        mage.setLevel(1);
        mage.setExperiencePoints(0);
        mage.setAbilitiesPointsToSpare(4);

        mage.setConcentration(10);
        mage.setStrength(10);
        mage.setAccuracy(10);
        mage.setAgility(10);
        mage.setCondition(10);

        mage.setHealthPoints(10);
        mage.setHealthRegen(0);
        mage.setManaPoints(40);
        mage.setManaRegeneration(0);
        mage.setNoWeaponDamage(new Damage(1,3));

        mage.getAbilities().add(new MatchThrow());
        mage.getAbilities().add(new DrinkHealthPotion());
        mage.getAbilities().add(new DrinkManaPotion());

        mage.setEquipment(new Equipment());
        mage.getEquipment().setGold(0);
        mage.getEquipment().setWeapon(new WoodenLog());
        mage.getEquipment().setArmor(new WarmMageCoat());
        mage.getEquipment().setLeftHandRing(new HealingAndStrangthRing());
        mage.getEquipment().potions.setHealthPotions(2);
        mage.getEquipment().potions.setManaPotions(2);

        return mage;
    }
}
