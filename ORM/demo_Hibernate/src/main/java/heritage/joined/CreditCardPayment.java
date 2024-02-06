package heritage.joined;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "creditCard")
@Data
@PrimaryKeyJoinColumn(name = "idPayment")
public class CreditCardPayment extends Payment {


    private String cardNumber;

    private String expirationDate;


    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                "} " + super.toString();
    }
}
