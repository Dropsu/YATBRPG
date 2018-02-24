package ds;

import ds.game.entities.basic.Mage;
import ds.game.entities.basic.PlayersHero;
import ds.game.promotion.PromotionService;
import ds.session.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionServiceTest {

    private Session session;
    private PromotionService promotionService;

    @Before
    public void setUp(){
        session = mock(Session.class);
        promotionService = new PromotionService(session);
    }

    @Test
    public void grantLevelAndAbilitiesPointsIfEnoughExpTest(){

        //case1

        PlayersHero playersHero = new Mage();
        playersHero.setLevel(0);
        playersHero.setExperiencePoints(0);

        when(session.getMage()).thenReturn(playersHero);

        promotionService.grantLevelAndAbilitiesPointsIfEnoughExp();

        assertTrue(playersHero.getExperiencePoints()>=promotionService.getExperienceTable()[playersHero.getLevel()]&&
                playersHero.getExperiencePoints()<promotionService.getExperienceTable()[playersHero.getLevel()]+1);
        assertEquals(playersHero.getLevel()*promotionService.getAbilitiesPointsPerLevel(),playersHero.getAbilitiesPointsToSpare());

        //case2

        playersHero.setLevel(0);
        playersHero.setExperiencePoints(7200);
        playersHero.setAbilitiesPointsToSpare(0);

        promotionService.grantLevelAndAbilitiesPointsIfEnoughExp();

        assertTrue(playersHero.getExperiencePoints()>=promotionService.getExperienceTable()[playersHero.getLevel()]&&
                playersHero.getExperiencePoints()<promotionService.getExperienceTable()[playersHero.getLevel()]+1);
        assertEquals(playersHero.getLevel()*promotionService.getAbilitiesPointsPerLevel(),playersHero.getAbilitiesPointsToSpare());


    }

}
