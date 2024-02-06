package org.example.poo;

public class Product {

    protected int id;
    protected String name;

    //selectionner attributs puis clic droit generate constructor


    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //clic droit generate getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getBonjour(){
        System.out.println("Bonjour");
    }

    public  static void quiSuisJe() {
        System.out.println("je suis un produit");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //Par convention : 1) attributs / 2) constructor / 3) getter setter / 4)méthodes
}


