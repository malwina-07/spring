package pl.sda.service;

import pl.sda.model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PersonService {

    void add(Person person) throws IOException;

    Person getById(String id);

    List<String> getAllSortedBySurname();

    boolean deleteById(String id) throws IOException;

}
