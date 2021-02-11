package pl.sda.dao;

import pl.sda.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonDao {
    //narzucenie kontraktu - ogólny, wysokopoziomowy

    void add(Person person) throws IOException;

    Person getById(int id);

    List<Person> getAll();

    void deleteById(int id) throws IOException;

}
