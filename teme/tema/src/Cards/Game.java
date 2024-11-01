package Cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.StartGameInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Game {
    private Player[] players = new Player[2];
    private int[] playerDeckIdx = new int[2];

    private int startingPlayer;
    private int shuffleSeed;
    private ArrayList<Action> actions = new ArrayList<>();



    public Game(Player o, Player t, GameInput s){
        this.players[0] = o;
        this.players[1] = t;
        playerDeckIdx[0] = s.getStartGame().getPlayerOneDeckIdx();
        playerDeckIdx[1] = s.getStartGame().getPlayerTwoDeckIdx();
        startingPlayer = s.getStartGame().getStartingPlayer();
        shuffleSeed = s.getStartGame().getShuffleSeed();

        int nr = s.getActions().size();
        for(int i = 0; i < nr; i++) {
            Action act = new Action(s.getActions().get(i));
            actions.add(act);
        }

    }

    public void shuffleDecks(int shuffleSeed) {
       Collections.shuffle(players[0].getDecks().get(playerDeckIdx[0]), new Random(shuffleSeed));
        Collections.shuffle(players[1].getDecks().get(playerDeckIdx[1]), new Random(shuffleSeed));
    }

    public void play(ArrayNode output) {
        int gainMana = 1;
        ObjectMapper mapper = new ObjectMapper();
        //ceva for
        int actionIndex = 0;
        for(int curAcc = 0; curAcc < actions.size(); curAcc++) {
            if (players[0].getDeck(playerDeckIdx[0]).size() > 0)
                players[0].getHand().add(players[0].getDeck(playerDeckIdx[0]).remove(0));
            if (players[1].getDeck(playerDeckIdx[1]).size() > 0)
            players[1].getHand().add(players[1].getDeck(playerDeckIdx[1]).remove(0));

            if (players[0].getMana() < 10)
                players[0].setMana(players[0].getMana() + gainMana);

            if (players[1].getMana() < 10)
                players[1].setMana(players[1].getMana() + gainMana);

            gainMana++;

            Action currentAction = actions.get(actionIndex);
            // System.out.println(currentAction.getPlayerIdx());
            actionIndex++;//poate cu remove
            ArrayNode arrayNode = mapper.createArrayNode();

            switch (currentAction.getCommand()) {
                case "getCardsInHand" : {
                    ObjectNode objectNode = mapper.createObjectNode();
                    objectNode.put("command", "getCardsInHand");
                    objectNode.put("playerIdx", currentAction.getPlayerIdx());
                    output.add(objectNode);
                    for(int i = 0; i < players[currentAction.getPlayerIdx() - 1].getHand().size(); i++) {
                        ObjectNode jsonNode = players[currentAction.getPlayerIdx() - 1].getHand().get(i).outputCard();
                        arrayNode.add(jsonNode);
                    }
                    ObjectNode outputNode = mapper.createObjectNode();
                    outputNode.put("output", arrayNode);
                    output.add(outputNode);
                    break;
                }
                case "getPlayerDeck" : {
                    ObjectNode objectNode = mapper.createObjectNode();
                    objectNode.put("command", "getPlayerDeck");
                    objectNode.put("playerIdx", currentAction.getPlayerIdx());
                    output.add(objectNode);
                    for(int i = 0; i < players[currentAction.getPlayerIdx() - 1].getDeck(playerDeckIdx[currentAction.getPlayerIdx() - 1]).size(); i++) {
                        ObjectNode jsonNode = players[currentAction.getPlayerIdx() - 1].getDeck(playerDeckIdx[currentAction.getPlayerIdx() - 1]).get(i).outputCard();
                        arrayNode.add(jsonNode);
                    }
                    ObjectNode outputNode = mapper.createObjectNode();
                    outputNode.put("output", arrayNode);
                    output.add(outputNode);
                    break;
                }
                case "getPlayerHero" : {
                    ObjectNode objectNode = mapper.createObjectNode();
                    objectNode.put("command", "getPlayerHero");
                    objectNode.put("playerIdx", currentAction.getPlayerIdx());
                    output.add(objectNode);
                    ObjectNode jsonNode = players[currentAction.getPlayerIdx() - 1].getHero().outputCard();
                    arrayNode.add(jsonNode);
                    ObjectNode outputNode = mapper.createObjectNode();
                    outputNode.put("output", arrayNode);
                    output.add(outputNode);
                    break;
                }
            }
            //break;
        }




    }


    public ArrayList<Action> getActions() {
        return this.actions;
    }

    public void setActions(final ArrayList<Action> actions) {
        this.actions = actions;
    }

    public Player getOne() {
        return this.players[0];
    }

    public void setOne(final Player one) {
        this.players[0] = one;
    }

    public Player getTwo() {
        return this.players[1];
    }

    public void setTwo(final Player two) {
        this.players[0] = two;
    }

    public int getPlayerDeckIdx(int index) {
        return this.playerDeckIdx[index];
    }

    public void setPlayerDeckIdx(final int playerDeckIdx, int index) {
        this.playerDeckIdx[index] = playerDeckIdx;
    }

    public int getStartingPlayer() {
        return this.startingPlayer;
    }

    public void setStartingPlayer(final int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public int getShuffleSeed() {
        return this.shuffleSeed;
    }

    public void setShuffleSeed(final int shuffleSeed) {
        this.shuffleSeed = shuffleSeed;
    }
}
