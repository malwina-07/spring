package pl.sda.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.configuration.PersonConfiguration;
import pl.sda.model.Person;
import pl.sda.service.PersonService;
import pl.sda.service.impl.PersonServiceImpl;

import java.io.IOException;

public class SpringMain {
    public static void main(String[] args) throws IOException {

// Towrzenie instancji kontenera (kontekstu)
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(PersonConfiguration.class);

//zamiast rzutować na Object co zwraca nam .getBean() określamy w drugim argumencie .getBean() jaką klase obiektu się spodziewamy

        PersonService personService = applicationContext.getBean("personServiceImpl", PersonServiceImpl.class);

// wywołanie metody biznesowej

        personService.add(new Person(1, "Jan", "Kowalski"));

        Person personById = personService.getById("1");

        System.out.println(personById);
    }
}
