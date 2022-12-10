package com.example.phonebook.controllers;

import com.example.phonebook.models.Person.Person;
import com.example.phonebook.security.User;
import com.example.phonebook.services.PersonService;
import com.example.phonebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello(@AuthenticationPrincipal User user , Model model) {
        model.addAttribute("dayTime",dayTime());
        model.addAttribute("user",user);
        return "hello";
    }

    private String dayTime(){
        final LocalTime time = LocalTime.now();
        if (time.getHour() >= 0 && time.getHour() < 6) {
           return  "Доброй ночи";
        } else if (time.getHour() >= 6 && time.getHour() < 12) {
            return "Доброе утро";
        } else if (time.getHour() >= 12 && time.getHour() < 18) {
            return "Доброй день";
        } else {
            return  "Доброй вечер";
        }
    }

}


