package heritage.single_table;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER)
@Data
public abstract class Payment1 {

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
