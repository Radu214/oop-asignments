package Cards;

import fileio.ActionsInput;
import fileio.GameInput;
import fileio.StartGameInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Game {
    private Player one;
    private Player two;
    private int playerOneDeckIdx;
    private int playerTwoDeckIdx;
    private int startingPlayer;
    private int shuffleSeed;
    private ArrayList<Action> actions = new ArrayList<>();



    public Game(Player o, Player t, GameInput s){
        this.one = o;
        this.two = t;
        playerOneDeckIdx = s.getStartGame().getPlayerOneDeckIdx();
        playerTwoDeckIdx = s.getStartGame().getPlayerTwoDeckIdx();
        startingPlayer = s.getStartGame().getStartingPlayer();
        shuffleSeed = s.getStartGame().getShuffleSeed();

        int nr = s.getActions().size();
        for(int i = 0; i < nr; i++) {
            Action act = new Action(s.getActions().get(i));
            actions.add(act);
        }

    }

    public void shuffleDecks(int shuffleSeed) {
       Collections.shuffle(one.getDecks().get(playerOneDeckIdx), new Random(shuffleSeed));
        Collections.shuffle(two.getDecks().get(playerTwoDeckIdx), new Random(shuffleSeed));
    }

    public void play() {
        int gainMana = 1;
        //ceva for
        one.getHand().add(one.getDeck(playerOneDeckIdx).remove(0));
        two.getHand().add(two.getDeck(playerTwoDeckIdx).remove(0));

        if(one.getMana() < 10)
            one.setMana(one.getMana() + gainMana);

        if(two.getMana() < 10)
            two.setMana(two.getMana() + gainMana);

        Action currentAction = actions.get(0);





    }


    public ArrayList<Action> getActions() {
        return this.actions;
    }

    public void setActions(final ArrayList<Action> actions) {
        this.actions = actions;
    }

    public Player getOne() {
        return this.one;
    }

    public void setOne(final Player one) {
        this.one = one;
    }

    public Player getTwo() {
        return this.two;
    }

    public void setTwo(final Player two) {
        this.two = two;
    }

    public int getPlayerOneDeckIdx() {
        return this.playerOneDeckIdx;
    }

    public void setPlayerOneDeckIdx(final int playerOneDeckIdx) {
        this.playerOneDeckIdx = playerOneDeckIdx;
    }

    public int getPlayerTwoDeckIdx() {
        return this.playerTwoDeckIdx;
    }

    public void setPlayerTwoDeckIdx(final int playerTwoDeckIdx) {
        this.playerTwoDeckIdx = playerTwoDeckIdx;
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
