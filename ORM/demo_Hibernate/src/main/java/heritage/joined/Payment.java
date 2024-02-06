package heritage.joined;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPayment;

    private Double amount;

    private Date paymentDate = new Date();

    public void setId(Long id) {
        this.idPayment = id;
    }

    public Long getId() {
        return idPayment;
    }


}
