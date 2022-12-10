package com.example.phonebook.controllers;

import com.example.phonebook.security.RegistrationForm;
import com.example.phonebook.services.UserService;
import com.example.phonebook.util.UserRegValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;
    private final UserRegValidator validator;

    @Autowired
    public RegistrationController(UserService userService, UserRegValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @GetMapping("")
    public String registerForm(@ModelAttribute("form") RegistrationForm form) {
        return "register";
    }

    @PostMapping("")
    public String processRegistration(@ModelAttribute("form")  @Valid RegistrationForm form, Errors errors) {
        if(!form.getPassword().equals(form.getConfirm())){
            errors.rejectValue("confirm", "" , " Пароли не совпадают");
        }
        validator.validate(form.toUser(),errors);
        if(errors.hasErrors()){


            return "register";
        }
        userService.save(form.toUser());
        return "redirect:auth/login";
    }


}
