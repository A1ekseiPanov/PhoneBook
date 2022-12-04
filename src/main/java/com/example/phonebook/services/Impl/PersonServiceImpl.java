package com.example.phonebook.services.Impl;


import com.example.phonebook.models.Adress.Address;
import com.example.phonebook.models.Email1.Email;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Phone.Phone;
import com.example.phonebook.models.Post.Post;
import com.example.phonebook.models.Person.Person;
import com.example.phonebook.repositories.*;
import com.example.phonebook.services.PersonService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository userRepo;
        @Autowired
    public PersonServiceImpl(PersonRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override

    public List<Person> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Person getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) { userRepo.deleteById(id);}

    @Override
    public void update(Long id, Person updateUser) {
    updateUser.setId(id);
    userRepo.save(updateUser);
    }

    @Override
    @Transactional
    public void add(Person user) {
        userRepo.save(user);

    }

    public List<Email> getEmailByUserId(Long id) {
        Optional<Person> user = userRepo.findById(id);
        if (user.isPresent()) {
            Hibernate.initialize(user.get().getEmail());
            return user.get().getEmail();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Phone>getPhoneByUserId(Long id) {
        Optional<Person> user = userRepo.findById(id);
        if (user.isPresent()) {
            Hibernate.initialize(user.get().getPhone());
            return user.get().getPhone();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Address>getAddressByUserId(Long id) {
        Optional<Person> user = userRepo.findById(id);
        if (user.isPresent()) {
            Hibernate.initialize(user.get().getAddress());
            return user.get().getAddress();
        } else {
            return Collections.emptyList();
        }
    }

    public Organisation getUserOrganisation( Long id) {
        return userRepo.findById(id).map(Person::getOrganisations).orElse(null);
    }

    public Post getUserPost(Long id) {
        return userRepo.findById(id).map(Person::getPost).orElse(null);
    }


}


