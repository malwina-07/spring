package pl.sda.dao.impl;

import pl.sda.dao.PersonDao;
import pl.sda.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPersonDao implements PersonDao {

    private List<Person> persons = new ArrayList<>();

    @Override
    public void add(Person person) {
        persons.add(person);
    }

    @Override
    public Person getById(int id) {

        for (Person p : persons) {
            if (p.getId() == id) {
                return p;
            }

        }
        throw new IllegalArgumentException("Unrecognized id");
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public void deleteById(int id) {
        persons.remove(id);
    }
}
