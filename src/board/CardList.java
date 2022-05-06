package board;

import cards.Card;

import java.util.ArrayList;

public class CardList {

    private ArrayList<Card> cList;

    public CardList() {
        cList = new ArrayList<>();
    }

    public void add(Card card) {
        cList.add(card);
    }

    public int size() {
        return cList.size();
    }

    public Card getElementAt(int index) {
        return cList.get(index);
    }

    public Card removeElement(int index) {
        return cList.remove(Math.abs(index-8));
    }
}
