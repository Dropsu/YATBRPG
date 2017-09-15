package ds.game.entities.basic;

import ds.game.abillities.potions.DrinkHealthPotion;
import ds.game.abillities.potions.DrinkManaPotion;
import ds.game.abillities.spells.MatchThrow;
import ds.game.equipment.armors.WarmMageCoat;
import ds.game.equipment.basic.Damage;
import ds.game.equipment.basic.Equipment;
import ds.game.equipment.rings.HealingAndStrangthRing;
import ds.game.equipment.weapons.WoodenLog;

import javax.persistence.*;

/**
 * Created by Damian on 24.08.2017.
 */
@Entity
public class Mage extends AbstractMagicalEntity implements PlayersHero {

    @Id
    @GeneratedValue
    private Long id;

    public int experiencePoints;
    public int abilitiesPointsToSpare;

    public int concentration;

    public Mage() {
    }

    public Mage (String login) {
        this.name = login + "'s hero";
        this.level = 1;
        this.experiencePoints = 0;
        this.abilitiesPointsToSpare = 4;

        this.concentration=10;
        this.strength = 10;
        this.accuracy=10;
        this.agility = 10;
        this.condition=10;

        this.healthPoints=10;
        this.healthRegen=0;
        this.manaPoints=40;
        this.manaRegeneration=0;
        this.noWeaponDamage=new Damage(1,3);

        this.abilities.add(new MatchThrow());
        this.abilities.add(new DrinkHealthPotion());
        this.abilities.add(new DrinkManaPotion());

        this.equipment = new Equipment();
        this.equipment.setGold(0);
        this.equipment.setWeapon(new WoodenLog());
        this.equipment.setArmor(new WarmMageCoat());
        this.equipment.setLeftHandRing(new HealingAndStrangthRing());
        this.equipment.potions.setHealthPotions(2);
        this.equipment.potions.setManaPotions(2);


    }

    public Mage (Mage other){
        super(other);
        this.manaPoints = other.manaPoints;
        this.concentration = other.concentration;
        this.equipment = other.equipment;
        this.equipment.potions = other.equipment.potions;
    }
}
