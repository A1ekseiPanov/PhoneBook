package com.example.phonebook.services;

import com.example.phonebook.models.Email1.Email;
import com.example.phonebook.models.Email1.EmailType;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Person.Person;
import com.example.phonebook.models.Post.Post;

import java.util.List;
import java.util.Map;

public interface PersonService {

    void add(Person user);

    Map<String, String> getEmailAndEmailType(Long id);

    Map<String, String> getPhoneAndPhoneType(Long id);

    Map<String, String> getAddressAndAddressType(Long id);

    List<Person> getAuthorizedPersons() ;

    Person getPerson(Long id);

    void deleteById(Long id);

    void update(Long id, Person updateUser);

    List<Person> getPersonList();

    Organisation getOrganisation(Long id);

    Post getPost(Long id);



}
