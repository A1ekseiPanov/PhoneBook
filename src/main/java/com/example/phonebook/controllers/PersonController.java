package com.example.phonebook.controllers;

import com.example.phonebook.repositories.EmailTypeRepository;
import com.example.phonebook.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/persons")

@Controller
public class PersonController {

    private final PersonService personService;
    private final EmailTypeRepository emailTypeRepository;
    @Autowired
    public PersonController(PersonService personService, EmailTypeRepository emailTypeRepository) {
        this.personService = personService;
        this.emailTypeRepository = emailTypeRepository;
    }

    @GetMapping("")
    public String personPage(Model model){

        model.addAttribute("persons",
                personService.getAuthorizedPersons());
        return "/person/allPersons";
    }

    @GetMapping("/{id}")
    public String onePerson(@PathVariable("id") Long id, Model model ){
        model.addAttribute("persons",personService.getPerson(id));
        model.addAttribute("emailAndEmailType",personService.getEmailAndEmailType(id));
        model.addAttribute("phoneAndPhoneType",personService.getPhoneAndPhoneType(id));
        model.addAttribute("addressAndAddressType",personService.getAddressAndAddressType(id));
        model.addAttribute("organisation",personService.getOrganisation(id));
        model.addAttribute("post",personService.getPost(id));

        return "person/onePerson";
    }


}
