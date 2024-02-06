package org.example.abstractFactory;

public class Main {
    public static void main(String[] args) {

        //Application pour mac
        Application application = new Application(new Macfactory());

        //Application pour windows
        Application application1 = new Application(new WinFactory());

        System.out.println(application1);



    }
}
