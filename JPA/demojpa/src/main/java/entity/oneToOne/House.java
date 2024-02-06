package entity.oneToOne;

import javax.persistence.*;

@Entity
@Table(name="maison")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maison_id")
    private Long id;

    private Integer size;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(cascade = CascadeType.PERSIST)
    // referencedColumnName nom colonne autre table clé étrangère dans table adress, name nom de la clé primaire dans maison
    @JoinColumn(name="adresse_id",referencedColumnName = "id_adresse")
    // ce nom que l'on donne à la propriété que l'on met dans mapped
    private Adress adress;

    public House() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", size=" + size +
                ", type=" + type +
                ", adress=" + adress +
                '}';
    }
}
