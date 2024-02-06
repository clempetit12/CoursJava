package org.example.generique;

// generique on ne sait quel est le type que l'on met dans la boite d'où utilisation générique

public class Boite<T> {

    private T contenu;

    public Boite(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }
}
