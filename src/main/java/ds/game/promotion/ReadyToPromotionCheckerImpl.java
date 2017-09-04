package ds.game.promotion;

import ds.game.entities.Mage;

/**
 * Created by Damian on 04.09.2017.
 */
public class ReadyToPromotionCheckerImpl implements ReadyToPromotionChecker {
    public int [] experienceTable;

    public ReadyToPromotionCheckerImpl() {
        for (int level = 0; level < 20; level++) {
            experienceTable[level]=level*100;
        }
    }

    @Override
    public boolean readyToPromotion(Mage mage) {
        //TODO: Marcelu, sprawdz poziom maga i korzystajac z tabeli expa z tej klasy zwroc czy powinien byc awansowany
        return false;
    }
}
