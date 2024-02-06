package org.example.singleton;

import org.example.demo_builderlombock.Person;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static  Storage instance = null;
    private List<Person> personlist;


    private Storage() {
        personlist = new ArrayList<>();
    }

    public static Storage getInstance() {
        if (instance == null){
            synchronized (Storage.class){
                Storage.getInstance().getpersonList();
            }
        }
        return instance;
    }

    public List<Person> getpersonList() {
        return personlist;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "personlist=" + personlist +
                '}';
    }
}
