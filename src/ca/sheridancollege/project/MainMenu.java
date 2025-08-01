/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Jimmy
 */
public class MainMenu {
    private Scanner scanner;
    private Scoreboard scoreboard;
    private Blackjack blackjack;

    public MainMenu(Scoreboard scoreboard, Blackjack blackjack) {
        this.scanner = new Scanner(System.in);
        this.scoreboard = scoreboard;
        this.blackjack = blackjack;
    }

    public void menu() {
        while (true) {
            System.out.println("***** MAIN MENU *****");
            System.out.println("1) Play Game");
            System.out.println("2) Check Score");
            System.out.println("3) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    blackjack.play();
                    break;
                case "2":
                    System.out.println("===== Scoreboard =====");
                    scoreboard.printScore();
                    break;
                case "3":
                    System.out.println("Thanks for playing!");
                    return; // exit menu loop, return to main()
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
