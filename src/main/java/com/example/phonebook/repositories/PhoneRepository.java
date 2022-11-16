package com.example.phonebook.repositories;

import com.example.phonebook.models.Phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
