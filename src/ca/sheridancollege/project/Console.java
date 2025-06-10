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

        //Creating new scoreboard
        Scoreboard scoreboard = new Scoreboard();

//  Dealer draw 2 cards
//*********************************************************
        int continuePlay;
        while (true) {
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
            System.out.println("The total value of your hand is: " + player.getHandCards().getHandValue());
            int hitOrStand;
            while (true) {
                System.out.println("\nHit or Stand?");
                hitOrStand = validateInput("Enter 1 for Hit and 2 for Stand: ");
                if (hitOrStand == 1) {
                    System.out.println("\nYou have decided to hit");
                    Card playerCard3 = desk.drawCard();
                    player.getHandCards().getCards().add(playerCard3);
                    System.out.println("You have drawn a: " + playerCard3);
                    System.out.println("Cards of Player: ");

                    for (Card c : player.getHandCards().getCards()) {
                        System.out.println(c);
                    }

                    System.out.println("The total value of your hand is: " + player.getHandCards().getHandValue());
                    if (player.getHandCards().getHandValue() > 21) {
                        break;
                    }
                } else {
                    System.out.println("You chose to stand");
                    break;
                }
            }

            System.out.println("---------------------------------------------------");

            //dealer logic
            System.out.println("\nDealers second card: " + dealerCard2);

            //Cards of Dealer
            System.out.println("Dealer's Cards:");
            for (Card c : dealer.getHandCards().getCards()) {
                System.out.println("\t" + c);
            }

            //Total value of dealer's cards 
            int dealerTotal = dealer.getHandCards().getHandValue();
            System.out.println("\nDealer hand value: " + dealerTotal);

            //Dealer must hit if total < 17, if total > 21 they bust
            while (dealerTotal < 17) {
                Card newDealerCard = desk.drawCard();
                dealer.getHandCards().getCards().add(newDealerCard);
                System.out.println("\nDealer draws a: " + newDealerCard);

                dealerTotal = dealer.getHandCards().getHandValue();
                System.out.println("Dealer hand value: " + dealerTotal);
            }

            //bust logic 
            if (dealerTotal > 21) {
                System.out.println("\nDealer busts with: " + dealerTotal + " \nPLAYER WINS");
                scoreboard.addPlayerWin();

            } else {
                System.out.println("\nDealer stands with: " + dealerTotal);
            }

            //Compare the total value of Player and Dealer hand to see who wins
            if (dealerTotal >= player.getHandCards().getHandValue()) {
                System.out.println("\nDEALER WINS");
                scoreboard.addPlayerLoss();
            } else {
                System.out.println("\nPLAYER WINS");
                scoreboard.addPlayerWin();
            }
            scoreboard.printScore();

            continuePlay = validateInput("Enter 1 to continue to play or 2 to exit: ");
            if (continuePlay == 1) {
                dealer.getHandCards().getCards().clear();
                player.getHandCards().getCards().clear();
                continue;
            } else {
                System.exit(0);
            }
        }
    }

    public static int validateInput(String prompt) {
        Scanner s = new Scanner(System.in);
        int numb;

        while (true) {
            System.out.print(prompt);
            if (s.hasNextInt()) {
                numb = s.nextInt();
                if (numb == 1 || numb == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 for Hit or 2 for Stand! ");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer");
                s.next();
            }
        }
        return numb;
    }
}
