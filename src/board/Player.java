package board;

import cards.Basket;
import cards.Card;
import cards.Pan;
import cards.Stick;

import java.util.ArrayList;

public class Player {

    private Hand h;
    private Display d;
    private int score;
    private int handLimit;
    private int sticks;

    public Player() {
        h = new Hand();
        d = new Display();
        score = 0;
        handLimit = 8;
        sticks = 0; //todo
        d.add(new Pan());
    }

    public int getScore() {
        return score;
    }

    public int getHandLimit() {
        return handLimit;
    }

    public int getStickNumber() {
        return sticks;
    }

    public void addSticks(int s) {
        sticks += s;

        // add Stickes into the display
        for (int i = 0; i < s; i++) {
            d.add(new Stick());
        }
    }

    public void removeStick(int s) {
        sticks -= s;
    }

    public Hand getHand() {
        return h;
    }

    public Display getDisplay() {
        return d;
    }

    public void addCardtoHand(Card card) {
        h.add(card);
    }

    public void addCardtoDisplay(Card card) {
        d.add(card);
    }

    // ---------------- // ------------

    public boolean takeCardFromTheForest(int range) {

        // range should be between 1-8
        if (range < 1 || range > 8) {
            return false;
        } else {
            if (range <= 2) {
                // retrieve card
                Card card = Board.getForest().getElementAt(Math.abs(range - 8));

                // if basket
                if (card instanceof Basket) {
                    d.add(card);
                    handLimit += 2;
                    return true;
                }

                // if not basket
                else {
                    if (h.size() < handLimit) {
                        h.add(card);
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            // into deep forest
            else {
                // check stickies for deep forest
                int needStick = range - 2;

                // if not have enough stick
                if (sticks < needStick) {
                    return false;
                }

                // if have enough stick
                else {
                    sticks -= needStick;
                    Card forestCard = Board.getForest().getElementAt(Math.abs(range - 8));

                    // remove stick from display
                    for (int i = 0; i < needStick; i++) {
                        for (int j = 0; j <= d.size(); j++) {
                            Card card = d.getElementAt(j);
                            if(card instanceof Stick){
                                d.removeElement(j);
                                break;
                            }
                        }
                    }

                    // if basket
                    if (forestCard instanceof Basket) {
                        d.add(forestCard);
                        handLimit += 2;
                        return true;
                    }

                    // if not basket
                    else {
                        if (h.size() < handLimit) {
                            h.add(forestCard);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }

    public boolean takeFromDecay() {
        // todo:
        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> mushrooms) {
        // todo: cook
        return false;
    }

    public boolean sellMushrooms(String s, int i) {
        // todo: cook
        return false;
    }

    public boolean putPanDown() {
        // todo: cook
        return false;
    }
}
