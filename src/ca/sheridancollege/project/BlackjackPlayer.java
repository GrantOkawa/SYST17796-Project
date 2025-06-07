/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author lamvo
 */
public class BlackjackPlayer extends Player {

    private GroupOfCards cards;
    public BlackjackPlayer(String name) {
        super(name);
        cards = new GroupOfCards(5);
    }

    public GroupOfCards getHandCards() {
        return cards;
    }

    public void setCards(GroupOfCards cards) {
        this.cards = cards;
    }

    @Override
    public void play() {
    }
}
