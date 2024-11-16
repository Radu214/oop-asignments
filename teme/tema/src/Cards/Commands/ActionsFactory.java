package Cards.Commands;

import Cards.Action;

import java.util.HashMap;
import java.util.Map;

public class ActionsFactory {
    int playerIdx;
    private static final Map<String, Action> commandMap = new HashMap<>(); //nu stiu daca asta trebuie sa fie static



    public ActionsFactory(int idx){
        playerIdx = idx;
        commandMap.put("getCardsInHand", new GetCardsInHand(playerIdx));
        commandMap.put("getPlayerDeck", new GetPlayerDeck(playerIdx));
        commandMap.put("getPlayerHero", new GetPlayerHero(playerIdx));
        commandMap.put("getPlayerTurn", new GetPlayerTurn());
        commandMap.put("endPlayerTurn", new EndPlayerTurn());
        commandMap.put("placeCard", new PlaceCard(playerIdx)); //playerIdx folosit ca handIdx
        commandMap.put("getPlayerMana", new GetPlayerMana(playerIdx));
        commandMap.put("getCardsOnTable", new GetCardsOnTable());

    }

    public static Action getAction(String commandType) {
        return commandMap.get(commandType);
    }
}
