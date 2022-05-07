package board;

import cards.Card;

import java.util.ArrayList;

public class Display implements Displayable {

    private ArrayList<Card> displayList;

    public Display() {
        displayList = new ArrayList<>();
    }

    @Override
    public void add(Card card) {
        displayList.add(card);
    }

    @Override
    public int size() {
        return displayList.size();
    }

    @Override
    public Card getElementAt(int index) {
        return displayList.get(index);
    }

    @Override
    public Card removeElement(int index) {
        return displayList.remove(index);
    }
}
