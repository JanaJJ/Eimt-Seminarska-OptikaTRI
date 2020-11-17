package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.model.Roles;
import com.example.demo.model.exceptions.UserAlreadyExistsException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RolesRepository roleRepository;

    @Override
    public Person findById(Long id) {
        return this.personRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Person registerPerson(Person person) {
        if (this.personRepository.existsById(person.getId())) {
            throw new UserAlreadyExistsException(person.getEmail());
        }
        return this.personRepository.save(person);

    }

    @Override
    public void deletePersonById(Long id) {this.personRepository.deleteById(id); }

    @Override
    public void deletePerson(Person person) {this.personRepository.delete(person); }
}
