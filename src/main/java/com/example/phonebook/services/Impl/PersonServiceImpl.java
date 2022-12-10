package com.example.phonebook.services.Impl;


import com.example.phonebook.models.Address.Address;
import com.example.phonebook.models.Email1.Email;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Phone.Phone;
import com.example.phonebook.models.Post.Post;
import com.example.phonebook.models.Person.Person;
import com.example.phonebook.repositories.*;
import com.example.phonebook.security.User;
import com.example.phonebook.services.PersonService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
        @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {

        return personRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteById(Long id) { personRepository.deleteById(id);}

    @Override
    public void update(Long id, Person updateUser) {
    updateUser.setId(id);
    personRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void add(Person person) {
        personRepository.save(person);

    }

    public List<Email> getEmailList(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getEmail());
            return person.get().getEmail();
        } else {
            return Collections.emptyList();
        }
    }
    @Override
    public Map<String,String> getEmailAndEmailType(Long id){
        Map<String,String> email_EmailTypeMap = new HashMap<>();
        List<Email> emailPersonList = getEmailList(id);
        for(Email emails: emailPersonList){
            String email = emails.getName();
           String emailType =  emails.getEmailType().getName();
           email_EmailTypeMap. put(email,emailType);
        }
       return email_EmailTypeMap;
    }

    public List<Phone> getPhoneList(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getPhone());
            return person.get().getPhone();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Map<String, String> getPhoneAndPhoneType(Long id) {
        Map<String,String> phone_PhoneType = new HashMap<>();
        List<Phone> phones = getPhoneList(id);
        for(Phone phone : phones){
            String ph = phone.getPhoneNumber();
            String phType =  phone.getPhoneType().getName();
            phone_PhoneType. put(ph,phType);
        }
        return phone_PhoneType;
    }

    public List<Address> getAddressList(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getAddress());
            return person.get().getAddress();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Map<String, String> getAddressAndAddressType(Long id) {
        Map<String,String> address_addressType = new HashMap<>();
        List<Address> addresses = getAddressList(id);
        for(Address address: addresses){
            String addr = address.getAddress();
            String addressType =  address.getAddressType().getName();
            address_addressType. put(addr,addressType);
        }
        return address_addressType;
    }

    public List<Phone>getPhoneByUserId(Long id) {
        Optional<Person> user = personRepository.findById(id);
        if (user.isPresent()) {
            Hibernate.initialize(user.get().getPhone());
            return user.get().getPhone();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Address>getAddressByUserId(Long id) {
        Optional<Person> user = personRepository.findById(id);
        if (user.isPresent()) {
            Hibernate.initialize(user.get().getAddress());
            return user.get().getAddress();
        } else {
            return Collections.emptyList();
        }
    }


    @Override
    public Organisation getOrganisation( Long id) {
        return personRepository.findById(id).map(Person::getOrganisation).orElse(null);
    }

    @Override
    public Post getPost(Long id) {
        return personRepository.findById(id).map(Person::getPost).orElse(null);
    }



    @Override
    public List<Person> getAuthorizedPersons() {
        List<Person> persons = getAuthenticationUser().getPersons();
        return persons;
    }

    private User getAuthenticationUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
        //получаем авторизированного пользователя
    }


}


