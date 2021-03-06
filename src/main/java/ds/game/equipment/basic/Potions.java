package ds.game.equipment.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class Potions {

    @Id
    @GeneratedValue
    private long id;

    private int healthPotionGoldValue = 30;
    private int manaPotionGoldValue = 30;

    private int healthPotionHealingValue = 10;
    private int manaPotionHealingValue = 15;


    private int healthPotions;
    private int manaPotions;

    public Potions() {
    }

    public int getHealthPotionGoldValue() {
        return healthPotionGoldValue;
    }

    public int getHealthPotions() {
        return healthPotions;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotions = healthPotions;
    }

    public int getManaPotions() {
        return manaPotions;
    }

    public void setManaPotions(int manaPotions) {
        this.manaPotions = manaPotions;
    }

    public int getManaPotionGoldValue() {
        return manaPotionGoldValue;
    }

    public void setManaPotionGoldValue(int manaPotionGoldValue) {
        this.manaPotionGoldValue = manaPotionGoldValue;
    }

    public int getHealthPotionHealingValue() {
        return healthPotionHealingValue;
    }

    public void setHealthPotionHealingValue(int healthPotionHealingValue) {
        this.healthPotionHealingValue = healthPotionHealingValue;
    }

    public int getManaPotionHealingValue() {
        return manaPotionHealingValue;
    }

    public void setManaPotionHealingValue(int manaPotionHealingValue) {
        this.manaPotionHealingValue = manaPotionHealingValue;
    }
}
