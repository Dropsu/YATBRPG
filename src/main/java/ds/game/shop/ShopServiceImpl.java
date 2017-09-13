package ds.game.shop;

import ds.config.Session;
import ds.game.equipment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 13.09.2017.
 */
@Service
public class ShopServiceImpl implements ShopService {

    private Session session;
    private ShopItems shopItems;

    @Autowired
    public ShopServiceImpl(Session session, ShopItems shopItems) {
        this.session = session;
        this.shopItems = shopItems;
    }

    @Override
    public Equipment buyItem(String itemName, String itemType) {
        Equipment mageEquipment = session.getMage().equipment;
        int gold = mageEquipment.getGold();
        Item item = shopItems.findItemByName(itemName);
        if(item.getValue()>gold){
            return mageEquipment;
        }
        if(itemType.equals("weapon")){
            if(mageEquipment.getWeapon()==null){
                Weapon weapon = (Weapon) item;
                mageEquipment.setWeapon(weapon);
                mageEquipment.setGold(gold-weapon.getValue());
            }
        } else if(itemType.equals("armor")){
            if(mageEquipment.getArmor()==null){
                Armor armor = (Armor) item;
                mageEquipment.setArmor(armor);
                mageEquipment.setGold(gold-armor.getValue());
            }
        } else if(itemType.equals("ring")){
            Ring ring = (Ring) item;
            if(mageEquipment.getLeftHandRing()==null){
                mageEquipment.setLeftHandRing(ring);
                mageEquipment.setGold(gold-ring.getValue());
            } else if(mageEquipment.getRightHandRing()==null){
                mageEquipment.setRightHandRing(ring);
                mageEquipment.setGold(gold-ring.getValue());
            }
        }
        return mageEquipment;
    }

    @Override
    public Equipment sellItem(String itemType) {
        Equipment magesEquipment = session.getMage().equipment;
        int gold = magesEquipment.getGold();
        if(itemType.equals("weapon")&&magesEquipment.getWeapon()!=null){
            magesEquipment.setGold(gold+magesEquipment.getWeapon().getValue());
            magesEquipment.setWeapon(null);
        } else if(itemType.equals("armor")&&magesEquipment.getArmor()!=null){
            magesEquipment.setGold(gold+magesEquipment.getArmor().getValue());
            magesEquipment.setArmor(null);
        } else if(itemType.equals("leftHandRing")&&magesEquipment.getLeftHandRing()!=null){
            magesEquipment.setGold(gold+magesEquipment.getLeftHandRing().getValue());
            magesEquipment.setLeftHandRing(null);
        } else if(itemType.equals("rightHandRing")&&magesEquipment.getRightHandRing()!=null){
            magesEquipment.setGold(gold+magesEquipment.getRightHandRing().getValue());
            magesEquipment.setRightHandRing(null);
        }
        return magesEquipment;
    }

    public Equipment serveItemsForMage() {
        return session.getMage().equipment;
    }

    @Override
    public ShopItems serveItemFromShop() {
        return shopItems;
    }
}
