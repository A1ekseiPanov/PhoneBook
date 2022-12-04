package com.example.phonebook.util;

import com.example.phonebook.models.security.User;
import com.example.phonebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegValidator implements Validator {

    private final UserRepository userRepository;

    @Autowired
    public UserRegValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "Пользователь с таким логином существует");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            errors.rejectValue("email", "", "Пользователь с такой электронной почтой существует");

    }

}

