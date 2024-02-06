package heritage.table_per_class;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Payment2 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

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
