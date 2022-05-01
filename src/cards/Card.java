package cards;

public class Card {

    protected CardType type;
    protected String cardName;

    public Card(CardType type, String cardName) {
        this.type = type;
        this.cardName = cardName;
    }

    public CardType getType() {
        return type;
    }

    public String getCardName() {
        return cardName;
    }
}
