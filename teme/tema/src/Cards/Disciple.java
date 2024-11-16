package Cards;

import fileio.CardInput;

public class Disciple extends Minion{

    Disciple(CardInput c) {
        super(c);
        setPlaceBack(1);
    }
}
