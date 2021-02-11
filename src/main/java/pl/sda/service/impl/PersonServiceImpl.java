package pl.sda.service.impl;

import pl.sda.dao.PersonDao;
import pl.sda.model.Person;
import pl.sda.service.PersonService;
import pl.sda.util.PersonUtil;
import pl.sda.util.PersonValidator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// klasa wystawiana dla klienta w naszym przypadku klasa Main
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    private final PersonUtil personUtil;

    private final PersonValidator personValidator;

    public PersonServiceImpl(PersonDao personDao, PersonUtil personUtil, PersonValidator personValidator) {
        this.personDao = personDao;
        this.personUtil = personUtil;
        this.personValidator = personValidator;
    }

    @Override
    public void add(Person person) throws IOException { // exception pochodzi z PersonDao.FilePersonDao
        personValidator.validate(person);
        personDao.add(person);
    }

    @Override
    public Person getById(String id) {

        int parsedId = personUtil.parseIdToInd(id);

        return personDao.getById(parsedId);
    }

    // TODO: 10.02.2021 zamienić wartość zwracaną na List<Person>
    @Override
    public List<String> getAllSortedBySurname() {
        List<Person> allPersons = personDao.getAll();
        return allPersons.parallelStream()
                .sorted()
                .map(Person::getSurname)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) throws IOException {
        int parsedId = personUtil.parseIdToInd(id);
        personDao.deleteById(parsedId);
        return true;
    }
}
