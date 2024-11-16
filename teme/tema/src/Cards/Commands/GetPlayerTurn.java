package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetPlayerTurn implements Action {

    @Override
    public int execute(ArrayNode output, Game game) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode outputNode = mapper.createObjectNode();
        outputNode.put("command", "getPlayerTurn");
        outputNode.put("output", game.getCurrentPlayer() + 1);
        output.add(outputNode);
        return 0;
    }

}
