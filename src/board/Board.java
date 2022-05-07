package board;

import cards.*;

import java.util.ArrayList;

public class Board {

    // properties
    private static CardPile forestCardsPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    // init all piles
    public static void initialisePiles() {
        forestCardsPile = new CardPile();
        forest = new CardList();
        decayPile = new ArrayList<>();
    }

    // add all cards
    public static void setUpCards() {

        // Honey Fungus
        HoneyFungus honeyFungusNight = new HoneyFungus(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(honeyFungusNight);
        for (int i = 0; i < 10; i++) {
            HoneyFungus honeyFungus = new HoneyFungus(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(honeyFungus);
        }

        // Tree Ear
        TreeEar treeEarNight = new TreeEar(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(treeEarNight);
        for (int i = 0; i < 8; i++) {
            TreeEar treeEar = new TreeEar(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(treeEar);
        }

        // Honey Fungus
        LawyersWig lawyersWigNight = new LawyersWig(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(lawyersWigNight);
        for (int i = 0; i < 6; i++) {
            LawyersWig lawyersWig = new LawyersWig(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(lawyersWig);
        }

        // Shiitake
        Shiitake shiitakeNight = new Shiitake(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(shiitakeNight);
        for (int i = 0; i < 5; i++) {
            Shiitake shiitake = new Shiitake(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(shiitake);
        }

        // Hen Of Woods
        HenOfWoods henOfWoodsNight = new HenOfWoods(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(henOfWoodsNight);
        for (int i = 0; i < 5; i++) {
            HenOfWoods henOfWoods = new HenOfWoods(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(henOfWoods);
        }

        // Birch Bolete
        BirchBolete birchBoleteNight = new BirchBolete(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(birchBoleteNight);
        for (int i = 0; i < 4; i++) {
            BirchBolete birchBolete = new BirchBolete(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(birchBolete);
        }

        // Porcini
        Porcini porciniNight = new Porcini(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(porciniNight);
        for (int i = 0; i < 4; i++) {
            Porcini porcini = new Porcini(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(porcini);
        }

        // Chanterelle
        Chanterelle chanterelleNight = new Chanterelle(CardType.NIGHTMUSHROOM);
        forestCardsPile.addCard(chanterelleNight);
        for (int i = 0; i < 4; i++) {
            Chanterelle chanterelle = new Chanterelle(CardType.DAYMUSHROOM);
            forestCardsPile.addCard(chanterelle);
        }

        // Morel
        for (int i = 0; i < 3; i++) {
            Morel morel = new Morel(CardType.NIGHTMUSHROOM);
            forestCardsPile.addCard(morel);
        }

        // // setup others card

        // Butter
        for (int i = 0; i < 3; i++) {
            Butter butter = new Butter();
            forestCardsPile.addCard(butter);
        }

        // Cider
        for (int i = 0; i < 3; i++) {
            Cider cider = new Cider();
            forestCardsPile.addCard(cider);
        }

        // Pan
        for (int i = 0; i < 11; i++) {
            Pan pan = new Pan();
            forestCardsPile.addCard(pan);
        }

        // Pan
        for (int i = 0; i < 5; i++) {
            Pan pan = new Pan();
            forestCardsPile.addCard(pan);
        }

        System.out.println(forestCardsPile.pileSize());
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
        if (decayPile.size() >= 4) {
            decayPile.subList(0, 4).clear();
            decayPile.add(forestCardsPile.drawCard());
        }else {
            decayPile.add(forestCardsPile.drawCard());
        }
    }
}
