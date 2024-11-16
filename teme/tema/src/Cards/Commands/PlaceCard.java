package Cards.Commands;

import Cards.Action;
import Cards.Game;
import Cards.Minion;
import Cards.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PlaceCard implements Action {
    private int handIdx;

    public PlaceCard(int handIdx) {
        this.handIdx = handIdx;
    }

    @Override
    public int execute(ArrayNode output, Game game) {
        Player currentPlayer = game.getPlayers()[game.getCurrentPlayer()];
        int playerMana = currentPlayer.getMana();
        /*if (currentPlayer.getHand().size() == 0)
            return 0;*/
        Minion card = currentPlayer.getHand().get(handIdx);
        boolean error = false;

        //Verifica suficienta mana
        if (playerMana < card.getMana()) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode outputNode = mapper.createObjectNode();

            outputNode.put("command", "placeCard");
            outputNode.put("handIdx", handIdx);
            outputNode.put("error", "Not enough mana to place card on table.");
            output.add(outputNode);
            error = true;
            return 0;
        }

        //Verific daca are loc pe masa

        int row;
        if(card.getPlaceBack() == 0 && game.getCurrentPlayer() == 0)
            row = 2;
        else
            if(card.getPlaceBack() == 1 && game.getCurrentPlayer() == 0)
                row = 3;
            else
                if(card.getPlaceBack() == 0 && game.getCurrentPlayer() == 1)
                    row = 1;
                else
                    row = 0;
        for(int i = 0; i < 5; i++)
            if(game.getTable()[row][i] != null) {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode outputNode = mapper.createObjectNode();

                outputNode.put("command", "placeCard");
                outputNode.put("handIdx", handIdx);
                outputNode.put("error", "Cannot place card on table since row is full.");
                output.add(outputNode);
            }
        currentPlayer.getHand().remove(handIdx);
        card.placeCard(game, row);
        //game.getPlayers()[game.getCurrentPlayer()].getHand().remove(handIdx);
        return 0;
    }
}
