package org.example.strategy;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private double totalAmount;

    public void pay(PaymentStrategy paymentStrategy) {
        if ((paymentStrategy.pay(totalAmount))) {
            System.out.println("order confirmed");
        } else {
            System.out.println("order denied");
        }

    }
}
