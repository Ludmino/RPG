import isep.godefroyl.rpg.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    @Test
    public void testPV(){
        //Initialisation
        Warrior guerrier = new Warrior("Guerrier");
        System.out.println("Point de vie : "+ guerrier.getLifePoints());
        boolean isDeadly = guerrier.receiveDamage(guerrier.getLifePoints()+ guerrier.getArmor()+1);
        System.out.println("Dégâts mortel");
        assertTrue(guerrier.isDead());
        //Validation du test
        System.out.println("Personnage mort");
        assertTrue(guerrier.isDead());
    }

    @Test
    public void victoryTest(){
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        heroes.add(new Warrior("Guerrier"));
        enemies.add(new BasicEnemy());
        enemies.add(new BasicEnemy());
        while (enemies.size()>0){
            boolean killed = heroes.get(0).attack(enemies.get(0));
            if (killed) {
                enemies.remove(0);
            }
        }
        System.out.println("Tous les ennemis sont morts");
        assertTrue(enemies.size()<=0);
    }

    @Test
    public void looseTest(){
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        heroes.add(new Warrior("Guerrier"));
        heroes.add(new Mage("Mage"));
        enemies.add(new BasicEnemy());
        while (heroes.size()>0){
            boolean killed = enemies.get(0).attack(heroes.get(0));
            if (killed) {
                heroes.remove(0);
            }
        }
        System.out.println("Tous les héros sont morts");
        assertTrue(heroes.size()<=0);
    }

    @Test
    public void damageQuantity(){
        Warrior guerrier = new Warrior("Guerrier");
        BasicEnemy enemy = new BasicEnemy();
        System.out.println("Attaque du guerrier : "+guerrier.getWeaponDamage());
        System.out.println("Armure de l'ennemi : "+enemy.getArmor());
        System.out.println("Dégâts estimés : "+(guerrier.getWeaponDamage()-enemy.getArmor()));
        int oldEnemyLifePoint = enemy.getLifePoints();
        guerrier.attack(enemy);
        int newEnemyLifePoint = enemy.getLifePoints();
        System.out.println("Dégâts infligés réels : "+(oldEnemyLifePoint-newEnemyLifePoint));
        assertTrue((guerrier.getWeaponDamage()-enemy.getArmor())==(oldEnemyLifePoint-newEnemyLifePoint));
    }
}
