package com.example.phonebook.services;

import com.example.phonebook.models.security.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByUsername(String user);
    void save(User user);
    Optional<User> getUser(Long id);

    Iterable<User> getUsers();
}
