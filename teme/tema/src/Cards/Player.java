package Cards;

import fileio.CardInput;
import fileio.DecksInput;
import fileio.StartGameInput;

import java.util.ArrayList;

public class Player {
    private int number;
    private int mana;
    private ArrayList<ArrayList<Card>> decks;
    private Hero hero;
    private ArrayList<Card> hand;

    public Player(DecksInput d) {
        hand = new ArrayList<>();
        int nrDecks = d.getNrDecks();
        int nrCardsInDeck = d.getNrCardsInDeck();
        decks = new ArrayList<>();

        // Initializare decks

        for(int i = 0; i < nrDecks; i++) {
            ArrayList<Card> currentDeck = new ArrayList<>();
            for (int j = 0; j < nrCardsInDeck; j++) {
                Card card = new Minion(d.getDecks().get(i).get(j));
                currentDeck.add(card);
            }
            decks.add(currentDeck);
        }
    }


    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void setHand(final ArrayList<Card> hand) {
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

    public ArrayList<ArrayList<Card>> getDecks() {
        return this.decks;
    }
    
    public ArrayList<Card> getDeck(int index) {
        return this.decks.get(index);
    }

    public void setDecks(final ArrayList<ArrayList<Card>> decks) {
        this.decks = decks;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setHero(final Hero hero) {
        this.hero = hero;
    }
}
