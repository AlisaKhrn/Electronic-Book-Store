package com.example.ElectronicBookStore1.util;

import com.example.ElectronicBookStore1.model.Person;
import com.example.ElectronicBookStore1.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;


    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.getPerson(person.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "Пользователь с таким именем уже существует");
        }
    }
}
