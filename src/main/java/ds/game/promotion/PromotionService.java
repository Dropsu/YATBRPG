package ds.game.promotion;

import ds.config.Session;
import ds.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 02.09.2017.
 */

@Service
public class PromotionService {

    @Autowired
    private Session session; // MAG ZNAJDUJE SIE TU!!!
    private int abilitiesPointsPerLevel = 4;

    public void grantLevelAndAbilitiesPointsIfEnoughExp (){
    	
        /*TODO: Marcelu, sprawdz za pomoca metody z ReadyToPromotionChecker czy
        * bohater powinien byc awansowany, jezeli tak przyznaj mu abilitiesPointsPerLevel, bohater znajduje sie
        * w w obiekcie session*/
    }

    public Message distributePoints(DistributedPoints distributedPoints){
        //TODO: Sprawdz czy nie za duzo punktow dodano, jezeli nie, przypisz magowi punkty z distributedPoints
        return new Message("Punkty Rozdane");
    }

    private boolean checkIfNotTooMuchPointsIsAdded (DistributedPoints distributedPoints){
        //TODO: Marcelu, sprawdz korzytajac z metod z distributedPoints i Mage czy ilośc punktow w hero abilities jest o abilitiesPointsPerLevel wieksza niz w mage
        return false;
    }
}
