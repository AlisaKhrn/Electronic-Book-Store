package com.example.ElectronicBookStore1.services;

import com.example.ElectronicBookStore1.model.Person;
import com.example.ElectronicBookStore1.dao.PersonRepository;
import com.example.ElectronicBookStore1.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;


    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден");
        return new PersonDetails(person.get());
    }
}
