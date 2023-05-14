import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Game() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer(deck);
    }

    public void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Shuffle the deck and deal two cards to the player and dealer
                deck.shuffle();
                player.clearHand();
                dealer.clearHand();
                player.addCard(deck.dealCard());
                player.addCard(deck.dealCard());
                dealer.addCard(deck.dealCard());
                dealer.addCard(deck.dealCard());
   
                // Show the initial hands
                player.showCards();
                dealer.showCards();
   
                // Ask the player if they want to hit or stand
                boolean playerStands = false;
                while (!playerStands && player.getHandValue() <= 21) {
                    System.out.print("Do you want to hit? (y/n) ");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("y")) {
                        player.addCard(deck.dealCard());
                        player.showCards();
                    } else {
                        playerStands = true;
                    }
                }
   
                // End the game if the player's score is over 21
                if (player.getHandValue() > 21) {
                    System.out.println("You bust! Dealer wins.");
                    return;
                }
   
                // Dealer's turn
                dealer.showCards();
                while (dealer.shouldDealerHit()) {
                    dealer.addCard(deck.dealCard());
                    dealer.showCards();
                }
   
                // Determine the winner
                int playerScore = player.getHandValue();
                int dealerScore = dealer.getHandValue();
                if (dealerScore > 21) {
                    System.out.println("Dealer busts! You win.");
                } else if (playerScore > dealerScore) {
                    System.out.println("You win!");
                } else if (dealerScore > playerScore) {
                    System.out.println("Dealer wins.");
                } else {
                    System.out.println("It's a tie!");
                }
   
                // Ask the player if they want to play again
                System.out.print("Do you want to play again? (y/n) ");
                String input = scanner.nextLine();
                if (!input.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
    }
}
