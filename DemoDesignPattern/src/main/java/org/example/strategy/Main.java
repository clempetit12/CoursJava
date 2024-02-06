package org.example.strategy;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Order order = new Order.OrderBuilder().totalAmount(50).build();
        System.out.println("By Card");
        order.pay(new CardPaymentStrategy());

        System.out.println("Paypal");
        order.pay(new PaypalStrategy());
    }
}
