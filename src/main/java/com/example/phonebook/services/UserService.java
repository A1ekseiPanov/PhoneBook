package com.example.phonebook.services;

import com.example.phonebook.models.Person.Person;
import com.example.phonebook.security.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUserByUsername(String user);
    void save(User user);
    Optional<User> getUser(Long id);

    Iterable<User> getUsers();

    List<Person> getPersonList();
}
