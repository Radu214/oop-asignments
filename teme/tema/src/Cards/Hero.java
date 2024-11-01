package Cards;

import fileio.CardInput;

public class Hero extends Card{
    int abilityCode;
    int health = 30;

    public Hero(CardInput c) {
        super(c);
        abilityCode = 0;
    }
}
