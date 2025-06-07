/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author lamvo
 */
public class StandardCard extends Card {

    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
        EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        
        private final int cardValue;
        
        private Value(int cardValue) {this.cardValue = cardValue;}
        
        public int getCardValue() {return cardValue;}
    }

    private Value value;
    private Suit suit;

    public StandardCard (Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
