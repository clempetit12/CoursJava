package org.example.poo.statics;

public class Employee extends User {
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
