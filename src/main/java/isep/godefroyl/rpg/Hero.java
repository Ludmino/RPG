package isep.godefroyl.rpg;

import java.util.ArrayList;
import java.util.List;

abstract public class Hero {

    public Hero(String name) {
        this.name=name;
    }

    protected String name;
    protected int maxLifePoints;
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected String typeHero;
    protected ArrayList<Potion> Potions = new ArrayList<Potion>();
    protected ArrayList<Food> Lambas = new ArrayList<Food>();
    protected double consumableEfficency = 1;

    public int getMaxLifePoints() {
        return maxLifePoints;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public double getConsumableEfficency() {
        return consumableEfficency;
    }

    protected Hero() {
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }
    public void setWeaponDamage(int damageUp){
        this.weaponDamage+=damageUp;
    }

    public int getArmor(){
        return armor;
    }
    public void setArmor(int armorUp){
        this.armor+=armorUp;
    }

    public double getConsumableEfficiency(){
        return consumableEfficency;
    }
    public void setConsumableEfficency(double EfficiencyUp){
        this.consumableEfficency+=EfficiencyUp;
    }

    public int getLifePoints(){
        return lifePoints;
    }
    public void setLifePoints(int change){
        if (this.lifePoints+change>=this.maxLifePoints) {
            this.lifePoints=this.maxLifePoints;
        } else {
            this.lifePoints+=change;
        }
    }

    public boolean attack(Enemy enemy){
        return enemy.receiveDamage(this.weaponDamage);
    }

    public String getName() {
        return name;
    }

    public void defend(){

    }

    public void useConsumable(){

    }

    public String getTypeHero() {
        return typeHero;
    }

    public Boolean receiveDamage(int damage){
        if (damage-this.armor<0){
            damage = 0;
        } else {
            damage=damage-this.armor;
        }
        this.lifePoints=lifePoints-damage;
        return this.lifePoints<=0;
    }

    public boolean isDead(){
        if (this.getLifePoints()<=0){
            return true;
        } else {
            return false;
        }
    }

    public int getLambas() {
        return Lambas.size();
    }

    public void setLambas(int count) {
        if (count==-1){
            if (Lambas.size()>0){
                int healedLifePoint = Lambas.get(0).healedLifePoint();
                this.setLifePoints(healedLifePoint);
                Lambas.remove(0);
            }
        } else {
            for (int i=0; i<count;i++){
                Food lamba = new Food();
                Lambas.add(lamba);
            }
        }
    }

    public void setPotions(int count){
        System.out.println("called");
        if (count==-1){
            if (Potions.size()>0){
                int healedLifePoint = Potions.get(0).healedLifePoint();
                this.setLifePoints(healedLifePoint);
                Potions.remove(0);
            }
        } else {
            System.out.println("yes");
            for (int i=0; i<count;i++){
                Potion potion = new Potion();
                System.out.println("presque");
                Potions.add(potion);
            }
        }
    }

    public int getPotions() {
        return Potions.size();
    }

}