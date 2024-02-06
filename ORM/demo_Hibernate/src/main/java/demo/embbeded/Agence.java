package demo.embbeded;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Agence {

    @EmbeddedId

    private AgenceId agenceId;

    private String adress;

    public Agence(AgenceId agenceId, String adress) {
        this.agenceId = agenceId;
        this.adress = adress;
    }

    public Agence() {
    }


}
