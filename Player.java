import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
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
        System.out.println("Player's hand:");
        for (Card card : hand) {
            System.out.println(card.toString());
        }
        System.out.println("Total value: " + getHandValue());
    }

    public boolean wantsToHit() {
        return getHandValue() < 21;
    }

    public void clearHand() {
        hand.clear();
    }
}
