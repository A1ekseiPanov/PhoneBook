package com.example.phonebook.services.Impl;

import com.example.phonebook.models.Person.Person;
import com.example.phonebook.security.User;
import com.example.phonebook.repositories.UserRepository;
import com.example.phonebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder ) {
        this.userRepository = userRepository;
        this.encoder = encoder;

    }

    @Override
    public User getUserByUsername(String user) {
        return userRepository.findByUsername(user).orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Person> getPersonList() {
        List<Person> persons = getAuthenticationUser().getPersons();
        return persons;
    }




    private User getAuthenticationUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getPersons());
        return user;
        //получаем авторизированного пользователя
    }



}
