/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Jimmy
 */
public class Scoreboard {
    
    private int playerWins;
    private int playerLosses;
    
    public void addPlayerWin() {
        playerWins++;
    }
    
    public void addPlayerLoss(){
        playerLosses++;
    }
    
    public void printScore(){
        System.out.println("The current score: ");
        System.out.println("Wins: " + playerWins);
        System.out.println("Losses: " + playerLosses);
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }
    
    
    
}
