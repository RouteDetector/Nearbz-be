package com.danijelsudimac.Nearbz.service;

import com.danijelsudimac.Nearbz.dto.Status;
import com.danijelsudimac.Nearbz.model.Person;
import com.danijelsudimac.Nearbz.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) throws IOException {
        person = personRepository.save(person);
        if (person == null)
            throw new IOException();
        else
            return person;
    }

    public Person getPerson(Long personId) throws IOException {
        Optional<Person> opPerson = personRepository.findById(personId);
        if(opPerson.isEmpty())
            throw new IOException();
        else
            return opPerson.get();
    }
}
