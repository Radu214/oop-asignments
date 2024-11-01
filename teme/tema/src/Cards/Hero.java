package Cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Hero extends Card{
    public enum ability {
        SUBZERO, LOWBLOW, EARTHBORN, BLOODTHIRST
    };
    private ability abilityHero;
    int health = 30;

    public Hero(CardInput c) {
        super(c);
        switch (super.getName()) {
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
}
