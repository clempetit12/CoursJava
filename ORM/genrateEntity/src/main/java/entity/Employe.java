package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @Column(name = "personne_id", nullable = false)
    private Integer id;

    @Column(name = "salaire", precision = 10, scale = 2)
    private BigDecimal salaire;

    @Column(name = "poste", length = 100)
    private String poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

}