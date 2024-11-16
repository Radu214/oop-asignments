package Cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

import java.util.ArrayList;

abstract public class Minion extends Card{
    private int attackDamage;
    private int health;
    @JsonIgnore
    private int placeBack;


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

    public void placeCard(Game game, int row) {
        Minion[][] table = game.getTable();

        for(int i = 0; i < 5; i++)
            if(table[row][i] == null) {
                table[row][i] = this;
                break;
            }
        int playerMana = game.getPlayers()[game.getCurrentPlayer()].getMana();
        playerMana = playerMana - this.getMana();
        game.getPlayers()[game.getCurrentPlayer()].setMana(playerMana);

    }

    public void useAbility() {
        /* to be overriden */
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

    public int getPlaceBack() {
        return this.placeBack;
    }

    public void setPlaceBack(final int frontPlace) {
        this.placeBack = frontPlace;
    }
}
