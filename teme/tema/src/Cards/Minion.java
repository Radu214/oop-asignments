package Cards;

import fileio.CardInput;

public class Minion extends Card{
    private int attackDamage;
    private int health;


    Minion(CardInput c) {
        super(c);
        attackDamage = c.getAttackDamage();
        health = c.getHealth();
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
