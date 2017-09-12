package ds.game.equipment;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Weapon weapon;

    @OneToOne(cascade = CascadeType.ALL)
    private Armor armor;

    @OneToOne(cascade = CascadeType.ALL)
    private Ring leftHandRing;

    @OneToOne(cascade = CascadeType.ALL)
    private Ring rightHandRing;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Item> inBackpack = new ArrayList<>();

    public Equipment() {
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Ring getLeftHandRing() {
        return leftHandRing;
    }

    public void setLeftHandRing(Ring leftHandRing) {
        this.leftHandRing = leftHandRing;
    }

    public Ring getRightHandRing() {
        return rightHandRing;
    }

    public void setRightHandRing(Ring rightHandRing) {
        this.rightHandRing = rightHandRing;
    }

    public List<Item> getInBackpack() {
        return inBackpack;
    }

    public void setInBackpack(List<Item> inBackpack) {
        this.inBackpack = inBackpack;
    }
}
