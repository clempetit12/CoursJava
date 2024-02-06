package org.example.poo.datastructure;

public abstract class Engine {

    //Classe abstract classe que l'on ne peut pas instancier + méthodes abstraites
    //Methodes abstraites methode qui n'a pas de corps != méthodes concrètes
    //public abstract void test() ;

    protected static int count;

    protected int id;

    protected int nombreDeRoues;

    protected String couleur;

    {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Engine.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreDeRoues() {
        return nombreDeRoues;
    }

    public void setNombreDeRoues(int nombreDeRoues) {
        this.nombreDeRoues = nombreDeRoues;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", nombreDeRoues=" + nombreDeRoues +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
