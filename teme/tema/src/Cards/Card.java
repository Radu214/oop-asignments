package Cards;

import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

import java.util.ArrayList;

abstract public class Card {
    private int mana;
    private String description;
    private ArrayList<String> colors;
    private String name;


    public Card(CardInput c) {
        mana = c.getMana();
        description = c.getDescription();
        colors = c.getColors();
        name = c.getName();
    }

    public ObjectNode outputCard() {
        return null;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(final int mana) {
        this.mana = mana;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ArrayList<String> getColors() {
        return this.colors;
    }

    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
