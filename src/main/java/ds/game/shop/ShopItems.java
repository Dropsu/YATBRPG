package ds.game.shop;

import ds.game.equipment.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Damian on 13.09.2017.
 */
@Component
public class ShopItems {
    private List<Weapon> weapons = new ArrayList<>();
    private List<Armor> armors = new ArrayList<>();
    private List<Ring> rings = new ArrayList<>();


    public ShopItems() {
        weapons.add(new WoodenLog());
        weapons.add(new SuperSword());

        armors.add(new WarmMageCoat());
        armors.add(new PlateArmor());

        rings.add(new HealingAndStrangthRing());
        rings.add(new AgilityRing());
    }

    public Item findItemByName(String name) {
        List<Item>result = new ArrayList<>();
        result=weapons.stream().filter(weapon -> weapon.getName().equals(name)).
                collect(Collectors.toList());
        if(result.size()==0){
            result=armors.stream().filter(armor -> armor.getName().equals(name)).
                    collect(Collectors.toList());
        }
        if(result.size()==0){
            result=rings.stream().filter(ring -> ring.getName().equals(name)).
                    collect(Collectors.toList());
        }
        return result.get(0);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }

    public List<Ring> getRings() {
        return rings;
    }

    public void setRings(List<Ring> rings) {
        this.rings = rings;
    }
}
