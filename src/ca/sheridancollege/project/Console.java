package ca.sheridancollege.project;
import java.util.Scanner;  // Import the Scanner class
/**
 *
 * @author lamvo
 */
public class Console {

    public static void main(String[] args) {
        Blackjack b1 = new Blackjack("Blackjack game");
//        Create Desk
        GroupOfCards desk = new GroupOfCards(52);
        for (StandardCard.Suit suit : StandardCard.Suit.values()) {
            for (StandardCard.Value value : StandardCard.Value.values()) {
                desk.getCards().add(new StandardCard(value, suit));
            }
        }
//        Shuffle
        desk.shuffle();

//        Create dealer and player
        BlackjackPlayer player = new BlackjackPlayer("Jimmy");
        BlackjackPlayer dealer = new BlackjackPlayer("Grant");

//  Dealer draw 2 cards
        Card dealerCard1 = desk.drawCard();
        Card dealerCard2 = desk.drawCard();
        dealer.getHandCards().getCards().add(dealerCard1);
        dealer.getHandCards().getCards().add(dealerCard2);
//      Show 1, hide 1
        System.out.println("Card 1 of Dealer: " + dealerCard1);

//        Player draw 2 cards
        Card playerCard1 = desk.drawCard();
        player.getHandCards().getCards().add(playerCard1);
        Card playerCard2 = desk.drawCard();
        player.getHandCards().getCards().add(playerCard2);
        System.out.println("Cards of Player: ");
        for (Card c : player.getHandCards().getCards()) {
            System.out.println(c);
        }
        
//      Hit or Stand

        Scanner playerInput = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.println("Hit or Stand?");
            System.out.println("Enter 1 for Hit and 2 for Stand");

            if (playerInput.hasNextInt()) {
            int hitOrStand = playerInput.nextInt();
            switch (hitOrStand) {
                case 1:
                    System.out.println("\nYou have decided to hit");
                    Card playerCard3 = desk.drawCard();
                    player.getHandCards().getCards().add(playerCard3);
                    System.out.println("You have drawn a: " + playerCard3);
                    System.out.println("Cards of Player: ");
                    for (Card c : player.getHandCards().getCards()) {
                    System.out.println(c);
                    }
                    validInput = true;
                    break;
                case 2:
                    System.out.println("\nYou have decided to stand");
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid number. Please enter 1 or 2.");
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                playerInput.next(); // Consume the invalid input to avoid an infinite loop
            }
        } while (!validInput);

        
    }
}
