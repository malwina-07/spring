package pl.sda.util;

import pl.sda.model.Person;

public class PersonValidator {

    public void validate(Person person) {

        if(person == null){
            throw new IllegalArgumentException("Person is null");
        }
        if(person.getId()< 0){
            throw new IllegalArgumentException("Id is negetive");
        }
        if(person.getName() == null || person.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
        if(person.getSurname() == null || person.getSurname().isBlank()){
            throw new IllegalArgumentException("Surname is empty");
        }

    }
}
