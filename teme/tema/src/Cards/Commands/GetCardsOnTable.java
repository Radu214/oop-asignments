package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import Cards.Minion;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GetCardsOnTable implements Action {
    @Override
    public int execute(ArrayNode output, Game game) {
        Minion[][] table = game.getTable();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputNode = mapper.createObjectNode();
        ArrayNode out = mapper.createArrayNode();
        ArrayNode rowArray = mapper.createArrayNode();

        outputNode.put("command", "getCardsOnTable");
        //output.add(outputNode);

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][j] != null)
                    rowArray.add(table[i][j].outputCard());
            }
            ArrayNode copyRow = rowArray.deepCopy();
            out.add(copyRow);
            rowArray.removeAll();
        }
        outputNode.put("output", out);
        output.add(outputNode);
        return 0;
    }
}
