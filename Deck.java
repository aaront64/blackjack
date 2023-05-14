import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    
    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card drawCard() {
        return cards.remove(0);
    }

    public Card dealCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }
}

