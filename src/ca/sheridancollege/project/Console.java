package ca.sheridancollege.project;

import java.util.Scanner;  // Import the Scanner class

/**
 *
 * @author lamvo
 */
public class Console {

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        Blackjack b1 = new Blackjack("Blackjack game", scoreboard);
//       Create dealer and player
        BlackjackPlayer player = new BlackjackPlayer("Jimmy");
        BlackjackPlayer dealer = new BlackjackPlayer("Grant");
        b1.getPlayers().add(dealer);
        b1.getPlayers().add(player);
        
        //Create main menu and run it
        MainMenu mainMenu = new MainMenu(scoreboard, b1);
        mainMenu.menu();
    }
}
