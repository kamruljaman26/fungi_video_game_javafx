package board;

import cards.Card;

import java.util.ArrayList;

public class Player {

    private Hand h;
    private Display d;
    private int score;
    private int handLimit;
    private int sticks;

    public Player() {
        // todo: init
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

    public void addStick(int s) {
        sticks += s;
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


    // ----------------

    public boolean takeCardFromTheForest(int i){
        // todo:
        return false;
    }

    public boolean takeFromDecay(){
        // todo:
        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> mushrooms){
        // todo: cook
        return false;
    }

    public boolean sellMushrooms(String s, int i){
        // todo: cook
        return false;
    }

    public boolean putPanDown(){
        // todo: cook
        return false;
    }
}
