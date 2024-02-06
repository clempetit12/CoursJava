package org.example.exceptions;

import java.util.ArrayList;

public class Cards {

    private ArrayList<String> cards = new ArrayList<>();

    //Méthode pour exception surveillée
    public ArrayList<String>  draw(int numberOfCards) throws MyException {
        if(numberOfCards > 4) {
            throw new MyException("4 cartes maximum !");
        }
        return new ArrayList<String>();

    }

    //Méthode pour exception non surveillée
    public String trade(int nbCards){
        if (nbCards > 2) {
            throw  new MySecondException("2 cartes maximum ");
        }
        return "Voila vos cartes : ";

    }

}
