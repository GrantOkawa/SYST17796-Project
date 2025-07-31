package ca.sheridancollege.project;

import java.util.Scanner;  // Import the Scanner class

/**
 *
 * @author lamvo
 */
public class Console {

    public static void main(String[] args) {
        Blackjack b1 = new Blackjack("Blackjack game", new Scoreboard());
//       Create dealer and player
        BlackjackPlayer player = new BlackjackPlayer("Jimmy");
        BlackjackPlayer dealer = new BlackjackPlayer("Grant");
        b1.getPlayers().add(dealer);
        b1.getPlayers().add(player);
        b1.play();
    }
}
