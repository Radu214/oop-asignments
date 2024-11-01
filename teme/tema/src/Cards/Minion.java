package Cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Minion extends Card{
    private int attackDamage;
    private int health;


    Minion(CardInput c) {
        super(c);
        attackDamage = c.getAttackDamage();
        health = c.getHealth();
    }

    @Override
    public ObjectNode outputCard() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.valueToTree(this);
        return jsonNode;
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }
}
