package ds.game.shop;

import ds.game.equipment.basic.*;
import ds.session.Session;
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
        Equipment mageEquipment = getMageEquipment();
        int gold = getMageGold(mageEquipment);
        Item item = shopItems.findItemByName(itemName);
        if(!isItemAffordable(gold, item)){
            return mageEquipment;
        }
        if(placeItemInRightSpot(itemType, mageEquipment, item)){
            payItemCost(gold, item);
        }
        return mageEquipment;
    }

    private void payItemCost(int gold, Item item) {
        session.getMage().getEquipment().setGold(gold-item.getValue());
    }

    private boolean placeItemInRightSpot(String itemType, Equipment mageEquipment, Item item) {
        boolean isItemPlaced = false;
        if(itemType.equals("weapon")){
            if(mageEquipment.getWeapon()==null){
                Weapon weapon = (Weapon) item;
                mageEquipment.setWeapon(weapon);
                isItemPlaced = true;
            }
        } else if(itemType.equals("armor")){
            if(mageEquipment.getArmor()==null){
                Armor armor = (Armor) item;
                mageEquipment.setArmor(armor);
                isItemPlaced = true;
            }
        } else if(itemType.equals("ring")){
            Ring ring = (Ring) item;
            if(mageEquipment.getLeftHandRing()==null){
                mageEquipment.setLeftHandRing(ring);
                isItemPlaced = true;
            } else if(mageEquipment.getRightHandRing()==null){
                mageEquipment.setRightHandRing(ring);
                isItemPlaced = true;
            }
        }
        return isItemPlaced;
    }

    private Equipment getMageEquipment() {
        return session.getMage().getEquipment();
    }

    private int getMageGold(Equipment mageEquipment) {
        return mageEquipment.getGold();
    }

    private boolean isItemAffordable(int gold, Item item) {
        return item.getValue()<=gold;
    }

    @Override
    public Equipment sellItem(String itemType) {
        Equipment magesEquipment = getMageEquipment();
        int gold = getMageGold(magesEquipment);
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
        return getMageEquipment();
    }

    @Override
    public ShopItems serveItemFromShop() {
        return shopItems;
    }

    @Override
    public Equipment buyPotions(int number, String type) {
        int gold = getMageGold(getMageEquipment());
        Equipment mageEquipment = getMageEquipment();
        if(type.equals("healthPotion")&& areHealthPotionsAffordable(number, gold, mageEquipment)){
            mageEquipment.potions.setHealthPotions(mageEquipment.potions.getHealthPotions()+number);
            payHealthPotionsCost(number, gold, mageEquipment);
        }
        if(type.equals("manaPotion")&& areManaPotionsAffordable(number, gold, mageEquipment)){
            mageEquipment.potions.setManaPotions(mageEquipment.potions.getManaPotions()+number);
            payManaPotionsCost(number, gold, mageEquipment);
        }
        return mageEquipment;
    }

    private void payManaPotionsCost(int number, int gold, Equipment mageEquipment) {
        mageEquipment.setGold(gold - number* mageEquipment.potions.getManaPotionGoldValue());
    }

    private void payHealthPotionsCost(int number, int gold, Equipment mageEquipment) {
        mageEquipment.setGold(gold - number * mageEquipment.potions.getHealthPotionGoldValue());
    }

    private boolean areManaPotionsAffordable(int number, int gold, Equipment mageEquipment) {
        return gold>= number* mageEquipment.potions.getManaPotionGoldValue();
    }

    private boolean areHealthPotionsAffordable(int number, int gold, Equipment mageEquipment) {
        return gold>= number* mageEquipment.potions.getHealthPotionGoldValue();
    }
}
