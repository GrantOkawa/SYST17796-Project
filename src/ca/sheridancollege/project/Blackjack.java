/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Jimmy
 */
public class Blackjack extends Game {

    private Scoreboard scoreboard;
    private GroupOfCards deck;

    public Blackjack(String name, Scoreboard scoreboard) {
        super(name);
        this.scoreboard = scoreboard;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }

    public void initializeDeckWithCards() {
        this.deck = new GroupOfCards(52);
        for (StandardCard.Suit suit : StandardCard.Suit.values()) {
            for (StandardCard.Value value : StandardCard.Value.values()) {
                this.getDeck().getCards().add(new StandardCard(value, suit));
            }
        }
        this.getDeck().shuffle();
    }

    @Override
    public void play() {
        Utility util = new Utility();
        int continuePlay;
        while (true) {
            this.initializeDeckWithCards();
            Card dealerCard1 = deck.drawCard();
            Card dealerCard2 = deck.drawCard();
            BlackjackPlayer dealer = (BlackjackPlayer) this.getPlayers().get(0);
            BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(1);
            dealer.play(dealerCard1);
            dealer.play(dealerCard2);
//      Show 1, hide 1
            System.out.println("Card 1 of Dealer: " + dealerCard1);

//        Player draw 2 cards
            Card playerCard1 = deck.drawCard();
            player.play(playerCard1);
            Card playerCard2 = deck.drawCard();
            player.play(playerCard2);

            System.out.println("Cards of Player: ");
            for (Card c : player.getHandCards().getCards()) {
                System.out.println(c);
            }
            System.out.println("The total value of your hand is: " + player.getHandCards().getHandValue());
            int hitOrStand;
            while (true) {
                System.out.println("\nHit or Stand?");
                hitOrStand = util.validateInput("Enter 1 for Hit and 2 for Stand: ");
                if (hitOrStand == 1) {
                    System.out.println("\nYou have decided to hit");
                    Card playerCard3 = deck.drawCard();
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
            if (player.getHandCards().getHandValue() > 21) {
                declareWinner();
                continuePlay = util.validateInput("Enter 1 to continue to play or 2 to exit: ");
                if (continuePlay == 1) {
                    dealer.getHandCards().getCards().clear();
                    player.getHandCards().getCards().clear();
                    continue;
                } else {
                    System.exit(0);
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
            int dealerTotal = dealer.getHandCards().getHandValue();
            System.out.println("\nDealer hand value: " + dealerTotal);

            //Dealer must hit if total < 17, if total > 21 they bust
            while (dealerTotal < 17) {
                Card newDealerCard = deck.drawCard();
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
            declareWinner();
            continuePlay = util.validateInput("Enter 1 to continue to play or 2 to exit: ");
            if (continuePlay == 1) {
                dealer.getHandCards().getCards().clear();
                player.getHandCards().getCards().clear();
                continue;
            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void declareWinner() {
        BlackjackPlayer dealer = (BlackjackPlayer) this.getPlayers().get(0);
        BlackjackPlayer player = (BlackjackPlayer) this.getPlayers().get(1);
        //Total value of dealer's cards 
        int dealerTotal = dealer.getHandCards().getHandValue();
        if (player.getHandCards().getHandValue() > 21) {
            System.out.println("\nDEALER WINS");
            scoreboard.addPlayerLoss();
        } else //Compare the total value of Player and Dealer hand to see who wins
        if (dealerTotal >= player.getHandCards().getHandValue()) {
            System.out.println("\nDEALER WINS");
            scoreboard.addPlayerLoss();
        } else {
            System.out.println("\nPLAYER WINS");
            scoreboard.addPlayerWin();
        }
        scoreboard.printScore();
    }
}
