package board;

import cards.Card;

import java.util.ArrayList;

public class Hand implements Displayable {

    private ArrayList<Card> handList;

    public Hand() {
        handList = new ArrayList<>();
    }

    @Override
    public void add(Card card) {
        handList.add(card);
    }

    @Override
    public int size() {
        return handList.size();
    }

    @Override
    public Card getElementAt(int index) {
        return handList.get(index);
    }

    @Override
    public Card removeElement(int index) {
        return handList.remove(index);
    }
}
