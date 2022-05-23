import isep.godefroyl.rpg.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SpellCasterTest {

    @Test
    public void hasEnoughMana(){
        //Initialisation
        Mage mage = new Mage("Mage");
        BasicEnemy enemy = new BasicEnemy();
        while (mage.getManaPoints()>0){
            if (mage.getManaPoints()>0){
                assertTrue(mage.getManaPoints()>0);
                mage.attack(enemy);
            } else {
                assertTrue(mage.getManaPoints()<=0);
                System.out.println("Plus assez de mana");
            }
        }
    }

    @Test
    public void consumeMana(){
        //Initialisation
        Mage mage = new Mage("Mage");
        BasicEnemy enemy = new BasicEnemy();
        int oldManaCount = mage.getManaPoints();
        mage.attack(enemy);
        int newManaCount = mage.getManaPoints();
        assertTrue(oldManaCount>newManaCount);
        System.out.println("Le mana a baissé après attaque, il est passé de "+oldManaCount+" à "+newManaCount);
    }


}
