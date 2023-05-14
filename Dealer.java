import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;
    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
        hand = new ArrayList<Card>();
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public Card dealCard() {
        return deck.drawCard();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;
        for (Card card : hand) {
            if (card.getRank() == Rank.ACE) {
                numAces++;
            }
            value += card.getValue();
        }
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }
        return value;
    }

    public void showCards() {
        System.out.println("Dealer's hand:");
        for (Card card : hand) {
            System.out.println(card.toString());
        }
        System.out.println("Total value: " + getHandValue());
    }

    public boolean wantsToHit() {
        return getHandValue() < 17;
    }

    public void clearHand() {
        hand.clear();
    }

    public void playTurn() {
        while (wantsToHit()) {
            addCard(dealCard());
            showCards();
            if (getHandValue() > 21) {
                System.out.println("Dealer busts!");
                break;
            }
        }
    }

    public boolean shouldDealerHit() {
        if (getHandValue() < 17) {
            return true;
        } else if (getHandValue() == 17) {
            for (Card card : hand) {
                if (card.getRank() == Rank.ACE) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
