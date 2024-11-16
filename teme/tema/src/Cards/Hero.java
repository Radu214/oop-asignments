package Cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

import java.util.ArrayList;

public class Hero extends Card{

    public enum ability {
        SUBZERO, LOWBLOW, EARTHBORN, BLOODTHIRST
    };
    @JsonIgnore
    private ability abilityHero;

    int health = 30; //nu cred ca e bine, posibil sa fie final

    public Hero(CardInput c) {
        super(c);
        switch (this.getName()) {
            case "Lord Royce" : {
                abilityHero = ability.SUBZERO;
                break;
            }
            case "Empress Thorina" : {
                abilityHero = ability.LOWBLOW;
                break;
            }
            case "King Mudface" : {
                abilityHero = ability.EARTHBORN;
                break;
            }
            case "General Kocioraw" : {
                abilityHero = ability.BLOODTHIRST;
                break;
            }
        }
    }

    public ObjectNode outputCard() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.valueToTree(this);
        return jsonNode;
    }

    //Se folosesc la valueToTree


    public ability getAbilityHero() {
        return this.abilityHero;
    }

    public void setAbilityHero(final ability abilityHero) {
        this.abilityHero = abilityHero;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }
}
