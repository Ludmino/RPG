import isep.godefroyl.rpg.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HunterTest {

    @Test
    public void consumeArrow(){
        Hunter chasseur = new Hunter("Hunter");
        BasicEnemy enemy = new BasicEnemy();

        int oldArrowCount = chasseur.getArrows();
        chasseur.attack(enemy);
        int newArrowCount = chasseur.getArrows();
        assertTrue(oldArrowCount>newArrowCount);
        System.out.println("Le nombre de flèches a baissé après attaque, il est passé de "+oldArrowCount+" à "+newArrowCount);
    }
}
