package Cards;

import fileio.CardInput;
import fileio.DecksInput;
import fileio.StartGameInput;

import java.util.ArrayList;

public class Player {
    private int number;
    private int mana;
    private ArrayList<ArrayList<Minion>> decks;
    private ArrayList<Minion> playingDeck;
    private Hero hero;
    private ArrayList<Minion> hand;
    private int nrCardsInDeck;

    public Player(DecksInput d) {
        playingDeck = new ArrayList<>();
        hand = new ArrayList<>();
        int nrDecks = d.getNrDecks();
        nrCardsInDeck = d.getNrCardsInDeck();
        decks = new ArrayList<>();

        // Initializare decks

        for(int i = 0; i < nrDecks; i++) {
            ArrayList<Minion> currentDeck = new ArrayList<>();
            for (int j = 0; j < nrCardsInDeck; j++) {
                minionFactory factory = new minionFactory(d.getDecks().get(i).get(j));
                Minion card = factory.getMinion(d.getDecks().get(i).get(j).getName());
                if(card != null)
                    currentDeck.add(card);
            }
            decks.add(currentDeck);
        }
    }

    public ArrayList<Minion> getPlayingDeck() {
        return this.playingDeck;
    }

    public void setPlayingDeck(final ArrayList<Minion> playingDeck) {
        this.playingDeck = playingDeck;
    }

    public int getNrCardsInDeck() {
        return this.nrCardsInDeck;
    }

    public void setNrCardsInDeck(final int nrCardsInDeck) {
        this.nrCardsInDeck = nrCardsInDeck;
    }

    public ArrayList<Minion> getHand() {
        return this.hand;
    }

    public void setHand(final ArrayList<Minion> hand) {
        this.hand = hand;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(final int mana) {
        this.mana = mana;
    }

    public ArrayList<ArrayList<Minion>> getDecks() {
        return this.decks;
    }
    
    public ArrayList<Minion> getDeck(int index) {
        return this.decks.get(index);
    }

    public void setDecks(final ArrayList<ArrayList<Minion>> decks) {
        this.decks = decks;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setHero(final Hero hero) {
        this.hero = hero;
    }
}
