package Cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import fileio.Coordinates;

public interface Action {
//    private String command;
//    private int handIdx;
//    private Coordinates cardAttacker;
//    private Coordinates cardAttacked;
//    private int affectedRow;
//    private int playerIdx;
//    private int x;
//    private int y;
//    private Game currentGame;



//    public Action(ActionsInput a) {
//        command = a.getCommand();
//        handIdx = a.getHandIdx();
//        cardAttacker = a.getCardAttacker();
//        cardAttacked = a.getCardAttacked();
//        affectedRow = a.getAffectedRow();
//        playerIdx = a.getPlayerIdx();
//        x = a.getX();
//        y = a.getY();
//    }

//    public Action() {
//
//    }
    //Returneaza 0 daca nu se termina tura sau 1 daca se termina
    public int execute(ArrayNode output, Game game);

}
