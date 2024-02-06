package org.example.service;

import lombok.Data;
import org.example.dao.PersonDao;
import org.example.models.Person;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Data
public class PersonService {
    private PersonDao personDao;
    private Connection connection;

    public PersonService() {

            connection = DatabaseManager.getConnection();
            personDao = new PersonDao(connection);

    }

    public boolean createPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        try {
            return personDao.save(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updatePerson(Person person) {
        try {
            return personDao.update(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person getPerson(int id) {
        try {
            return personDao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletePerson(int id) {
        Person person1 = null;
        try {
            person1 = personDao.get(id);
            if (person1 != null) {
                return personDao.delete(person1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    public List<Person> getAllPersons() {
        try {
            return personDao.get();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    public void close() {
        DatabaseManager.closeConnection();
    }
}
