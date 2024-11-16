package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetPlayerHero implements Action {
    private int playerIdx;

    public GetPlayerHero(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public int execute(ArrayNode output, Game game) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputNode = mapper.createObjectNode();

        outputNode.put("command", "getPlayerHero");
        outputNode.put("playerIdx", playerIdx);
        //arrayNode.add(objectNode);
        ObjectNode jsonNode = game.getPlayers()[playerIdx - 1].getHero().outputCard();
        outputNode.put("output", jsonNode);
        output.add(outputNode);
        return 0;
    }
}
