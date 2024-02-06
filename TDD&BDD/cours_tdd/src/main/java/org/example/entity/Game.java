package org.example.entity;

public class Game {

    private RealDice dice;

    public Game(RealDice dice) {
        this.dice = dice;
    }

    public boolean play() {
        return dice.getValue() %2 ==0;
    }
}
