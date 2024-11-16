package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetPlayerMana implements Action {
    private int playerIdx;

    public GetPlayerMana(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    @Override
    public int execute(ArrayNode output, Game game) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputNode = mapper.createObjectNode();

        outputNode.put("command", "getPlayerMana");
        outputNode.put("playerIdx", playerIdx);
        outputNode.put("output", game.getPlayers()[playerIdx - 1].getMana());

        output.add(outputNode);
        return 0;
    }
}
