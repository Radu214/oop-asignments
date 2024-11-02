package Cards.Commands;

import Cards.Action;
import Cards.Game;
import Cards.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class getPlayerDeck implements Action {
    private int playerIdx;

    public getPlayerDeck(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public void execute(ArrayNode output, Game game) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        //Trebuie luat deckul full, inclusiv ce a tras deja, dar cred ca amestecat totusi
        ObjectNode objectNode = mapper.createObjectNode();
        ObjectNode outputNode = mapper.createObjectNode();

        outputNode.put("command", "getPlayerDeck");
        outputNode.put("playerIdx", playerIdx);
        //outputN.add(objectNode);
        for (int i = 0; i < game.getPlayers()[playerIdx - 1].getPlayingDeck().size(); i++) {
            ObjectNode jsonNode = game.getPlayers()[playerIdx - 1].getPlayingDeck().get(i).outputCard();
            arrayNode.add(jsonNode);
        }

        outputNode.put("output", arrayNode);
        output.add(outputNode);
    }
}
