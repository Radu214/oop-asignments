package Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Card {
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
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
