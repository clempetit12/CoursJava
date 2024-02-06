package org.example.observable;

public class Phone implements Observer{

    @Override
    public void update(Weather weather) {
        System.out.println("Phone with weather" );
    }
}
