package com.example.phonebook.repositories;

import com.example.phonebook.models.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByNameStartsWith(String name);


}
