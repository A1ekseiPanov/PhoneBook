package com.example.phonebook.repositories;

import com.example.phonebook.models.Email.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
}
