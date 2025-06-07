/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author Jimmy Dao
 * @author Grant Okawa
 * @author Nghi Lam Vo
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.cards = new ArrayList<Card>();
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() == 0) {
//            throw new Exception ("Empty desk/hand");
            return null;
        }
        return cards.remove(0);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getHandValue() {
        int total = 0;
        int aceCount = 0; 
    
        for (Card c : cards){
            StandardCard sc = (StandardCard) c;
            total += sc.getValue().getCardValue();
            if (sc.getValue() == StandardCard.Value.ACE){
                aceCount++;
            }
        }
        
        // If player draws a card and total is above 21 but has an ace
        // Make the ace value a 1 by reducing 10 from total
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount --;
        }
    
        return total;
    }

}//end class
