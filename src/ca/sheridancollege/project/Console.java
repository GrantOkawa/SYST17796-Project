/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

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
//      Show 1, keep 1
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
    }
}
