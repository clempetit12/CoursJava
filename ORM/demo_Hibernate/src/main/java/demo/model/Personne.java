package demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "personne")
@Data
public class Personne {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    private String lastName;
    private String firstName;
    private int age;



    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdPerson() {
        return idPerson;
    }
}
