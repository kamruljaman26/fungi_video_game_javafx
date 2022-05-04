package board;

import cards.Card;

import java.util.ArrayList;

public class Board {

    // properties
    private static CardPile forestCardsPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    public static void initialisePiles() {
        //todo: init piles
    }

    public static void setUpCards() {
        //todo: setup cards
    }

    public static CardPile getForestCardsPile() {
        return forestCardsPile;
    }

    public static CardList getForest() {
        return forest;
    }

    public static ArrayList<Card> getDecayPile() {
        return decayPile;
    }

    public static void updateDecayPile() {
        // todo: update decay pile
    }
}
