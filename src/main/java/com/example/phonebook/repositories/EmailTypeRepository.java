package com.example.phonebook.repositories;

import com.example.phonebook.models.Email.EmailType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTypeRepository extends JpaRepository<EmailType,Long> {
}
