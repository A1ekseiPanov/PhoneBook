package com.example.phonebook.services;

import com.example.phonebook.models.Person.Person;

import java.util.List;

public interface PersonService {

    void add(Person user);

    List<Person> getUsers() ;

    Person getUser(Long id);

    void deleteById(Long id);

    void update(Long id, Person updateUser);

}
