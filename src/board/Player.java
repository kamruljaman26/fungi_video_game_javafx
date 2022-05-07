package board;

import cards.*;

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
        if (card instanceof Basket) {
            d.add(card);
            handLimit += 2;
        } else {
            h.add(card);
        }
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
                            if (card instanceof Stick) {
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

        ArrayList<Card> decayPile = Board.getDecayPile();


        // find basket
        int totalBasket = 0;
        for (Card card : decayPile) {
            if (card instanceof Basket) {
                totalBasket++;
            }
        }

        // if comprised of 4 card with 2 basket
        if (totalBasket >= 2) {
            for (Card card : decayPile) {
                if (card instanceof Basket) {
                    d.add(card);
                    handLimit += 2;
                } else {
                    h.add(card);
                }
            }
            return true;
        }

        // if have one
        if (totalBasket == 1 && handLimit >= (h.size() + decayPile.size() - 3)) {
            for (Card card : decayPile) {
                if (card instanceof Basket) {
                    d.add(card);
                    handLimit += 2;
                } else {
                    h.add(card);
                }
            }
            return true;
        }

        // for no basket
        if (totalBasket == 0 && handLimit >= (h.size() + decayPile.size())) {
            for (Card card : decayPile) {
                h.add(card);
            }
            return true;
        }

        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> mushrooms) {

        Pan pan = null;
        boolean panWithMushrooms = false;
        int totalMushrooms = 0;
        int butter = 0;
        int cider = 0;
        int other = 0;
        String mushroomName = null;
        int mushTypes = 1;

        for (Card card : mushrooms) {
            if (card instanceof Pan) {
                pan = (Pan) card;
                panWithMushrooms = true;
            } else if (card instanceof Mushroom) {
                Mushroom mushroom = (Mushroom) card;

                System.out.println(mushroom.getName());
                if (mushroomName == null) mushroomName = mushroom.getName();
                else if (!mushroomName.equals(mushroom.getName())) mushTypes++;

                if (mushroom.getType() == CardType.NIGHTMUSHROOM) totalMushrooms += 2;
                else totalMushrooms++;

            } else if (card instanceof Butter) {
                butter++;
            } else if (card instanceof Cider) {
                cider++;
            } else {
                other++;
            }
        }

        // find pan in display
        if (pan == null) {
            for (int i = 0; i < d.size(); i++) {
                Card card = d.getElementAt(i);
                if (card instanceof Pan) pan = (Pan) card;
            }
        }


        // if no pan and mushrooms are less then 3, return false
        if (pan == null || totalMushrooms < 3 || other > 0 || mushTypes > 1) return false;

        // if have cider or butter
        if (butter > 0 || cider > 0) {
            // 1 butter and 1 cider
            if (totalMushrooms >= 10) {
                score += 5 * cider; // points for cider
                score += 3 * butter; // points for cider
                cook(mushrooms, panWithMushrooms); // cook
                return true;
            } else if (butter == 1 && cider == 1 && totalMushrooms >= 9) {
                score += 3; // points for butter
                score += 5; // points for cider
                cook(mushrooms, panWithMushrooms); // cook
                return true;
            } else if (butter == 1 && cider == 0 &&  totalMushrooms >= 4) {
                score += 3 * butter; // points for butter
                cook(mushrooms, panWithMushrooms); // cook
                return true;
            } else if (butter == 2 && cider == 0 && totalMushrooms >= 8) {
                score += 3 * butter; // points for butter
                cook(mushrooms, panWithMushrooms); // cook
                return true;
            } else if (butter == 0 && cider == 1 && totalMushrooms >= 5) {
                score += 5 * cider; // points for butter
                cook(mushrooms, panWithMushrooms); // cook
                return true;
            } else {
                return false;
            }

        } else {
            cook(mushrooms, panWithMushrooms); // cook
            return true;
        }
    }


    // add points from mushrooms
    private void cook(ArrayList<Card> mushrooms, boolean isPanWithMushrooms) {
        for (Card card : mushrooms) {
            if (card instanceof Mushroom) {
                Mushroom mushroom = (Mushroom) card;
                if (mushroom.getType() == CardType.NIGHTMUSHROOM) score += mushroom.getFlavourPoints();
                score += mushroom.getFlavourPoints();
            }
        }

        // if pan from display remove it
        if (!isPanWithMushrooms) {
            for (int i = 0; i < d.size(); i++) {
                if (d.getElementAt(i) instanceof Pan) {
                    d.removeElement(i);
                    break;
                }
            }
        }
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
