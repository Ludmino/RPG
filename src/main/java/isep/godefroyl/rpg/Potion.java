package isep.godefroyl.rpg;

public class Potion implements Consumable {
    private int minHeal = 8;
    private int maxHeal = 12;

    @Override
    public int healedLifePoint() {
        return (int)Math.floor(Math.random()*(this.maxHeal-this.minHeal+1)+this.minHeal);
    }
}