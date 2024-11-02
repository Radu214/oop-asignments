package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.HashMap;
import java.util.Map;

public class actionsFactory {
    int playerIdx;
    private static final Map<String, Action> commandMap = new HashMap<>();



    public actionsFactory(int idx){
        playerIdx = idx;
        commandMap.put("getCardsInHand", new getCardsInHand(playerIdx));
        commandMap.put("getPlayerDeck", new getPlayerDeck(playerIdx));
        commandMap.put("getPlayerHero", new getPlayerHero(playerIdx));
        commandMap.put("getPlayerTurn", new getPlayerTurn());
        // Add other commands here
    }

    public static Action getAction(String commandType) {
        return commandMap.get(commandType);
    }
}
