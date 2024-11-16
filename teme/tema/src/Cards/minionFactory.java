package Cards;

import fileio.CardInput;

import java.util.HashMap;
import java.util.Map;

public class minionFactory {
    private static final Map<String, Minion> minionMap = new HashMap<>(); //nu stiu daca asta trebuie sa fie static

    public minionFactory(CardInput cardInput) {
        minionMap.put("Sentinel", new Sentinel(cardInput));
        minionMap.put("Berserker", new Berserker(cardInput));
        minionMap.put("Goliath", new Goliath(cardInput));
        minionMap.put("Warden", new Warden(cardInput));
        minionMap.put("The Ripper", new Ripper(cardInput));
        minionMap.put("Miraj", new Miraj(cardInput));
        minionMap.put("The Cursed One", new Cursed(cardInput));
        minionMap.put("Disciple", new Disciple(cardInput));
    }

    public static Minion getMinion(String minionType) {
        return minionMap.get(minionType);
    }
}
