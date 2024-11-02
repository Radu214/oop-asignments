package Cards.Commands;
import Cards.Action;
import Cards.Game;
import Cards.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class getCardsInHand implements Action {
    private int playerIdx;

    public getCardsInHand(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public void execute(ArrayNode output, Game game) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("command", "getCardsInHand");
        objectNode.put("playerIdx", playerIdx);
        output.add(objectNode);
        for (int i = 0; i < game.getPlayers()[playerIdx - 1].getHand().size(); i++) {
            ObjectNode jsonNode = game.getPlayers()[playerIdx - 1].getHand().get(i).outputCard();
            arrayNode.add(jsonNode);
        }
        ObjectNode outputNode = mapper.createObjectNode();
        outputNode.put("output", arrayNode);
        output.add(outputNode);

    }


    public int getPlayerIdx() {
        return this.playerIdx;
    }


    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }
}
