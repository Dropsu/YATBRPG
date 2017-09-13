package ds.game.shop;

import ds.config.Session;
import ds.game.entities.Mage;
import ds.game.equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 13.09.2017.
 */
@Service
public class ShopServiceImpl implements ShopService {

    private Session session;

    @Autowired
    public ShopServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public void buyItem() {

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

    public Equipment serveItems() {
        return session.getMage().equipment;
    }
}
