package ds.game.shop;

import ds.game.equipment.Equipment;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 13.09.2017.
 */

@Service
public interface ShopService {
    Equipment buyItem(String itemName, String itemType);
    Equipment sellItem(String itemType);
    Equipment serveItemsForMage();
    ShopItems serveItemFromShop();
    Equipment buyPotions(int number, String type);
}
