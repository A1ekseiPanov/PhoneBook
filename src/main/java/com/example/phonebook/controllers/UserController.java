package com.example.phonebook.controllers;

import com.example.phonebook.models.Person.Person;
import com.example.phonebook.services.Impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class UserController {

    private final PersonServiceImpl userService;

    @Autowired
    public UserController(PersonServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello() {
        return "hello";
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Person getOne(@PathVariable("id") Long id){
        System.out.println(userService.getUser(id));

        return userService.getUser(id);
    }
}


