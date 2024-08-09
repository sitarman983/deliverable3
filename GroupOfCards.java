package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<WarCard> cards;
    private int size;

    public GroupOfCards(ArrayList<WarCard> cards) {
        this.cards = cards;
        this.size = cards.size();
    }

    public GroupOfCards(int givenSize) {
        size = givenSize;
        cards = new ArrayList<>(size);
    }

    public ArrayList<WarCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<WarCard> cards) {
        this.cards = cards;
        this.size = cards.size();
    }

    public ArrayList<WarCard> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }
}
