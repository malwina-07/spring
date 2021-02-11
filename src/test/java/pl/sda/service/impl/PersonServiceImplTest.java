package pl.sda.service.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.configuration.PersonConfiguration;
import pl.sda.model.Person;
import pl.sda.service.PersonService;

import java.io.IOException;

class PersonServiceImplTest {
    private ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(PersonConfiguration.class);

    @Test
    public void shouldAddNewPerson() throws IOException {
        //given
        PersonService underTest = applicationContext.getBean("personServiceImpl", PersonServiceImpl.class);

        int id = 1;
        String name = "Jan";
        String surname = "Kowalski";

        Person testPerson = new Person(id,name,surname);

        //when
        underTest.add(testPerson);

        //than
        Person actual = underTest.getById(Integer.toString(id));
        Assertions.assertEquals(id, actual.getId());
        Assertions.assertEquals(name, actual.getName());
        Assertions.assertEquals(surname, actual.getSurname());



    }


}