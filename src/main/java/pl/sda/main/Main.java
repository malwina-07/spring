package pl.sda.main;

import pl.sda.dao.PersonDao;
import pl.sda.dao.impl.FilePersonDao;
import pl.sda.dao.impl.MockPersonDao;
import pl.sda.model.Person;
import pl.sda.service.PersonService;
import pl.sda.service.impl.PersonServiceImpl;
import pl.sda.util.PersonUtil;
import pl.sda.util.PersonValidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//zależności
        PersonDao personDao = new MockPersonDao();
        PersonUtil personUtil = new PersonUtil();
        PersonValidator personValidator = new PersonValidator();

// przekazanie zależności
        PersonService personService = new PersonServiceImpl(personDao, personUtil, personValidator);

// wywołanie metody biznesowej

//        personService.add(new Person(1, "Jan", "Kowalski"));
//        personService.add(new Person(2, "Jan", "Kowalski"));
//        personService.add(new Person(3, "Jan", "Kowalski"));

        Person personById = personService.getById("1");

//        personDao.getAll();
//        System.out.println(personDao.getAll());
//        System.out.println(personById);
personDao.deleteById(1);
    }
}
