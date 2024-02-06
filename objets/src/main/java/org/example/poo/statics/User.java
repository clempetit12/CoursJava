package org.example.poo.statics;

public class User {

    //static propre à la classe
    public static final String DEFAULT_USER_GROUP = "customers";
    private static int counter;
    private int id;
    private String name;

    //à chaque fois je vais instancier user il incremente le counter
    {
        counter++;
    }

    public User() {
        this.id = counter;
    }

    public User(int id, String name) {
        this.id = counter++;
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
