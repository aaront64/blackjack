public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer(deck);

        // deal initial cards
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        System.out.println("Your hand:");
        player.showCards();
        System.out.println();

        System.out.println("Dealer's hand:");
        dealer.showCards();
        System.out.println();

        // player's turn
        while (player.wantsToHit()) {
            Card card = deck.dealCard();
            player.addCard(card);
            System.out.println("You drew a " + card.toString());
            player.showCards();
            if (player.getHandValue() > 21) {
                System.out.println("You bust! Game over.");
                return;
            }
        }

        // dealer's turn
        dealer.playTurn();

        // determine winner
        int playerScore = player.getHandValue();
        int dealerScore = dealer.getHandValue();
        if (playerScore > dealerScore || dealerScore > 21) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }
}
