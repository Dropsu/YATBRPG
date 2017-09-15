package ds.game.shop;

import ds.game.equipment.basic.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 13.09.2017.
 */
@Controller
@RequestMapping("/equipment")
public class ShopControllerImpl implements ShopController {

    private ShopService shopService;

    @Autowired
    public ShopControllerImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String equipmentPage() {
        return "equipment";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Equipment serveItemsForMage() {
        return shopService.serveItemsForMage();
    }

    @Override
    @RequestMapping("/buy")
    public @ResponseBody Equipment buyItem(String itemName, String itemType) {
        return shopService.buyItem(itemName,itemType);
    }

    @Override
    @RequestMapping("/sell")
    public @ResponseBody
    Equipment sellItem(String itemType) {
        return shopService.sellItem(itemType);
    }

    @Override
    @RequestMapping("/shop")
    public @ResponseBody ShopItems serveItemFromShop() {
        return shopService.serveItemFromShop();
    }

    @Override
    @RequestMapping(value = "/buyPotions",method = RequestMethod.POST)
    public @ResponseBody
    Equipment buyPotions(int number, String type) {
        return shopService.buyPotions(number,type);
    }
}
