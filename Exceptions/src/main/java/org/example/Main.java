package org.example;

import org.example.exceptions.Cards;
import org.example.exceptions.MyException;

public class Main {
    public static void main(String[] args) {


        Cards cards =new Cards();
        cards.trade(1);

        try {
            cards.draw(5);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}