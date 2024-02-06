package heritage.table_per_class;


import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "paypal_payment")
public class PayPalPayment2 extends Payment2 {

    private String accountNumber;

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "accountNumber='" + accountNumber + '\'' +
                "} " + super.toString();
    }
}
