package Cards.Commands;

import Cards.Action;
import Cards.Game;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class EndPlayerTurn implements Action {
    @Override
    public int execute(ArrayNode output, Game game) {
        int currentPlayer = game.getCurrentPlayer();
        if(currentPlayer == 1)
            game.setCurrentPlayer(0);
        else
            game.setCurrentPlayer(1);
        return 1;
    }
}
