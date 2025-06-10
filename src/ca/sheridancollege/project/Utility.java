/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author lamvo
 */
public class Utility {
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
