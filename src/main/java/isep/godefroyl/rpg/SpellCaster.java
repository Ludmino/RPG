package isep.godefroyl.rpg;

public abstract class SpellCaster extends Hero {
    protected int manaPoints;

    public SpellCaster(String name) {
        super(name);
    }

    public SpellCaster() {
    }

    public int getManaPoints(){
        return manaPoints;
    }

    public void setManaPoints(int change){
        this.manaPoints+=change;
    }

    public abstract boolean attack(Hero hero);
}