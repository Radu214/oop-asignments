package Cards;

import Cards.Commands.ActionsFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.GameInput;
import fileio.StartGameInput;
import Cards.Commands.ActionsFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Game {
    private Player[] players = new Player[2];
    private int[] playerDeckIdx = new int[2];

    private int startingPlayer;
    private int shuffleSeed;
    private ArrayList<Action> actions = new ArrayList<>();
    private Minion[][] table;
    private int currentPlayer;

//Carti speciale extends Minioni cred sau verific doar numele

    public Game(Player o, Player t, GameInput s){
        table = new Minion[4][5];
        this.players[0] = o;
        this.players[1] = t;
        playerDeckIdx[0] = s.getStartGame().getPlayerOneDeckIdx();
        playerDeckIdx[1] = s.getStartGame().getPlayerTwoDeckIdx();
        startingPlayer = s.getStartGame().getStartingPlayer();
        shuffleSeed = s.getStartGame().getShuffleSeed();

        int nr = s.getActions().size();
        for(int i = 0; i < nr; i++) {
            ActionsFactory factory = new ActionsFactory(s.getActions().get(i).getPlayerIdx());
            Action act = factory.getAction(s.getActions().get(i).getCommand());
            if(act != null)
                actions.add(act);
        }



    }

    public void shuffleDecks(int shuffleSeed) {
        ArrayList<Minion> playerOneDeckClone = (ArrayList<Minion>) players[0].getDecks().get(playerDeckIdx[0]).clone();
        ArrayList<Minion> playerTwoDeckClone = (ArrayList<Minion>) players[1].getDecks().get(playerDeckIdx[1]).clone();

    /*    ArrayList<Minion>[] playersShuffledDeck = new ArrayList[2];
        playersShuffledDeck[0] = (ArrayList<Minion>) players[0].getDecks().get(playerDeckIdx[0]).clone();
        playersShuffledDeck[1] = (ArrayList<Minion>) players[1].getDecks().get(playerDeckIdx[1]).clone();
*/

        players[0].setPlayingDeck(playerOneDeckClone);
        players[1].setPlayingDeck(playerTwoDeckClone);



        Collections.shuffle(players[0].getPlayingDeck(), new Random(shuffleSeed));
        Collections.shuffle(players[1].getPlayingDeck(), new Random(shuffleSeed));
    }

    public void play(ArrayNode output) {
        System.out.println(actions);
        int roundEnded = 0;
        int gainMana = 1;
        ObjectMapper mapper = new ObjectMapper();
        //ceva for
        currentPlayer = startingPlayer - 1;
        while(actions.size() > 0) {
            //Cand ar trebui sa aiba mana nu are.
            if(roundEnded == 0) {
                if (players[0].getPlayingDeck().size() > 0)
                    players[0].getHand().add(players[0].getPlayingDeck().remove(0));
                if (players[1].getPlayingDeck().size() > 0)
                    players[1].getHand().add(players[1].getPlayingDeck().remove(0));

                //Vad daca ambii la runda sau fiecare pe tura lui
                //Primeste mana
                //Daca sterg aceste if-uri moare testul 2
                if (players[0].getMana() < 10)
                    players[0].setMana(players[0].getMana() + gainMana);

                if (players[1].getMana() < 10)
                    players[1].setMana(players[1].getMana() + gainMana);
                gainMana++;
            }



//            Action currentAction = actions.remove(0);
//            currentAction.setCurrentGame(this);
            // doCommands command = new doCommands(currentAction, this);
            // System.out.println(currentAction.getPlayerIdx());
            //poate cu remove

            while (actions.size() > 0) {
                Action currentAction = actions.remove(0);
                if(currentAction.execute(output, this) == 1) {
                    if(roundEnded == 1)
                        roundEnded = 0;
                    else
                        roundEnded = 1;

                    break;
                }
            }
            //break;
        }




    }



    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(final Player[] players) {
        this.players = players;
    }

    public int[] getPlayerDeckIdx() {
        return this.playerDeckIdx;
    }

    public void setPlayerDeckIdx(final int[] playerDeckIdx) {
        this.playerDeckIdx = playerDeckIdx;
    }

    public Minion[][] getTable() {
        return this.table;
    }

    public void setTable(final Minion[][] table) {
        this.table = table;
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(final int currentPlayer) {
        this.currentPlayer = currentPlayer;
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
