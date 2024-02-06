package org.example.visiteur;

public class Main {

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.accept(new UpdateVisitor());
        Keyboard keyboard = new Keyboard();
     keyboard.accept(new UpdateVisitor());

    }
}
