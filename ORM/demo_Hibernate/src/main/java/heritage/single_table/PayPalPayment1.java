package heritage.single_table;


import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@DiscriminatorValue("1")
public class PayPalPayment1 extends Payment1 {

    private String accountNumber;

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "accountNumber='" + accountNumber + '\'' +
                "} " + super.toString();
    }
}
